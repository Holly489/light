package qwer.qwq.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import qwer.qwq.dao.ReviewDao;
import qwer.qwq.domain.Recommend;
import qwer.qwq.domain.Review;
import qwer.qwq.domain.User;
import qwer.qwq.util.JDBCUtils;

public class ReviewDaoImpl implements ReviewDao{
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override
	public Review getOneReview() {
		Review review = null;
		String sql = "select * from review order by rand() LIMIT 1";
		review = template.queryForObject(sql, new BeanPropertyRowMapper<Review>(Review.class));
		return review;
		/*try {*/
            //1.定义sql
            
            //2.执行sql
            /*review = (Review) template.query(sql, new RowMapper<Review>() {
                @Override
                public Review mapRow(ResultSet rs, int i) throws SQLException {
                	Review rv=new Review();
                	//影评标题
                	String review_title=rs.getString("review_title");
                	//图片路径
                	String review_img_uri=rs.getString("review_img_uri");
                	//影评内容
                	String review_content=rs.getString("review_content");
                	//影评id
                	int review_id=rs.getInt("review_id");
                	rv.setReview_content(review_content);
                	rv.setReview_id(review_id);
                	rv.setReview_img_uri(review_img_uri);
                	rv.setReview_title(review_title);
                	return rv;
                }
            });
        } catch (Exception e) {
        }*/
		
	}
	public static void main(String[] args) {
		ReviewDao r=new ReviewDaoImpl();
		Review rv=r.getOneReview();
		System.out.print(rv);
	}
}
