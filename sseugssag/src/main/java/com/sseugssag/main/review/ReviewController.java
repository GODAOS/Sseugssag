package com.sseugssag.main.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseugssag.main.TokenMaker;
import com.sseugssag.main.login.LoginDAO;

@Controller
public class ReviewController {

	
	@Autowired
	private LoginDAO lgDAO;
	
	private boolean isFirstReq;

	//ReviewContrller 자체 생성자
	public ReviewController() {
		// TODO Auto-generated constructor stub
		isFirstReq = true;
	}
	
	@Autowired
	private ReviewDAO rDAO;


	@RequestMapping(value = "/review.go", method = RequestMethod.GET)
	public String goReview(Review r, HttpServletRequest req) {
		if (isFirstReq) {
			rDAO.countReview();
			isFirstReq = false; //반대상황에는 같은 동작이 반복되도록
			
		}
		
		rDAO.countReview();
		lgDAO.loginCheck(req);
		rDAO.searchClear(req); //아무 검색도 되지 않은 상태여야 함
		rDAO.getReviewPage(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "review/review.jsp");
		return "index";
	}

	@RequestMapping(value = "/review.write", method = RequestMethod.POST)
	public String writeReview(Review r, HttpServletRequest req) {
		//로그인이 되었을때만 리뷰쓰기가 가능하도록 if문
		if (lgDAO.loginCheck(req)) {
			rDAO.writeReview(r, req);
		}
		rDAO.getReviewPage(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "review/review.jsp");
		return "index";

	}
	
	@RequestMapping(value = "/review.page.change", method = RequestMethod.GET)
	public String reviewPageChange(HttpServletRequest req) {
		lgDAO.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		rDAO.getReviewPage(p, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "review/review.jsp");
		return "index";
	}
	
	
	//여기는 parameter에 DTO없었는데 별점 때문에 추가 하려다가 삭제
	@RequestMapping(value = "/review.search", method = RequestMethod.POST)
	public String reviewSearch(HttpServletRequest req) {
		lgDAO.loginCheck(req);
		rDAO.searchRv(req);
		rDAO.getReviewPage(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.delete", method = RequestMethod.GET)
	public String reviewDelete(Review r, HttpServletRequest req) {
		if (lgDAO.loginCheck(req)) {
			rDAO.deleteRv(r, req);
		}
		
		rDAO.getReviewPage(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.update", method = RequestMethod.GET)
	public String reviewUpdate(Review r, HttpServletRequest req) {
		if (lgDAO.loginCheck(req)) {
			rDAO.updateRv(r, req);
		}
		
		rDAO.getReviewPage(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "review/review.jsp");
		return "index";
	}
	
}
