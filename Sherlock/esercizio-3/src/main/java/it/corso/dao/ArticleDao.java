package it.corso.dao;
import java.util.List;
import it.corso.model.Article;

public interface ArticleDao
{
	void createArticle(Article article);
	Article getArticleById(int id);
	List<Article> getArticles();
	void updateArticle(Article article);
	void deleteArticle(Article article);
	List<Article> getArticleByTipologia(String tipologia);
	
}