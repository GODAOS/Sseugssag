package com.sseugssag.main.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseugssag.main.reserve.Reserve;
import com.sseugssag.main.reserve.ReserveDAO;

@Controller
public class LoginController {

	@Autowired
	private CustomerLoginDAO lDAO;

	@Autowired
	private CompanyDAO cDAO;

	@Autowired
	private LoginDAO lgDAO;
	
	@Autowired
	private ReserveDAO rDAO;

	@Autowired
	private OrderDAO oDAO;

	// 개인 회원 가입(통합)
	@RequestMapping(value = "/customer.join", method = RequestMethod.GET)
	public String cus_join(HttpServletRequest req) {
		req.setAttribute("cp", "customer_login.jsp");
		lDAO.loginCheck(req);
		return "index";
	}

	// 업체 회원 가입(통합)
	@RequestMapping(value = "/company.join", method = RequestMethod.GET)
	public String com_join(HttpServletRequest req) {
		req.setAttribute("cp", "company_login.jsp");
		cDAO.loginCheck(req);
		return "index";
	}

	// 개인 회원 로그인(통합)
	@RequestMapping(value = "/customer.go", method = RequestMethod.POST)
	public String customerjoin(Customer c, HttpServletRequest req) {
		lgDAO.loginCheck(req);
		req.setAttribute("cp", "home.jsp");
		lDAO.customerjoin(c, req);
		return "index";
	}

	// 업체 로그인 페이지
	@RequestMapping(value = "/company.go", method = RequestMethod.GET)
	public String comjoin(Company c, HttpServletRequest req) {
		return "com_login";
	}

	// 로그인화면 가도록
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Customer c, HttpServletRequest req) {
		req.setAttribute("cp", "home.jsp");
		lgDAO.loginCheck(req);
		return "index";
	}

	// 로그인들어와서
	@RequestMapping(value = "/login.gogo", method = RequestMethod.POST)
	public String login2(Customer c, HttpServletRequest req) {
		req.setAttribute("cp", "home.jsp");
		lDAO.CustomerLogin(c, req);
		lDAO.loginCheck(req);
		return "index";
	}

	// 업체측로그인
	@RequestMapping(value = "/company.gogo", method = RequestMethod.POST)
	public String login2(Reserve r, Company c, HttpServletRequest req) {
		cDAO.CompanyLogin(c, req);
		if (cDAO.loginCheck(req)) {
			oDAO.OrderCheck(r, req);
			req.setAttribute("cp", "OrderTable.jsp");
			return "index2";
		} else {
			req.setAttribute("cp", "home.jsp");
		}
		return "index";
	}

	// 업체 회원가입
	@RequestMapping(value = "/companylogin.gogo", method = RequestMethod.POST)
	public String companylogin(Company c, HttpServletRequest req) {
		cDAO.companyjoin(c, req);
		lgDAO.loginCheck(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/customer.logout", method = RequestMethod.GET)
	public String customerLogout(HttpServletRequest req) {
		lDAO.logout(req);
		lDAO.loginCheck(req);

		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String customerinfo(HttpServletRequest req) {
		if (lDAO.loginCheck(req)) {
			lDAO.divideAddr(req);
			req.setAttribute("cp", "customerinfo.jsp");
		} else {
			req.setAttribute("cp", "customerinfo.jsp");
		}
		return "index";
	}

	// 고객 정보 수정
	@RequestMapping(value = "/customer.update", method = RequestMethod.POST)
	public String customerupdate(Customer c, HttpServletRequest req) {
		if (lDAO.loginCheck(req)) {
			lDAO.update(c, req);
			lDAO.divideAddr(req);
			req.setAttribute("cp", "home.jsp");
		} else {
			req.setAttribute("cp", "home.jsp");
		}
		return "index";
	}

	// 탈퇴하기
	@RequestMapping(value = "/customer.bye", method = RequestMethod.GET)
	public String bye(HttpServletRequest req, Reserve r) {
		if (lDAO.loginCheck(req)) {
			rDAO.deleteID(req, r);
			lDAO.bye(req);
			lDAO.logout(req);
			req.setAttribute("lp", "cus_login.jsp");
			req.setAttribute("cp", "home.jsp");
		}
		return "index";
	}

	// 업체 정보수정으로가기
	@RequestMapping(value = "/company.info.go", method = RequestMethod.GET)
	public String companyinfo(HttpServletRequest req) {
		if (cDAO.loginCheck(req)) {
			cDAO.divideAddr(req);
			req.setAttribute("cp", "companyinfo.jsp");
			return "index2";
		} else {
			req.setAttribute("cp", "companyinfo.jsp");
		}
		return "index";
	}

	// 업체 정보 수정
	@RequestMapping(value = "/company.update", method = RequestMethod.POST)
	public String companyupdate(Reserve r, Company c, HttpServletRequest req) {
		if (cDAO.loginCheck(req)) {
			cDAO.update(c, req);
			oDAO.OrderCheck(r, req);
			req.setAttribute("cp", "OrderTable.jsp");
		}
		return "index2";
	}

	// 업체 로그아웃
	// 통합
	@RequestMapping(value = "/company.logout", method = RequestMethod.GET)
	public String companyLogout(HttpServletRequest req) {
		if (cDAO.loginCheck(req)) {
			cDAO.logout(req);
			req.setAttribute("lp", "cus_login.jsp");
		}
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	// 업체 탈퇴하기
	@RequestMapping(value = "/company.bye", method = RequestMethod.GET)
	public String combye(Company c, HttpServletRequest req) {
		if (cDAO.loginCheck(req)) {
			cDAO.combye(c, req);
			cDAO.logout(req);
			req.setAttribute("lp", "cus_login.jsp");
		}
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

}
