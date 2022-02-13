package qwer.qwq.domain;

import java.util.Date;

public class Article {
	//文章id
	//private int article_id;
	//文章标题
	private String article_title;
	//文章作者
	private String article_author;
	//文章发表日期
	private Date article_date;
	//文章内容
	private String article_content;
	//文章照片路径
	private String article_img_uri;
	public Article() {}
	public Article(String article_title, String article_author, Date article_date, String article_content,
			String article_img_uri) {
		super();
		this.article_title = article_title;
		this.article_author = article_author;
		this.article_date = article_date;
		this.article_content = article_content;
		this.article_img_uri = article_img_uri;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_author() {
		return article_author;
	}
	public void setArticle_author(String article_author) {
		this.article_author = article_author;
	}
	public Date getArticle_date() {
		return article_date;
	}
	public void setArticle_date(Date article_date) {
		this.article_date = article_date;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_img_uri() {
		return article_img_uri;
	}
	public void setArticle_img_uri(String article_img_uri) {
		this.article_img_uri = article_img_uri;
	}
	@Override
	public String toString() {
		return "Article [article_title=" + article_title + ", article_author=" + article_author + ", article_date="
				+ article_date + ", article_content=" + article_content + ", article_img_uri=" + article_img_uri + "]";
	}
	
}
