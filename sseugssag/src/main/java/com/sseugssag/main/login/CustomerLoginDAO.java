package com.sseugssag.main.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerLoginDAO {
	@Autowired
	private SqlSession ss;

	public void customerjoin(Customer c, HttpServletRequest req) {
		try {
			// 고객 이름,번호,아이디,비번받아오기
			String c_name = req.getParameter("c_name");
			c.setC_name(c_name);
			String c_phone = req.getParameter("c_phone");
			c.setC_phone(c_phone);
			String c_id = req.getParameter("c_id");
			c.setC_id(c_id);
			String c_pw = req.getParameter("c_pw");
			c.setC_pw(c_pw);

			// 주소 받아오기
			String c_addr1 = req.getParameter("c_addr1");
			; // 우편번호 : 12631
			String c_addr2 = req.getParameter("c_addr2"); // 서울시 서초구 서초대로(도로명주소)
			String c_addr3 = req.getParameter("c_addr3"); // 자이@ 203-2507
			String c_address = c_addr1 + "\t" + c_addr2 + "\t" + c_addr3; // 서울시 서초구 서초대로!자이@ 203-2507!12631
			c.setC_address(c_address);//db에 이렇게 담김

			if (ss.getMapper(MemberMapper.class).join(c) == 1) {
				req.setAttribute("r", "가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "가입실패");
		}
	}

	// 아이디중복체크
	// jQuery-getJSON:은 responsebody를 사용해야하느데
	// customer를 담을 리스트빈을 만들어야함->Customers
	// 그리고 mapper에서 insert로 id만 뽑고난 후에
	// 리턴자체를 리스트로
	// 아직 구현 x!
	/*public Customers CustomerIdCheck(Customer inputID, HttpServletRequest req) {
		return new Customers(ss.getMapper(MemberMapper.class).idCheck(inputID));
	}*/

	// 로그인
	public void CustomerLogin(Customer inputC, HttpServletRequest req) {
		try {
			List<Customer> dbms = ss.getMapper(MemberMapper.class).getCustomerById(inputC);
			if (dbms.size() != 0) {
				Customer dbM = dbms.get(0);
				if (dbM.getC_pw().equals(inputC.getC_pw())) {
					req.getSession().setAttribute("loginCustomer", dbM);
					req.getSession().setMaxInactiveInterval(600);
					req.setAttribute("r", "로그인성공");
				} else {
					req.setAttribute("r", "비밀번호오류");
				}
			} else {
				req.setAttribute("r", "미가입아이디");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public Customers customerIdChecks(Customer c, HttpServletRequest req) {
		return new Customers(ss.getMapper(MemberMapper.class).getCustomerById(c));
	}*/

	// 로그인 성공 체크
	public boolean loginCheck(HttpServletRequest req) {
		Customer c = (Customer) req.getSession().getAttribute("loginCustomer");
		if (c != null) { //로그인이 성공시
			req.setAttribute("lp","welcome.jsp");
			return true;
			
		} else {//로그인실패시
			req.setAttribute("lp","cus_login.jsp");
			return false;
		}
	}
	
	//주소 !나누는거 - 이거안하면 getsession할 때 ! 기준으로 뜸
	public void divideAddr(HttpServletRequest req) {
		Customer c = (Customer)req.getSession().getAttribute("loginCustomer");
		//입력한주소 받아와서 !기준으로 나누기
		String addr=c.getC_address();
		String[] addr2=addr.split("\t");
		req.setAttribute("addr", addr2);
		
	}

	//로그아웃
	//세션을 null로 두기만 하면 된다!
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginCustomer", null);
	}
	
	//회원정보수정
	// 홈페이지에서 바로 안바뀌고 수정실패뜨는데 db에보면 고객 휴대폰번호는 바껴져있음
	// jsp에서 ""빼머거따.,
	public void update(Customer c,HttpServletRequest req) {
		//수정하기전에 로그인정보 하기오도록
		try {
			String c_id=req.getParameter("c_id");
			String c_pw=req.getParameter("c_pw");
			String c_name=req.getParameter("c_name");
			String c_phone=req.getParameter("c_phone");
			String c_addr1 = req.getParameter("c_addr1");
			String c_addr2 = req.getParameter("c_addr2"); 
			String c_addr3 = req.getParameter("c_addr3"); 
			
			c.setC_id(c_id);
			c.setC_pw(c_pw);
			c.setC_name(c_name);
			c.setC_phone(c_phone);
			c.setC_address(c_addr1 + "\t" + c_addr2 + "\t" + c_addr3);
			//c.setC_address(c_addr1+c_addr2+c_addr3);
			
			// 주소[0] ! 상세주소[1] ! 우편번호[2]
			//System.out.printf(c_id,c_pw,c_name,c_phone);
			//System.out.printf(c_addr1,c_addr2,c_addr3); 
			if (ss.getMapper(MemberMapper.class).update(c)==1) {
				req.setAttribute("r", "수정성공");
				//바뀐정보는 새로운자바빈에 담아야지 로그아웃 안하고도 바로 적용가능
				req.getSession().setAttribute("loginCustomer", c);
			}
		} catch (Exception e) {
			req.setAttribute("r", "수정실패");
		}
	}
	
	//탈퇴하기
	public void bye(HttpServletRequest req){
		try {
			//로그인되어있는정보가져오기
			Customer c = (Customer)req.getSession().getAttribute("loginCustomer");
			if (ss.getMapper(MemberMapper.class).bye(c)==1) {
				req.setAttribute("r", "탈퇴성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴성공");
		}
	}
}

















