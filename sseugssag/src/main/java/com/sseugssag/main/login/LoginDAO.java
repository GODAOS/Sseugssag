package com.sseugssag.main.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class LoginDAO {

	// 로그인 성공 체크
	public boolean loginCheck(HttpServletRequest req) {
		Customer s = (Customer) req.getSession().getAttribute("loginCustomer");
		Company c = (Company) req.getSession().getAttribute("loginCompany");

		if (s != null) {
			req.setAttribute("lp", "welcome.jsp");
			return true;
		}else if (c != null) {
			req.setAttribute("lp", "welcome2.jsp");
			return true;
		} else {// 로그인실패시
			req.setAttribute("lp", "cus_login.jsp");
			return false;
		}
	}
}
