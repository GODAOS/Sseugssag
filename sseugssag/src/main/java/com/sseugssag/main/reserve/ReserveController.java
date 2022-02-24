package com.sseugssag.main.reserve;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseugssag.main.login.Customer;
import com.sseugssag.main.login.CustomerLoginDAO;

@Controller
public class ReserveController {

	@Autowired
	private ReserveDAO rDAO;

	@Autowired
	private CustomerLoginDAO lDAO;

	// index.jsp에서 이동하는 거
	@RequestMapping(value = "/reserve.gogo", method = RequestMethod.GET)
	public String reserve(Customer c, HttpServletRequest req) {
		if (lDAO.loginCheck(req)) {
			lDAO.divideAddr(req);
			req.setAttribute("cp", "reserve.jsp");// - > 여기넣으면 화면전환 안된다!
		} else {
			req.setAttribute("cp", "home2.jsp");// 밖으로빼기
		}
		return "index";
	}


	// 예약하기
	@RequestMapping(value = "/cus_reserve", method = RequestMethod.POST)
	public String reserve3(Reserve r, HttpServletRequest req) {
		rDAO.getReserve(r, req);
		req.setAttribute("cp", "reserve_Confirm.jsp");
		lDAO.loginCheck(req);// lp
		return "index";
	}

	// 예약확인
	@RequestMapping(value = "/reserve.check", method = RequestMethod.GET)
	public String reserveCheck(Reserve r, HttpServletRequest req) {
		if (lDAO.loginCheck(req)) {
			lDAO.loginCheck(req);// lp - 로그인해야지만 예약확인가능
			lDAO.divideAddr(req);// !나눈 주소 jsp에서 연결되게 뜨게 하기위해서
			rDAO.myReserve(req, r);
			req.setAttribute("cp", "reserve_check.jsp");
		} else {
			req.setAttribute("cp", "home2.jsp");
		}
		return "index";
	}

	//예약삭제
	@RequestMapping(value = "/reserve.delete", method = RequestMethod.GET)
	public String reserveDelete(Reserve r, HttpServletRequest req) {
		if (lDAO.loginCheck(req)) {
			rDAO.deleteRS(r, req);
			rDAO.myReserve(req, r);
		}
		req.setAttribute("cp", "reserve_check.jsp");
		return "index";
	}

}
