package it.corso.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.corso.model.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao
{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void createArticle(Article article)
	{
		manager.persist(article);
	}

	@Override
	public Article getArticleById(int id)
	{
		return manager.find(Article.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticles()
	{
		//String sql = "SELECT * FROM articles";
		String jpql = "SELECT a FROM Article a";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	@Transactional
	public void updateArticle(Article article)
	{
		manager.merge(article);
	}

	@Override
	@Transactional
	public void deleteArticle(Article article)
	{
		manager.remove(manager.merge(article));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleByTipologia(String tipologia) {
		
		String sql = "SELECT a FROM Article a WHERE tipologia='"+tipologia+"'";
		return manager.createQuery(sql).getResultList();
	}
}