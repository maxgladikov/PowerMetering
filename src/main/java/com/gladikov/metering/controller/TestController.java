package com.gladikov.metering.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gladikov.metering.model.TestBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping
	public String showTest(Model model) {
		model.addAttribute("testBody",new TestBody());
		return "test";}
	
	
	
	@PostMapping
	public String processTest(TestBody testBody) {
		
			System.out.println(testBody.getMessage());
			return "redirect:/";}
		}
	

