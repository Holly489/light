package qwer.qwq.domain;

import java.util.Date;

/**
 * 每日推荐实体类
 * @author 10316
 *
 */
public class Recommend {
	//每日推荐标题
	String recommend_title;
	//每日推荐路径
	String recommend_uri;
	//每日推荐id
	int recommend_id;
	//每日推荐概要
	String recommend_outline;
	//每日推荐日期
	Date recommend_time;
	//每日推荐内容
	String recommend_content;
	//每日推荐照片概要
	String recommend_img_outline;
	//每日推荐照片路径
	String recommend_img_uri;
	//每日推荐类型
	String recommend_type;
	
	public Recommend() {}
	public Recommend(String recommend_title, String recommend_uri, int recommend_id, String recommend_outline,
			Date recommend_time, String recommend_content, String recommend_img_outline, String recommend_img_uri,
			String recommend_type) {
		super();
		this.recommend_title = recommend_title;
		this.recommend_uri = recommend_uri;
		this.recommend_id = recommend_id;
		this.recommend_outline = recommend_outline;
		this.recommend_time = recommend_time;
		this.recommend_content = recommend_content;
		this.recommend_img_outline = recommend_img_outline;
		this.recommend_img_uri = recommend_img_uri;
		this.recommend_type = recommend_type;
	}

	
	public String getRecommend_title() {
		return recommend_title;
	}


	public void setRecommend_title(String recommend_title) {
		this.recommend_title = recommend_title;
	}


	public String getRecommend_uri() {
		return recommend_uri;
	}


	public void setRecommend_uri(String recommend_uri) {
		this.recommend_uri = recommend_uri;
	}


	public int getRecommend_id() {
		return recommend_id;
	}


	public void setRecommend_id(int recommend_id) {
		this.recommend_id = recommend_id;
	}


	public String getRecommend_outline() {
		return recommend_outline;
	}


	public void setRecommend_outline(String recommend_outline) {
		this.recommend_outline = recommend_outline;
	}


	public Date getRecommend_time() {
		return recommend_time;
	}


	public void setRecommend_time(Date recommend_time) {
		this.recommend_time = recommend_time;
	}


	public String getRecommend_content() {
		return recommend_content;
	}


	public void setRecommend_content(String recommend_content) {
		this.recommend_content = recommend_content;
	}


	public String getRecommend_img_outline() {
		return recommend_img_outline;
	}


	public void setRecommend_img_outline(String recommend_img_outline) {
		this.recommend_img_outline = recommend_img_outline;
	}


	public String getRecommend_img_uri() {
		return recommend_img_uri;
	}


	public void setRecommend_img_uri(String recommend_img_uri) {
		this.recommend_img_uri = recommend_img_uri;
	}


	public String getRecommend_type() {
		return recommend_type;
	}


	public void setRecommend_type(String recommend_type) {
		this.recommend_type = recommend_type;
	}


	@Override
	public String toString() {
		return "Recommend [recommend_title=" + recommend_title + ", recommend_uri=" + recommend_uri + ", recommend_id="
				+ recommend_id + ", recommend_outline=" + recommend_outline + ", recommend_time=" + recommend_time
				+ ", recommend_content=" + recommend_content + ", recommend_img_outline=" + recommend_img_outline
				+ ", recommend_img_uri=" + recommend_img_uri + ", recommend_type=" + recommend_type + "]";
	}
	
}
