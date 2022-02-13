package qwer.qwq.dao;

import java.util.List;

import qwer.qwq.domain.Comment;
import qwer.qwq.domain.User;

public interface CommentDao {
	//保存每日推荐评论
	public void saveArticleComment(Comment comment) ;
	public void saveBookComment(Comment comment) ;
	//获取所有每日评论
	public List<Comment> getArticleComment(String article_title);
	public List<Comment> getBookComment(String article_title);
}
