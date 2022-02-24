package com.sseugssag.main.calculate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseugssag.main.login.LoginDAO;

@Controller
public class CalController {
	
	@Autowired
	private CalcDAO cal;
	
	@Autowired
	private LoginDAO lgDAO;
	
	@RequestMapping(value = "/calculate.go", method = RequestMethod.GET)
	public String cal(POJO po,HttpServletRequest req) {
		lgDAO.loginCheck(req);
		cal.calculate(po, req);
		req.setAttribute("cp", "calc.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String cal1(POJO po,HttpServletRequest req) {
		lgDAO.loginCheck(req);
		cal.calculate(po, req);
		req.setAttribute("cp", "calc.jsp");
		return "index";
	}

}
