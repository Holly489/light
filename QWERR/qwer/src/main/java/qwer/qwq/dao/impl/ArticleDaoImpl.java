package qwer.qwq.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import qwer.qwq.dao.ArticleDao;
import qwer.qwq.dao.BookDao;
import qwer.qwq.domain.Article;
import qwer.qwq.domain.Book;
import qwer.qwq.util.JDBCUtils;

public class ArticleDaoImpl implements ArticleDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	public List<Article> getAllArticle() {
		String sql = "SELECT * FROM article";
        List<Article> list = template.query(sql, new RowMapper<Article>() {
            @Override
            public Article mapRow(ResultSet rs, int i) throws SQLException {
            	Article article=new Article();
            	//文章标题
            	String article_title=rs.getString("article_title");
            	//文章作者
            	String article_author=rs.getString("article_author");
            	//文章发表日期
            	Date article_date=rs.getDate("article_date");
            	//文章内容
            	String article_content=rs.getString("article_content");
            	//文章照片路径
            	String article_img_uri=rs.getString("article_img_uri");
            	article.setArticle_author(article_author);
            	article.setArticle_content(article_content);
            	article.setArticle_date(article_date);
            	article.setArticle_img_uri(article_img_uri);
            	article.setArticle_title(article_title);
            	return article;
            }
        });
		return list;
	}
	public static void main(String[] args) {
		BookDao bd=new BookDaoImpl();
		System.out.print(bd.getAllBook());
	}
	@Override
	public void saveArticle(Article article) {
		String sql = "insert into article(article_title,article_content,article_img_uri,article_author,article_date) values(?,?,?,?,?)";
		template.update(sql,article.getArticle_title(),
				article.getArticle_content(),
				article.getArticle_img_uri(),
				article.getArticle_author(),
				article.getArticle_date()
            );
	}
}
