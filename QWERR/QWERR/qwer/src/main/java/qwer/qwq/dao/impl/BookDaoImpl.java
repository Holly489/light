package qwer.qwq.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import qwer.qwq.dao.BookDao;
import qwer.qwq.domain.Book;
import qwer.qwq.domain.Recommend;
import qwer.qwq.util.JDBCUtils;

public class BookDaoImpl implements BookDao{
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	public List<Book> getAllBook() {
		String sql = "SELECT * FROM book";
        List<Book> list = template.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int i) throws SQLException {
            	Book book=new Book();
            	String book_title=rs.getString("book_title");
            	String book_img_uri=rs.getString("book_img_uri");
            	int book_id=rs.getInt("book_id");
            	String book_content=rs.getString("book_content");
            	String book_author=rs.getString("book_author");
            	Date book_date=rs.getDate("book_date");
            	book.setBook_author(book_author);
            	book.setBook_content(book_content);
            	book.setBook_date(book_date);
            	book.setBook_id(book_id);
            	book.setBook_img_uri(book_img_uri);
            	book.setBook_title(book_title);
            	return book;
            }
        });
		return list;
	}
	public static void main(String[] args) {
		BookDao bd=new BookDaoImpl();
		System.out.print(bd.getAllBook());
	}
	@Override
	public void saveBook(Book book) {
		String sql = "insert into book(book_title,book_content,book_img_uri,book_author,book_date) values(?,?,?,?,?)";
		template.update(sql,book.getBook_title(),
            book.getBook_content(),
            book.getBook_img_uri(),
            book.getBook_author(),
            book.getBook_date()
            );
	}
}
