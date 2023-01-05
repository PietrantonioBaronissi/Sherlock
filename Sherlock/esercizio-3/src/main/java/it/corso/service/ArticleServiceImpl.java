package it.corso.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.ArticleDao;
import it.corso.model.Article;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getArticles()
	{
		return articleDao.getArticles();
	}
	
	@Override
	public boolean checkArticleData(String... data)
	{
		return true;
	}

	
	@Override
	public void createArticle(Article article)
	{
		articleDao.createArticle(article);
	}

	@Override
	public Article getArticleById(int id)
	{
		return articleDao.getArticleById(id);
	}

	@Override
	public void updateArticle(Article article)
	{
		articleDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(Article article)
	{
		articleDao.deleteArticle(article);
	}

	@Override
	public List<Article> getArticleByTipologia(String tipologia) {
		
		
		return articleDao.getArticleByTipologia(tipologia);
	}
	
	
	
	
}
