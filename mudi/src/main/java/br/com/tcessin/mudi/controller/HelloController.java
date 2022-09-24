package br.com.tcessin.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model req) {
		
		req.addAttribute("nome", "Joao");
		return "hello";
		
	}
	
	
	
}
