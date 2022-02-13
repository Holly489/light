package fiction.spider.impl;

import fiction.popj.ChapterItem;
import fiction.popj.FictionItem;
import fiction.spider.FictionSpider;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import threadutils.ThreadMethodPool;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 1031
 */
public class WanbenFictionSpider implements FictionSpider {

    public String baseUrl = "https://xinwanben.com";

    private Pattern pattern = Pattern.compile("<a href=\"(.*?)\"><span class=\"next\">下一页</span></a>");

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void spiderAsHtml() throws Exception {
        System.out.println("请输入小说名：");
        String fictionName = scanner.nextLine();
        String s = getCatalogueSearch(fictionName);
        FictionItem fictionItem = getCatalogueUrl(s);
        String catalogueUrl = fictionItem.getUrl();
        fictionName = fictionItem.getName();
        //获取章节列表
        List<ChapterItem> chapterList = getChapterList(catalogueUrl);
        //创建目录html文件
        createRootHtml(fictionName, chapterList);
        ThreadMethodPool threadMethodPool = new ThreadMethodPool(5);
        String finalFictionName = fictionName;
        //用线程池处理
        threadMethodPool.<ChapterItem>map((chapterItem) -> {
            String url = chapterItem.getUrl();
            String savePath = getSaveHtmlPath(finalFictionName, chapterItem);
            File file = new File(savePath);
            if (file.exists()) {
                System.out.println("已下载的章节无需下载");
                return;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Map<String, String> map1 = getContentAsHtml(url);
                String content = map1.get("readerCon");
                String readPage = map1.get("readPage");
                stringBuffer.append(content);
                //如果存在本章未完，点击下一页继续阅读字样，
                // 从源代码中找到下一页拿到链接继续请求直到拿完所有的内容
                if (content.contains("本章未完，点击下一页继续阅读")) {
                    while (true) {
                        Map map = getNextUrl(readPage);
                        Boolean isFind = (Boolean) map.get("isFind");
                        String nextUrl = (String) map.get("nextUrl");
                        if (!isFind) {
                            break;
                        }
                        System.out.println("存在下一页，继续爬取");
                        Map<String, String> map2 = getContentAsHtml(nextUrl);
                        content = map2.get("readerCon");
                        readPage = map2.get("readPage");
                        stringBuffer.append(content);
                        if (!content.contains("本章未完，点击下一页继续阅读")) {
                            break;
                        }
                    }
                }
                content = stringBuffer.toString();
                //除杂
                content = removeImpurity(content);
                //创建章节网页
                createChapterHtml(content, chapterItem, chapterList.size(), savePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, chapterList);
    }


    @Override
    public void spiderAsTxt() throws Exception {
        System.out.println("请输入小说名：");
        String fictionName = scanner.nextLine();
        String s = getCatalogueSearch(fictionName);
        FictionItem fictionItem = getCatalogueUrl(s);
        String catalogueUrl = fictionItem.getUrl();
        fictionName = fictionItem.getName();
        List<ChapterItem> chapterList = getChapterList(catalogueUrl);
        ThreadMethodPool threadMethodPool = new ThreadMethodPool(5);
        String finalFictionName = fictionName;
        threadMethodPool.<ChapterItem>map((chapterItem) -> {
            String url = chapterItem.getUrl();
            String savePath = getSaveTxtPath(finalFictionName, chapterItem);
            File file = new File(savePath);
            if (file.exists()) {
                System.out.println("已下载的章节无需下载");
                return;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Map<String, String> map1 = getContent(url);
                String content = map1.get("readerCon");
                String readPage = map1.get("readPage");
                stringBuffer.append(content);
                if (content.contains("本章未完，点击下一页继续阅读")) {
                    while (true) {
                        Map map = getNextUrl(readPage);
                        Boolean isFind = (Boolean) map.get("isFind");
                        String nextUrl = (String) map.get("nextUrl");
                        if (!isFind) {
                            break;
                        }
                        System.out.println("存在下一页，继续爬取");
                        Map<String, String> map2 = getContent(nextUrl);
                        content = map2.get("readerCon");
                        readPage = map2.get("readPage");
                        stringBuffer.append(content);
                        if (!content.contains("本章未完，点击下一页继续阅读")) {
                            break;
                        }
                    }
                }
                content = stringBuffer.toString();
                content = removeImpurity(content);
                writeContentToLocal(content, savePath);
                System.out.println(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, chapterList);
    }

    public Map<String, Object> getNextUrl(String context) {
        boolean isFind = false;
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()) {
            context = matcher.group();
            isFind = true;
        }
        int i = context.indexOf("https");
        int i1 = context.indexOf("\"><span class=\"next\">");
        context = context.substring(i, i1);
        Map<String, Object> map = new HashMap<>(2);
        map.put("isFind", isFind);
        map.put("nextUrl", context);
        return map;
    }

    @Override
    public String removeImpurity(String content) {
        content = content.replaceAll("(完本神站|一秒记住、永不丢失！|www.wanbentxt.com|章节错误，长时间未更新，请留言，我们会尽快处理！|m.wanbentxt.com|一秒记住.↘完\\^本.神\\^站.首\\^发↘.手机用户输入地址：|..\\^完.本.神.站...|把本站分享那些需要的小伙伴！找不到书请留言！|(<a ([^>]*?)>)(.*?)(</a>))", "");
        return content;
    }

    @Override
    public List<ChapterItem> getChapterList(String url) throws Exception {
        // 连接类的父类，抽象类
        URLConnection urlConnection = new URL(url).openConnection();
        // http的连接类
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        //设置超时
        httpURLConnection.setConnectTimeout(15000);
        //设置请求方式，默认是GET
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36");
        httpURLConnection.setRequestProperty("Origin", "https://xinwanben.com");
        httpURLConnection.setRequestProperty("Referer", "https://xinwanben.com/");

        InputStream inputStream = httpURLConnection.getInputStream();
        Document document = Jsoup.parse(inputStream, "GBK", url);
        Elements elements = document.select(
                ".chapter>ul>li>a");
        List<ChapterItem> list = new ArrayList<ChapterItem>(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            String href = baseUrl + element.attr("href");
            String text = element.text();
            list.add(new ChapterItem(i, text, href));
        }
        return list;
    }

    @Override
    public String getChapterContent(String url) throws Exception {
        return null;
    }

    public Map<String, String> getContent(String url) throws Exception {
        // 连接类的父类，抽象类
        URLConnection urlConnection = new URL(url).openConnection();
        // http的连接类
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        //设置超时
        httpURLConnection.setConnectTimeout(15000);
        //设置请求方式，默认是GET
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36");
        httpURLConnection.setRequestProperty("Origin", "https://xinwanben.com");
        httpURLConnection.setRequestProperty("Referer", "https://xinwanben.com/");

        InputStream inputStream = httpURLConnection.getInputStream();
        Document document = Jsoup.parse(inputStream, "GBK", url);
        Element element = document.selectFirst(".readerCon");
        Element element1 = document.selectFirst(".readPage");
        HashMap<String, String> map = new HashMap<>();
        map.put("readerCon", element.wholeText());
        map.put("readPage", element1.toString());
        return map;
    }

    public Map<String, String> getContentAsHtml(String url) throws Exception {
        // 连接类的父类，抽象类
        URLConnection urlConnection = new URL(url).openConnection();
        // http的连接类
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        //设置超时
        httpURLConnection.setConnectTimeout(15000);
        //设置请求方式，默认是GET
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36");
        httpURLConnection.setRequestProperty("Origin", "https://xinwanben.com");
        httpURLConnection.setRequestProperty("Referer", "https://xinwanben.com/");

        InputStream inputStream = httpURLConnection.getInputStream();
        Document document = Jsoup.parse(inputStream, "GBK", url);
        Element element = document.selectFirst(".readerCon");
        Element element1 = document.selectFirst(".readPage");
        HashMap<String, String> map = new HashMap<>();
        map.put("readerCon", element.toString());
        map.put("readPage", element1.toString());
        return map;
    }

    @Override
    public String getChapterContentAsHtml(String url) throws Exception {
        return null;
    }

    @Override
    public FictionItem getCatalogueUrl(String html) throws Exception {
        Document document = Jsoup.parse(html);
        Elements elements1 = document.select(".listBottom>ul>a>li>h4");
        Elements elements2 = document.select(".listBottom>ul>a>li>h5");
        Elements elements3 = document.select(".listBottom>ul>a");
        System.out.println("序列号\t资源名\t作者\t目录链接");
        for (int i = 0; i < elements3.size(); i++) {
            System.out.println(i + "\t" + elements1.get(i).text() + "\t" + elements2.get(i).text()
                    + "\t" + baseUrl + elements3.get(i).attr("href"));
        }
        System.out.println("请输入序列号");
        int i = scanner.nextInt();
        String s = baseUrl + elements3.get(i).attr("href");
        String name = elements1.get(i).text();
        return new FictionItem(name, s);
    }

    @Override
    public String getCatalogueSearch(String searchKeyWord) throws Exception {
        String url = "https://m.xinwanben.com/s.php";
        Connection connection = Jsoup.connect(url)
                .ignoreContentType(true)
                .method(Connection.Method.POST)
                .timeout(15000)
                .header("User-Agent", "Mozilla/5.0 (Linux; Android 4.1.1; Nexus 7 Build/JRO03D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Safari/535.19")
                .header("Origin", "https://m.xinwanben.com")
                .header("Referer", "https://m.xinwanben.com/")
                .data("keyword", searchKeyWord);
        Connection.Response response = connection.execute();
        String html = response.body();
        return html;
    }
}
