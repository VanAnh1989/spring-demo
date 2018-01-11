package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/hello")
	public ModelAndView view() {
		return new ModelAndView("home").addObject("name", "Nguyen Van Anh");
	}
	
	
}
