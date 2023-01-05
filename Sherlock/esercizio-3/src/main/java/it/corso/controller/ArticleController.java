package it.corso.controller;

import java.io.File;
import java.io.IOException;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Article;
import it.corso.service.ArticleService;

@Controller
@RequestMapping("/aggiungi")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam(name = "fe",required = false) String formError)
	{

		model.addAttribute("title", "New Article");
		model.addAttribute("article", new Article());
		model.addAttribute("formError", formError != null);
		return "aggiungi";
		
	}
	
	@PostMapping("/savestandard")
	public String saveStandard(
			@RequestParam("artTitolo") String titolo,
			@RequestParam("artDescrizione") String descrizione,
			@RequestParam("artTipologia") String tipologia,
			@RequestParam("artTrama") String trama,
			@RequestParam("artInformazioni") String informazioni,
			@RequestParam("artDettagli") String dettagli,
			@RequestParam("artLuoghi") String luoghi,
			@RequestParam(name = "image", required = false) MultipartFile image,
			HttpSession session)
	{
		if(!articleService.checkArticleData(titolo,descrizione,tipologia))	
			return "redirect:/modifica?fe";
		Article article = new Article();
		article.setTitolo(titolo);
		article.setDescrizione(descrizione);
		article.setTipologia(tipologia);
		article.setTrama(trama);
		article.setInformazioni(informazioni);
		article.setDettagli(dettagli);
		article.setLuoghi(luoghi);
		articleService.createArticle(article);
		
		
		if(image != null && !image.isEmpty())
			saveImage(article.getId(), image, session);
		
		return "redirect:/reserved";
    }
	
	private void saveImage(
			int id,
			MultipartFile image,
			HttpSession session)
	{
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\articles\\" + id + ".png";
		try
		{
			image.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	@PostMapping
	public String saveArticle(
			@Valid @ModelAttribute("article") Article article,
			BindingResult result)
	{
		if(result.hasErrors())
			return "reserved";
		articleService.createArticle(article);
		return "redirect:/reserved";
	}
	
	@PostMapping("/saveclient")
	@ResponseBody
	public String saveClient(
			@RequestParam("titolo") String titolo,
			@RequestParam("descrizione") String descrizione,
			@RequestParam("tipologia") String tipologia,
			@RequestParam("artTrama") String trama,
			@RequestParam("artInformazioni") String informazioni,
			@RequestParam("artDettagli") String dettagli,
			@RequestParam("artLuoghi") String luoghi)
	{
		Article article = new Article();
		article.setTitolo(titolo);
		article.setDescrizione(descrizione);
		article.setTipologia(tipologia);
		article.setTrama(trama);
		article.setInformazioni(informazioni);
		article.setDettagli(dettagli);
		article.setLuoghi(luoghi);
		articleService.createArticle(article);
		return "save success";
	}
	
	
	
	
	
	
}
