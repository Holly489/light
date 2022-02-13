package qwer.qwq.service;

import java.util.List;

import qwer.qwq.domain.Book;

public interface BookService {
	/**
	 * 获取所有书本
	 * @return
	 */
	public List<Book> getBook();
	public void saveBook(Book book);
}
