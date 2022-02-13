package qwer.qwq.service.impl;

import java.util.List;

import qwer.qwq.dao.ArticleDao;
import qwer.qwq.dao.impl.ArticleDaoImpl;
import qwer.qwq.domain.Article;
import qwer.qwq.domain.Book;
import qwer.qwq.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	ArticleDao articleDao=new ArticleDaoImpl();
	@Override
	public List<Article> getArticle() {
		return articleDao.getAllArticle();
	}
	@Override
	public void saveArticle(Article book) {
		articleDao.saveArticle(book);
	}
}
