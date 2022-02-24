package com.sseugssag.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseugssag.main.login.CompanyDAO;
import com.sseugssag.main.login.CustomerLoginDAO;
import com.sseugssag.main.login.LoginDAO;
import com.sseugssag.main.login.OrderDAO;
import com.sseugssag.main.reserve.Reserve;

@Controller
public class HomeController {

	@Autowired
	private LoginDAO lgDAO;

	@Autowired
	private CustomerLoginDAO lDAO;

	@Autowired
	private CompanyDAO cDAO;
	
	@Autowired
	private OrderDAO oDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		lgDAO.loginCheck(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/home.go", method = RequestMethod.GET)
	public String home2(HttpServletRequest req, Reserve r) {
		if (lDAO.loginCheck(req)) {
			req.setAttribute("cp", "home.jsp");
			return "index";
		} else if (cDAO.loginCheck(req)) {
			oDAO.OrderCheck(r, req);
			req.setAttribute("cp", "OrderTable.jsp");
			return "index2";
		} else {
			req.setAttribute("lp","cus_login.jsp");
			req.setAttribute("cp", "home.jsp");
			return "index";
		}
	}
}
