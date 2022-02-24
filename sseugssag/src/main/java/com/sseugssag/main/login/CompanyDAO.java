package com.sseugssag.main.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CompanyDAO {
	@Autowired
	private SqlSession ss;

	public void companyjoin(Company com, HttpServletRequest req) {
		try {
			String com_id = req.getParameter("com_id");
			com.setCom_id(com_id);

			String com_pw = req.getParameter("com_pw");
			com.setCom_pw(com_pw);

			String com_phone = req.getParameter("com_phone");
			com.setCom_phone(com_phone);

			String com_name = req.getParameter("com_name");
			com.setCom_name(com_name);

			// 주소 jsp에서 input으로 받은 거 세개 합치기
			String com_addr1 = req.getParameter("com_addr1"); // 우편번호 : 12631
			String com_addr2 = req.getParameter("com_addr2"); // 서울시 서초구 서초대로(도로명주소)
			String com_addr3 = req.getParameter("com_addr3"); // 자이@ 203-2507
			String com_address = com_addr1 + "\t" + com_addr2 + "\t" + com_addr3; // 서울시 서초구 서초대로!자이@ 203-2507!12631
			//String com_address=com_addr1+com_addr2+com_addr3;
			com.setCom_address(com_address);

			// 문제 - com_phone이 담김- 이건 mapper연결 잘못함 .., db랑 똑같은 순서로
			// <input radio>에 value값이 세개라
			// 몇번째인지 확인하는 반복문이 필요함
			String[] category = req.getParameterValues("com_category");
			for (int i = 0; i < category.length; i++) {
				System.out.println(category[i]);
				com.setCom_category(category[i]); // db에 어떻게 담을건지
			}

			if (ss.getMapper(MemberMapper.class).com_join(com) == 1) {
				req.setAttribute("r", "가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "가입실패");
		}
	}

	// 로그인
	public void CompanyLogin(Company com, HttpServletRequest req) {
		try {
			List<Company> dbms = ss.getMapper(MemberMapper.class).getCompanyById(com);
			if (dbms.size() != 0) {
				Company dbM = dbms.get(0);
				if (dbM.getCom_pw().equals(com.getCom_pw())) {
					req.getSession().setAttribute("loginCompany", dbM);
					req.getSession().setMaxInactiveInterval(600);
					req.setAttribute("r", "로그인성공");
				} else {
					req.setAttribute("r", "비밀번호오류");
				}
			} else {
				req.setAttribute("r", "미가입아이디");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 로그인 성공 체크
	public boolean loginCheck(HttpServletRequest req) {
		Company c = (Company) req.getSession().getAttribute("loginCompany");
		if (c != null) {
			req.setAttribute("lp", "welcome2.jsp");
			return true;
		} else {//로그인실패시
			req.setAttribute("lp", "cus_login.jsp");
			return false;
		}
	}

	// 주소나누는거
	public void divideAddr(HttpServletRequest req) {
		Company c = (Company) req.getSession().getAttribute("loginCompany");
		// 입력한주소 받아와서 !기준으로 나누기
		String addr = c.getCom_address();
		String[] addr2 = addr.split("\t");
		req.setAttribute("addr", addr2);

	}

	// 로그아웃
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginCompany", null);
		req.setAttribute("r", "로그아웃성공");
	}

	// 정보수정
	public void update(Company c, HttpServletRequest req) {
		Company lc = (Company) req.getSession().getAttribute("loginCompany");
		try {
			String com_id = req.getParameter("com_id");
			String com_pw = req.getParameter("com_pw");
			String com_phone = req.getParameter("com_phone");
			String com_name = req.getParameter("com_name");
			String com_addr1 = req.getParameter("com_addr1"); // 우편번호 : 12631
			String com_addr2 = req.getParameter("com_addr2"); // 서울시 서초구 서초대로(도로명주소)
			String com_addr3 = req.getParameter("com_addr3"); // 자이@ 203-2507
			//String com_address = com_addr2 + "\t" + com_addr3 + "\t" + com_addr1; // 서울시 서초구 서초대로!자이@ 203-2507!12631
			String[] category = req.getParameterValues("com_category");
			for (int i = 0; i < category.length; i++) {
				c.setCom_category(category[i]);
			}
			c.setCom_id(com_id);
			c.setCom_pw(com_pw);
			c.setCom_phone(com_phone);
			c.setCom_name(com_name);
			c.setCom_address(com_addr1 + "\t" + com_addr2 + "\t" + com_addr3);
			
			
			if (ss.getMapper(MemberMapper.class).update_company(c)==1) {
				req.setAttribute("r", "수정성공");
				req.getSession().setAttribute("loginCompany", c);//자바빈에서 새로운 정보담기
			}
			

		} catch (Exception e) {
			req.setAttribute("r", "수정실패");
		}
	}
//탈퇴하기
	public void combye(Company com,HttpServletRequest req) {
		try {
			//세션
			Company c = (Company)req.getSession().getAttribute("loginCompany");
			if (ss.getMapper(MemberMapper.class).bye_company(c)==1) {
				req.setAttribute("r", "탈 퇴 성 공");
				req.getSession().setAttribute("loginCompany",com);
			}
			
		} catch (Exception e) {
			req.setAttribute("r", "탈 퇴 실 패");
			e.printStackTrace();
		}
	}
}
