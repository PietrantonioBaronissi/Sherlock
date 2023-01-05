package it.corso.controller;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import it.corso.model.Article;
import it.corso.service.ArticleService;

@Controller
@RequestMapping("/modifica")
public class ArticleCardController
{
	@Autowired
	private ArticleService articleService;
	
	private Article article;
	
	@GetMapping
	public String getPage(
			Model model,
			@RequestParam("id") int id,
			@RequestParam(name = "fe", required = false) String formError,
			HttpSession session)
	{
		article = articleService.getArticleById(id);
		
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\articles\\" + id + ".png";
		File file = new File(filePath);
		article.setImage(file.exists());
		
		
		model.addAttribute("title", "Article Card");
		model.addAttribute("article", article);
		model.addAttribute("formError", formError != null);
		return "modifica";
	}
	
	@PostMapping("/editarticle")
	public String editArticle(
			@RequestParam("titolo") String titolo,
			@RequestParam("descrizione") String descrizione,
			@RequestParam("tipologia") String tipologia,
			@RequestParam("trama") String trama,
			@RequestParam("informazioni") String informazioni,
			@RequestParam("dettagli") String dettagli,
			@RequestParam("luoghi") String luoghi,
			@RequestParam(name = "image", required = false) MultipartFile image,
			HttpSession session)
	{
		if(!articleService.checkArticleData(titolo, descrizione,tipologia))
			return "redirect:/modifica?id=" + article.getId() + "&fe";
		article.setTitolo(titolo);
		article.setDescrizione(descrizione);
		article.setTipologia(tipologia);
		article.setTrama(trama);
		article.setInformazioni(informazioni);
		article.setDettagli(dettagli);
		article.setLuoghi(luoghi);
		articleService.updateArticle(article);
		
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
}