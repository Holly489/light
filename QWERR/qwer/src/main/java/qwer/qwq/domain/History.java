package qwer.qwq.domain;

/**
 * 浏览历史实体类
 * @author 10316
 *
 */
public class History {
	//文章标题
	private String history_article;
	//文章路径
	private String history_uri;
	//历史记录id
	private int history_id;
	public History() {};
	public History(String history_article, String history_uri, int history_id) {
		super();
		this.history_article = history_article;
		this.history_uri = history_uri;
		this.history_id = history_id;
	}
	public String getHistory_article() {
		return history_article;
	}
	public void setHistory_article(String history_article) {
		this.history_article = history_article;
	}
	public String getHistory_uri() {
		return history_uri;
	}
	public void setHistory_uri(String history_uri) {
		this.history_uri = history_uri;
	}
	public int getHistory_id() {
		return history_id;
	}
	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}
	@Override
	public String toString() {
		return "History [history_article=" + history_article + ", history_uri=" + history_uri + ", history_id="
				+ history_id + "]";
	}
	
}
