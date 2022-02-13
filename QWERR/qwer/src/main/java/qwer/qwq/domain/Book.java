package qwer.qwq.domain;

import java.util.Date;

public class Book {
	private String book_title;
	private String book_img_uri;
	private int book_id;
	private String book_content;
	private String book_author;
	private Date book_date;
	public Book() {}
	public Book(String book_title, String book_img_uri, int book_id, String book_content, String book_author,
			Date book_date) {
		super();
		this.book_title = book_title;
		this.book_img_uri = book_img_uri;
		this.book_id = book_id;
		this.book_content = book_content;
		this.book_author = book_author;
		this.book_date = book_date;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_img_uri() {
		return book_img_uri;
	}
	public void setBook_img_uri(String book_img_uri) {
		this.book_img_uri = book_img_uri;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_content() {
		return book_content;
	}
	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public Date getBook_date() {
		return book_date;
	}
	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}
	@Override
	public String toString() {
		return "Book [book_title=" + book_title + ", book_img_uri=" + book_img_uri + ", book_id=" + book_id
				+ ", book_content=" + book_content + ", book_author=" + book_author + ", book_date=" + book_date + "]";
	}
	
}
