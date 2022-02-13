package qwer.qwq.service;

import java.util.List;

import qwer.qwq.domain.Article;
import qwer.qwq.domain.Comment;

public interface CommentService {
	public void saveArticleComment(Comment comment);
	public void saveBookComment(Comment comment);
	public List<Comment> getArticleComment(String article_title);
	public List<Comment> getBookComment(String book_title);
}
