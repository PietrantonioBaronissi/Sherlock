package it.corso.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/noteLegali")
public class NoteLegali {

	@GetMapping
	public String getPage()
	{	
		
		return "noteLegali";
	}
}
