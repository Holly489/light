package qwer.qwq.service.impl;

import java.util.List;

import qwer.qwq.dao.CommentDao;
import qwer.qwq.dao.impl.CommentDaoImpl;
import qwer.qwq.domain.Comment;
import qwer.qwq.service.CommentService;

public class CommentServiceImpl implements CommentService{
	CommentDao commentDao=new CommentDaoImpl();
	@Override
	public void saveArticleComment(Comment comment) {
		commentDao.saveArticleComment(comment);
	}

	@Override
	public void saveBookComment(Comment comment) {
		commentDao.saveBookComment(comment);
		
	}

	@Override
	public List<Comment> getArticleComment(String article_title) {
		// TODO Auto-generated method stub
		return commentDao.getArticleComment(article_title);
	}

	@Override
	public List<Comment> getBookComment(String book_title) {
		// TODO Auto-generated method stub
		return commentDao.getBookComment(book_title);
	}

}
