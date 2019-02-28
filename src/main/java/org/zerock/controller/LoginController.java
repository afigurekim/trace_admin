package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/customLogin",method=RequestMethod.GET)
	public void loginInput(String error,String logout,Model model){
		
		System.out.println("왜안타니");
		if(error!=null) {
			model.addAttribute("error","Login Error Check Your Account");
		}
		if(logout!=null) {
			model.addAttribute("logout","Logout!!");
		}
		
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String main() {
		logger.info("������ ���������� �α����ϱ�");

		return "login";
	}
}
