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
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private ArticleService articleService;

	@GetMapping
	public String getPage(Model model,
			
	        HttpSession session,
	        @RequestParam(name = "tipologia",required = false)String tipologia)
	{
		String libri = "Libri a firma Sir Arthur Conan Doyle";
		String film = "Pellicole ispirate dai racconti di Sir Arthur Conan Doyle";
		String serieTv="Serie TV ispirate dai racconti di Sir Arthur Conan Doyle";
		
		
		if(tipologia!=null) {
			model.addAttribute("articoli",articleService.getArticleByTipologia(tipologia));
			if(tipologia.equals("libri")) {
				model.addAttribute("stringa",libri);
			}
			else if(tipologia.equals("film")) {
				model.addAttribute("stringa",film);
			}
			else if(tipologia.equals("serieTv")) {
				model.addAttribute("stringa",serieTv);
			}
		}
		
		
		List<Article> articles = articleService.getArticleByTipologia(tipologia);
		String rootDir = session.getServletContext().getRealPath("/");
		for(Article a : articles)
			a.setImage(new File(rootDir + "static\\articles\\" + a.getId() + ".png").exists());
		model.addAttribute("articles", articles);
		return "catalogo";
	}
}



