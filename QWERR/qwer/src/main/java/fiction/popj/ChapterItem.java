package fiction.popj;

public class ChapterItem {

    private int index;//第几章

    private String title;//章节名

    private String url;//章节目录

    public ChapterItem() {

    }

    public ChapterItem(int index, String title, String url) {
        this.index = index;
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ChapterItem{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", url='" + url +
                '}';
    }
}
