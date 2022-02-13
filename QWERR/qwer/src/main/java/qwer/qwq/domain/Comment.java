package qwer.qwq.domain;

import java.util.Date;

public class Comment {
	//评论id
	private int comment_id;
	//评论内容
	private String comment_content=null;
	//评论日期
	private Date comment_date;
	//用户id
	private String book_title=null;
	//每日推荐id
	private String article_title=null;
	//评论用户名
	public Comment(){}
	public Comment(int comment_id, String comment_content, Date comment_date, String book_title, String article_title) {
		super();
		this.comment_id = comment_id;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
		this.book_title = book_title;
		this.article_title = article_title;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", comment_content=" + comment_content + ", comment_date="
				+ comment_date + ", book_title=" + book_title + ", article_title=" + article_title + "]";
	}
	
	
}
