package fiction.spider;

import fiction.popj.ChapterItem;
import fiction.popj.FictionItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 1031
 */
public interface FictionSpider {

    /**
     * 保存小说的基本目录，一般位于项目根路径下的fiction文件夹下
     */
    String WORKDIR = System.getProperty("user.dir") + "/fiction";

    /**
     * 该正则表达式用来去除windows系统不支持的文件名字符
     */
    Pattern PATTERN = Pattern.compile("[\\/\\\\\\:\\*\\?\\\"\\<\\>\\|]"); /* '/ \ : * ? " < > |'*/

    /**
     * 爬取小说保存为html格式
     *
     * @throws Exception
     */
    void spiderAsHtml() throws Exception;

    /**
     * 爬取小说保存为txt格式
     *
     * @throws Exception
     */
    void spiderAsTxt() throws Exception;


    /**
     * 创建目录html文件
     *
     * @param fictionName 小说名
     * @param chapterList 保存小说所有章节信息的列表
     */
    default void createRootHtml(String fictionName, List<ChapterItem> chapterList) {
        String rootHtmlTemplate = HtmlTemplate.Root.getTemplate();

        rootHtmlTemplate = rootHtmlTemplate.replaceAll("var title = \"标题\"", "var title = \"" + fictionName + "\"");

        Document doc = Jsoup.parse(rootHtmlTemplate);
        Element elem = doc.selectFirst(".with-header");

        for (int k = 0; k < chapterList.size(); k++) {
            ChapterItem chapterItem = chapterList.get(k);
            //往class为with-header的标签逐一追加li标签，也就是追加目录列
            elem.append("<li class=\"collection-header\"><a href=\"" + k + ".html\">" + chapterItem.getTitle() + "</a></li>");
        }
        writeContentToLocal(doc.toString(), getSaveRootHtmlPath(fictionName));
        System.out.println("createRootHtml");
    }

    /**
     * 创建章节网页
     *
     * @param content     章节内容
     * @param chapterItem 该章节的对象
     * @param listSize    章节列表的大小
     * @param savePath    保存html文件的路径
     */
    default void createChapterHtml(String content, ChapterItem chapterItem, int listSize, String savePath) {
        String htmlTemplate = HtmlTemplate.Chapter.getTemplate();
        int index = chapterItem.getIndex();
        String title = chapterItem.getTitle();
        htmlTemplate = htmlTemplate.replaceAll("var title = \"标题\"", "var title = \"" + title + "\"");
        int pre = index - 1;
        if (pre < 0) {
            pre = 0;
        }
        htmlTemplate = htmlTemplate.replaceAll("var pre = \"a.html\"", "var pre = \"" + pre + ".html\"");
        int next = index + 1;
        if (next > listSize - 1) {
            next = index;
        }
        htmlTemplate = htmlTemplate.replaceAll("c.html", next + ".html");
        Document document = Jsoup.parse(htmlTemplate);
        Element element = document.selectFirst(".content");
        element.append(content);
        document.normalise();
        writeContentToLocal(document.toString(), savePath);
        System.out.println(chapterItem.getUrl());
    }

    /**
     * 获取该章小说的txt所应该存放的路径
     *
     * @param fictionName 小说名
     * @param chapterItem 章节对象
     * @return 该章小说的txt所应该存放的路径
     */
    default String getSaveTxtPath(String fictionName, ChapterItem chapterItem) {
        int index = chapterItem.getIndex();
        String title = validateFileName(chapterItem.getTitle());
        StringBuffer stringBuffer = new StringBuffer(WORKDIR);
        stringBuffer.append("/")
                .append(fictionName)
                .append("/")
                .append(index)
                .append(".")
                .append(title)
                .append(".txt");
        return stringBuffer.toString();
    }

    /**
     * 获取该章小说的html所应该存放的路径
     *
     * @param fictionName 小说名
     * @param chapterItem 章节对象
     * @return 该章小说的html所应该存放的路径
     */
    default String getSaveHtmlPath(String fictionName, ChapterItem chapterItem) {
        int index = chapterItem.getIndex();
        StringBuffer stringBuffer = new StringBuffer(WORKDIR);
        stringBuffer.append("/")
                .append(fictionName)
                .append("/")
                .append(index)
                .append(".html");
        return stringBuffer.toString();
    }

    /**
     * 获取该章小说的目录html所应该存放的路径
     *
     * @param fictionName 小说名
     * @return 该章小说的目录html所应该存放的路径
     */
    default String getSaveRootHtmlPath(String fictionName) {
        StringBuffer stringBuffer = new StringBuffer(WORKDIR);
        stringBuffer.append("/")
                .append(fictionName)
                .append("/root.html");
        return stringBuffer.toString();
    }

    /**
     * @param content 原内容
     * @return 去除没用的内容（除杂）
     */
    String removeImpurity(String content);

    /**
     * 获取章节的信息，包括每个章节的标题和链接
     *
     * @param url 目录网页的url
     * @return
     * @throws Exception
     */
    List<ChapterItem> getChapterList(String url) throws Exception;


    /**
     * @param url 指定章节的url
     * @return 指定章节的内容
     * @throws Exception
     */
    String getChapterContent(String url) throws Exception;

    /**
     * @param url 指定章节的url
     * @return 指定章节的内容的html
     * @throws Exception
     */
    String getChapterContentAsHtml(String url) throws Exception;


    /**
     * @param html 搜索目录的源代码
     * @return 指定资源的目录链接和小说名
     */
    FictionItem getCatalogueUrl(String html) throws Exception;


    /**
     * @return 获取搜索目录的响应体
     * @throws Exception
     */
    String getCatalogueSearch(String searchKeyWord) throws Exception;

    /**
     * @param content 待写入的字符串
     * @param dest    写入的目的地
     * @return
     */
    default boolean writeContentToLocal(String content, String dest) {
        FileWriter fileWriter = null;
        try {
            File file = new File(dest);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * @param content 待写入的字符串
     * @param dest    写入的目的地
     * @param append  是否追加
     * @return
     */
    default boolean writeContentToLocal(String content, String dest, boolean append) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File(dest), append);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * 去除windows系统不支持的非法字符，操作系统不允许保存文件名存在非法字符的文件
     *
     * @param fileName 原文件名
     * @return 过滤后的文件名
     */
    default String validateFileName(String fileName) {
        Matcher matcher = PATTERN.matcher(fileName);
        String newFileName = matcher.replaceAll(""); // 将匹配到的非法字符以空替换
        return newFileName;
    }
}
