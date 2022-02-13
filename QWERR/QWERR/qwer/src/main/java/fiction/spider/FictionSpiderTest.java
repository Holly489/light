package fiction.spider;

import fiction.spider.impl.WanbenFictionSpider;

/**
 * @author 1031
 */
public class FictionSpiderTest {
    public static void main(String[] args) throws Exception {
        WanbenFictionSpider wanbenFictionSpider = new WanbenFictionSpider();
        //https://xinwanben.com去这个网址看看有什么可以搜到的
        wanbenFictionSpider.spiderAsHtml();
        //wanbenFictionSpider.spiderAsTxt();
    }
}
