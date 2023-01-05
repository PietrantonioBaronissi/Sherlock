package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/HomePage")
public class HomePageController {

	@GetMapping
	public String getPage(Model model,
			@RequestParam(name = "fe",required = false) String formError)
	{

		
		return "HomePage";
		
	}

}
