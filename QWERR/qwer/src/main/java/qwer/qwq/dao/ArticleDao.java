package qwer.qwq.dao;

import java.util.List;

import qwer.qwq.domain.Article;
import qwer.qwq.domain.Book;

public interface ArticleDao {
	public List<Article> getAllArticle();
	public void saveArticle(Article article);
}
