package demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import demo.DAO.service.MailSend;
import demo.DAO.service.UserAccountService;
import demo.model.UserAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

	@Autowired
	private UserAccountService service;
	@Autowired
	private MailSend mail;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/hello")
	public ModelAndView getView() {
		System.out.println("done");
		return new ModelAndView("index");
	}
	@RequestMapping("/rest")
	public ModelAndView respinsive() {
		System.out.println("done");
		return new ModelAndView("rest");
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestParam String user, @RequestParam String pass) {
		UserAccount userAccount = new UserAccount();
		userAccount.setUser(user);
		userAccount.setPass(pass);
		service.setAccount(userAccount);
		return "success";
	}

	@RequestMapping("/checkUser")
	public ModelAndView checkUser(@RequestParam String user, @RequestParam String pass) {
		ModelAndView model = new ModelAndView("WellCome");
		UserAccount userAcc = service.getUserById(user, pass);
		if (userAcc != null) {
			model.addObject("user", userAcc.getUser());
			model.addObject("pass", userAcc.getPass());
			return model;
		} else {
			model.addObject("user", "fails");
			model.addObject("pass", "fails");
			return model;
		}
	}
	
	@RequestMapping(value="/sendMail" , method=RequestMethod.POST)
	public String sendMail(@RequestParam String content) {
		return mail.sendmailNow(content) ? "success" : "not success";
	}
	
	
	

}
