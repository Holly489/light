package qwer.qwq.domain;

public class Review {
	//影评标题
	private String review_title;
	//图片路径
	private String review_img_uri;
	//影评内容
	private String review_content;
	//影评id
	private int review_id;
	public Review() {}
	public Review(String review_title, String review_img_uri, String review_content, int review_id) {
		super();
		this.review_title = review_title;
		this.review_img_uri = review_img_uri;
		this.review_content = review_content;
		this.review_id = review_id;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_img_uri() {
		return review_img_uri;
	}
	public void setReview_img_uri(String review_img_uri) {
		this.review_img_uri = review_img_uri;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	@Override
	public String toString() {
		return "Review [review_title=" + review_title + ", review_img_uri=" + review_img_uri + ", review_content="
				+ review_content + ", review_id=" + review_id + "]";
	}
	
}