package qwer.qwq.service;

import java.util.List;

import qwer.qwq.domain.Article;
import qwer.qwq.domain.Book;

public interface ArticleService {
	/**
	 * 获取所有书本
	 * @return
	 */
	public List<Article> getArticle();
	public void saveArticle(Article article);
}
