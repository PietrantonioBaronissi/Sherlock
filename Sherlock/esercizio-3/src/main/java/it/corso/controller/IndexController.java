package it.corso.controller;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Article;
import it.corso.model.User;
import it.corso.service.ArticleService;
import it.corso.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController
{
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getPage(
			@RequestParam(name = "le", required = false) String lError,
			Model model)
	{	
		
		boolean loginError = lError != null;
		model.addAttribute("loginError", loginError);
		model.addAttribute("user", new User());
		return "index";
	}
	

	
	
	@PostMapping("/login")
	public String userLogin(
			@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password,
			HttpSession session)
	{
		if(userService.userLogin(username, password, session) == true) {
			return "redirect:/reserved";
			}else {
			return "redirect:/index";
			}
		
		
	}
	
}