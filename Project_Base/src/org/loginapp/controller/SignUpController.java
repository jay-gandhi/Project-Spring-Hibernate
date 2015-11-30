package org.loginapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.loginapp.dao.SignUpDAO;
import org.loginapp.model.LoginDTO;
import org.loginapp.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SignUpController {
	
	@Autowired
	private StudentDTO studentDTO;
	@Autowired
	private LoginDTO loginDTO;
	@Autowired
	private SignUpDAO signUpDAO;
	
	@RequestMapping(value="/SignUp.do",method= RequestMethod.POST)
	public void signup(HttpServletRequest request, HttpServletResponse response){
		
		loginDTO.setUsername(request.getParameter("inputUsername"));
		loginDTO.setPassword(request.getParameter("inputConfirmPassword"));
		studentDTO.setName(request.getParameter("inputName"));
		studentDTO.setPassout(request.getParameter("inputPassOut"));
		studentDTO.setPercent10(Double.parseDouble(request.getParameter("input10percent")));
		studentDTO.setPercent12(Double.parseDouble(request.getParameter("input12thpercent")));
		studentDTO.setStream(request.getParameter("inputDegree"));
		studentDTO.setEmail(request.getParameter("inputEmail"));
		studentDTO.setPercentDegree(Double.parseDouble(request.getParameter("inputDegreePercent")));
		loginDTO.setStudentDTO(studentDTO);
		studentDTO.setLoginDTO(loginDTO);
		signUpDAO.save(loginDTO);
		try {
			response.sendRedirect("ReLogin.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
