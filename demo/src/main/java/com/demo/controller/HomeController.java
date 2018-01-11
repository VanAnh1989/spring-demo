package com.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.factory.user.Function;
import com.demo.model.User;

@Controller
public class HomeController {
	
	@RequestMapping("/hello")
	public ModelAndView view() {
		List<User> users = new Function().getAllUser();
		return new ModelAndView("home","users",users);
	}	
	
	@RequestMapping("/Insert")
	public ModelAndView addUser(@RequestParam("user") String user,@RequestParam("pass") String pass) {
		System.out.println(user+pass);
		return new ModelAndView("home","error","Success");
	}
	
	
}
