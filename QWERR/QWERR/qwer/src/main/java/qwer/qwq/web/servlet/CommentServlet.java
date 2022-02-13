package qwer.qwq.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qwer.qwq.domain.Comment;
import qwer.qwq.service.CommentService;
import qwer.qwq.service.impl.CommentServiceImpl;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/comment/*")
public class CommentServlet extends BaseServlet {
	CommentService commentService=new CommentServiceImpl();
	public void saveBookComment(HttpServletRequest request, HttpServletResponse response) {
		String comment_content=request.getParameter("comment");
		String book_title=request.getParameter("title");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		Comment comment=new Comment();
		comment.setBook_title(book_title);
		comment.setComment_content(comment_content);
		comment.setComment_date(date);
		commentService.saveBookComment(comment);
	}
	public void saveArticleComment(HttpServletRequest request, HttpServletResponse response) {
		String comment_content=request.getParameter("comment");
		String article_title=request.getParameter("title");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		Comment comment=new Comment();
		comment.setArticle_title(article_title);
		comment.setComment_content(comment_content);
		comment.setComment_date(date);
		commentService.saveArticleComment(comment);
	}
	public void getBookComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String book_title=request.getParameter("book_title");
		List<Comment> comment=commentService.getBookComment(book_title);
		writeValue(comment,response);
	}
	public void getArticleComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String article_title=request.getParameter("book_title");
		List<Comment> comment=commentService.getBookComment(article_title);
		writeValue(comment,response);
	}
}
