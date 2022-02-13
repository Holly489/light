package fiction.spider;

/**
 * @author 1031
 */
public enum HtmlTemplate {

    Root("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title></title>\n" +
            "    <link rel=\"stylesheet\" href=\"../res/css/materialize.min.css\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1\" />\n" +
            "    <link rel=\"shortcut icon\" href=\"../res/ico.ico\" type=\"image/x-icon\"/>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div id=\"main-content\">\n" +
            "    <ul class=\"collection with-header\" >\n" +
            "        <li class=\"collection-header\" style=\"font-size: 20px;font-weight: bold;\" id=\"title\"></li>\n" +
            "    </ul>\n" +
            "</div>\n" +
            "<footer class=\"page-footer\" style=\"background: #fff;color: #000;margin-top: 10px;\">\n" +
            "    <div class=\"footer-copyright\">\n" +
            "        <div class=\"container\" style=\"color: #000\">\n" +
            "            123\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</footer>\n" +
            "</body>\n" +
            "<script type=\"text/javascript\">\n" +
            "    var title = \"标题\";\n" +
            "    document.title = title;\n" +
            "    document.getElementById(\"title\").innerText =title;\n" +
            "</script>\n" +
            "</html>\n"),

    Chapter("<!DOCTYPE html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "    <title></title>\n" +
            "    <link rel=\"shortcut icon\" href=\"../res/ico.ico\" type=\"image/x-icon\"/>\n" +
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"../res/css/css.css\">\n" +
            "</head>\n" +
            "<body id=\"zj\" class=\"gb\">\n" +
            "<header id=\"header\" class=\"header dise\">\n" +
            "    <div class=\"zhong\"></div>\n" +
            "</header>\n" +
            "    <div class=\"nr_page\">\n" +
            "        <a class=\"dise preNext\" style=\"width:30%;\">上一章</a>\n" +
            "        <a class=\"dise\" style=\"width:30%;\" href=\"root.html\" >目录</a>\n" +
            "        <a class=\"dise preNext\" style=\"width:30%;\">下一章</a>\n" +
            "        <div class=\"cc\"></div>\n" +
            "    </div>\n" +
            "    <div class=\"content\"></div>\n" +
            "    <div class=\"nr_page\">\n" +
            "        <a class=\"dise preNext\" style=\"width:30%;\">上一章</a>\n" +
            "        <a class=\"dise\" style=\"width:30%;\" href=\"root.html\">目录</a>\n" +
            "        <a class=\"dise preNext\" style=\"width:30%;\">下一章</a>\n" +
            "        <div class=\"cc\"></div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "<script type=\"text/javascript\">\n" +
            "    var title = \"标题\";\n" +
            "    var pre = \"a.html\";\n" +
            "    var next = \"c.html\";\n" +
            "    document.title = title;\n" +
            "    document.getElementsByClassName(\"zhong\")[0].innerText =title;\n" +
            "    var preCurrNextList = document.getElementsByClassName(\"preNext\");\n" +
            "    preCurrNextList[0].href = pre;\n" +
            "    preCurrNextList[1].href = next;\n" +
            "    preCurrNextList[2].href = pre;\n" +
            "    preCurrNextList[3].href = next;\n" +
            "</script>\n" +
            "</html>\n");

    private String template;

    HtmlTemplate() {
    }

    HtmlTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
