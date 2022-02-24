package com.sseugssag.main.chat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseugssag.main.login.CustomerLoginDAO;

@Controller
public class ChatController {

	@Autowired
	private CustomerLoginDAO lDAO;
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chathome1(HttpServletRequest req) {
		lDAO.loginCheck(req);
		req.setAttribute("cp", "chat.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/chat.go", method = RequestMethod.POST)
	public String chat(HttpServletRequest req) {
		req.setAttribute("chat", "chatting.jsp");
		return "chatHome";
	}
	
	@RequestMapping(value = "/chatbot.go", method = RequestMethod.POST)
	public String chatbot(HttpServletRequest req) {
		req.setAttribute("chat", "chatbot.jsp");
		return "chatHome";
	}
	
}
