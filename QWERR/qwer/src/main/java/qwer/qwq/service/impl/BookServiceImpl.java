package qwer.qwq.service.impl;

import java.util.List;

import qwer.qwq.dao.BookDao;
import qwer.qwq.dao.impl.BookDaoImpl;
import qwer.qwq.domain.Book;
import qwer.qwq.service.BookService;

public class BookServiceImpl implements BookService{
	BookDao bookDao=new BookDaoImpl();
	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}
	@Override
	public void saveBook(Book book) {
		bookDao.saveBook(book);
	}
	
}
