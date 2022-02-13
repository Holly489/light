package qwer.qwq.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import qwer.qwq.dao.RecommendDao;
import qwer.qwq.domain.History;
import qwer.qwq.domain.Recommend;
import qwer.qwq.util.JDBCUtils;

public class RecommendDaoImpl implements RecommendDao{
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	/**
	 * 通过日期查询所有每日推荐实体类并返回list集合
	 */
	public List<Recommend> findRecommendByDate(String date) {
		String sql = "SELECT * FROM recommend WHERE recommend_time = ? ";
        List<Recommend> list = template.query(sql, new RowMapper<Recommend>() {
            @Override
            public Recommend mapRow(ResultSet rs, int i) throws SQLException {
            	Recommend rc=new Recommend();
            	//每日推荐标题
            	String recommend_title=rs.getString("recommend_title");
            	//每日推荐路径
            	String recommend_uri=rs.getString("recommend_uri");
            	//每日推荐id
            	int recommend_id=rs.getInt("recommend_id");
            	//每日推荐概要
            	String recommend_outline=rs.getString("recommend_outline");
            	//每日推荐日期
            	Date recommend_time=rs.getDate("recommend_time");
            	//每日推荐内容
            	String recommend_content=rs.getString("recommend_content");
            	//每日推荐照片概要
            	String recommend_img_outline=rs.getString("recommend_img_outline");
            	//每日推荐照片路径
            	String recommend_img_uri=rs.getString("recommend_img_uri");
            	//每日推荐类型
            	String recommend_type=rs.getString("recommend_type");
            	rc.setRecommend_content(recommend_content);
            	rc.setRecommend_id(recommend_id);
            	rc.setRecommend_img_outline(recommend_img_outline);
            	rc.setRecommend_img_uri(recommend_img_uri);
            	rc.setRecommend_time(recommend_time);
            	rc.setRecommend_type(recommend_type);
            	rc.setRecommend_uri(recommend_uri);
            	rc.setRecommend_outline(recommend_outline);
            	rc.setRecommend_title(recommend_title);
            	return rc;
            }
        },date);
		return list;
	}
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(sdf.format(date));
		RecommendDao rd=new RecommendDaoImpl();
		List<Recommend> list=rd.findRecommendByDate(sdf.format(date));
		for(Recommend recommend:list) {
			System.out.println(recommend);
		}
	}
	@Override
	public List<Recommend> getHistoryRecommend() {
		String sql = "SELECT * FROM recommend WHERE recommend_time != ? ORDER BY RAND() LIMIT 8 ";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
        List<Recommend> list = template.query(sql, new RowMapper<Recommend>() {
            @Override
            public Recommend mapRow(ResultSet rs, int i) throws SQLException {
            	Recommend rc=new Recommend();
            	//每日推荐标题
            	String recommend_title=rs.getString("recommend_title");
            	//每日推荐路径
            	String recommend_uri=rs.getString("recommend_uri");
            	//每日推荐id
            	int recommend_id=rs.getInt("recommend_id");
            	//每日推荐概要
            	String recommend_outline=rs.getString("recommend_outline");
            	//每日推荐日期
            	Date recommend_time=rs.getDate("recommend_time");
            	//每日推荐内容
            	String recommend_content=rs.getString("recommend_content");
            	//每日推荐照片概要
            	String recommend_img_outline=rs.getString("recommend_img_outline");
            	//每日推荐照片路径
            	String recommend_img_uri=rs.getString("recommend_img_uri");
            	//每日推荐类型
            	String recommend_type=rs.getString("recommend_type");
            	rc.setRecommend_content(recommend_content);
            	rc.setRecommend_id(recommend_id);
            	rc.setRecommend_img_outline(recommend_img_outline);
            	rc.setRecommend_img_uri(recommend_img_uri);
            	rc.setRecommend_time(recommend_time);
            	rc.setRecommend_type(recommend_type);
            	rc.setRecommend_uri(recommend_uri);
            	rc.setRecommend_outline(recommend_outline);
            	rc.setRecommend_title(recommend_title);
            	return rc;
            }
        },date);
		return list;
	}
	@Override
	public List<Recommend> getFourRecommend() {
		String sql = "SELECT * FROM recommend WHERE recommend_time ORDER BY RAND() LIMIT 4 ";
        List<Recommend> list = template.query(sql, new RowMapper<Recommend>() {
            @Override
            public Recommend mapRow(ResultSet rs, int i) throws SQLException {
            	Recommend rc=new Recommend();
            	//每日推荐标题
            	String recommend_title=rs.getString("recommend_title");
            	//每日推荐路径
            	String recommend_uri=rs.getString("recommend_uri");
            	//每日推荐id
            	int recommend_id=rs.getInt("recommend_id");
            	//每日推荐概要
            	String recommend_outline=rs.getString("recommend_outline");
            	//每日推荐日期
            	Date recommend_time=rs.getDate("recommend_time");
            	//每日推荐内容
            	String recommend_content=rs.getString("recommend_content");
            	//每日推荐照片概要
            	String recommend_img_outline=rs.getString("recommend_img_outline");
            	//每日推荐照片路径
            	String recommend_img_uri=rs.getString("recommend_img_uri");
            	//每日推荐类型
            	String recommend_type=rs.getString("recommend_type");
            	rc.setRecommend_content(recommend_content);
            	rc.setRecommend_id(recommend_id);
            	rc.setRecommend_img_outline(recommend_img_outline);
            	rc.setRecommend_img_uri(recommend_img_uri);
            	rc.setRecommend_time(recommend_time);
            	rc.setRecommend_type(recommend_type);
            	rc.setRecommend_uri(recommend_uri);
            	rc.setRecommend_outline(recommend_outline);
            	rc.setRecommend_title(recommend_title);
            	return rc;
            }
        });
		return list;
	}
}
