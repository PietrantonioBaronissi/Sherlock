package it.corso.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Article;
import it.corso.service.ArticleService;

@Controller
@RequestMapping("/schedaSingola")
public class SchedaSingolaController {

	@Autowired
	private ArticleService articleService;
	
	private Article article;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam("id") int id,
			HttpSession session,
			@RequestParam(name = "fe",required = false) String formError)
	{
		article = articleService.getArticleById(id);
		
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\articles\\" + id + ".png";
		File file = new File(filePath);
		article.setImage(file.exists());

		model.addAttribute("title", "New Article");
		model.addAttribute("article", article);
		model.addAttribute("formError", formError != null);
		return "schedaSingola";
		
	}
}
