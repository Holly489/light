package qwer.qwq.dao;

import java.util.Date;
import java.util.List;

import qwer.qwq.domain.Book;

public interface BookDao {
	/**
	 * 获取所有书籍信息
	 * @return
	 */
	public List<Book> getAllBook();
	public void saveBook(Book book);
}
