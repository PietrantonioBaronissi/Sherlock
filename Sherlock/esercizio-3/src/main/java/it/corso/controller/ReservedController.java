package it.corso.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Article;
import it.corso.service.ArticleService;

@Controller
@RequestMapping("/reserved")
public class ReservedController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam(name = "fe",required = false) String formError,
	        HttpSession session)
	{
		if(session.getAttribute("log") == null) {
			return "redirect:/index";
		}
		
		List<Article> articles = articleService.getArticles();
		String rootDir = session.getServletContext().getRealPath("/");
		for(Article a : articles)
			a.setImage(new File(rootDir + "static\\articles\\" + a.getId() + ".png").exists());
		model.addAttribute("title", "Home Page");
		model.addAttribute("articles", articles);
		return "reserved";
	}
	
		@GetMapping("/deletearticle")
		public String deleteArticle(
				@RequestParam("id") int id,
				HttpSession session)
		{
			Article article = articleService.getArticleById(id);
			articleService.deleteArticle(article);
			String rootDir = session.getServletContext().getRealPath("/");
			String filePath = rootDir + "static\\articles\\" + id + ".png";
			File file = new File(filePath);
			file.delete();
			return "redirect:/reserved";
		}
		
}
