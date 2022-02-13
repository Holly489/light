package qwer.qwq.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import qwer.qwq.dao.CommentDao;
import qwer.qwq.domain.Comment;
import qwer.qwq.domain.Recommend;
import qwer.qwq.domain.User;
import qwer.qwq.util.JDBCUtils;

public class CommentDaoImpl implements CommentDao{
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	//保存用户评论
	public void saveBookComment(Comment comment) {
		String sql = "insert into comment(comment_content,comment_date,book_title) values (?,?,?)";
		template.update(sql,comment.getComment_content(),
                comment.getComment_date(),
           comment.getBook_title()
            );
	}

	@Override
	public void saveArticleComment(Comment comment) {
		String sql = "insert into comment(comment_content,comment_date,article_title) values (?,?,?)";
		template.update(sql,comment.getComment_content(),
                comment.getComment_date(),
           comment.getArticle_title()
            );
		
	}

	@Override
	public List<Comment> getArticleComment(String article_title) {
		String sql = "SELECT * FROM comment WHERE article_title = ? ";
        List<Comment> list = template.query(sql, new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet rs, int i) throws SQLException {
            	Comment rc=new Comment();
            	//评论id
            	int comment_id=rs.getInt("comment_id");
            	//评论内容
            	String comment_content=rs.getString("comment_content");
            	//评论日期
            	Date comment_date=rs.getDate("comment_date");
            	String article_title=rs.getString("article_title");
            	rc.setComment_content(comment_content);
            	rc.setComment_date(comment_date);
            	rc.setComment_id(comment_id);
            	rc.setArticle_title(article_title);
            	return rc;
            }
        },article_title);
		return list;
	}

	@Override
	public List<Comment> getBookComment(String book_title) {
		String sql = "SELECT * FROM comment WHERE article_title = ? ";
        List<Comment> list = template.query(sql, new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet rs, int i) throws SQLException {
            	Comment rc=new Comment();
            	//评论id
            	int comment_id=rs.getInt("comment_id");
            	//评论内容
            	String comment_content=rs.getString("comment_content");
            	//评论日期
            	Date comment_date=rs.getDate("comment_date");
            	String book_title=rs.getString("book_title");
            	rc.setComment_content(comment_content);
            	rc.setComment_date(comment_date);
            	rc.setComment_id(comment_id);
            	rc.setBook_title(book_title);
            	return rc;
            }
        },book_title);
		return list;
	}
}
