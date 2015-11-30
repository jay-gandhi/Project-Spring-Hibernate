package org.loginapp.controller;


import javax.servlet.http.HttpServletRequest;

import org.loginapp.dao.LoginDAO;
import org.loginapp.model.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginDAO loginDAO;
	
	@RequestMapping(value="/Login.do",method= RequestMethod.POST)
	public String doLogin(HttpServletRequest request){
		if(loginDAO.login(new LoginDTO(request.getParameter("username"),request.getParameter("password")))){
			return "/WEB-INF/views/dashboardStudent"; 
		}
		return "/WEB-INF/views/backToHome";
	}
}
