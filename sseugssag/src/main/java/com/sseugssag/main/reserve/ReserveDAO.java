package com.sseugssag.main.reserve;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseugssag.main.login.Customer;
import com.sseugssag.main.login.MemberMapper;

@Service
public class ReserveDAO {
	/*
	 * 고객 예약날짜 input : String이고 db는 date니까 형변환? 이름 string받아오고 번호:string 주소:!하는거 하고
	 * 평수는 숫자
	 */
	@Autowired
	private SqlSession ss;

	public void getReserve(Reserve r, HttpServletRequest req) {
		try {
			// 날짜 name y m d
			// int -> String -> date(simpledateformat)
			int y = Integer.parseInt(req.getParameter("y"));
			int m = Integer.parseInt(req.getParameter("m"));
			int d = Integer.parseInt(req.getParameter("d"));

			String date1 = String.format("%d%02d%02d", y, m, d);
			// 이게 형식지정
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			// 진짜 date만드릭
			// string->Date format
			// date -> string parse

			Date r_date = (Date) sdf.parse(date1);
			r.setR_date(r_date);

			Customer c = (Customer) req.getSession().getAttribute("loginCustomer");

			r.setR_id(c.getC_id());
			r.setR_name(c.getC_name());
			r.setR_address(c.getC_address());
			r.setR_phone(c.getC_phone());
			r.setR_address(c.getC_address());

			String r_area = req.getParameter("r_area");
			r.setR_area(r_area);
			// jsp넘기기위해서 - 세션넘기기
			if (ss.getMapper(ReserveMapper.class).getReserve(r) == 1) {
				req.setAttribute("r", "예약성공! -db확인");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "예약실패 -db에 안들어감");
		}
	}

	// 개인 예약 확인
	public void myReserve(HttpServletRequest req, Reserve r) {
		try {
			Customer c = (Customer) req.getSession().getAttribute("loginCustomer");
			r.setR_id(c.getC_id());
			List<Reserve> ms = ss.getMapper(ReserveMapper.class).reserveRoding(r);
			req.setAttribute("myRS", ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 예약 삭제
	public void deleteRS(Reserve r, HttpServletRequest req) {
		try {
			if (ss.getMapper(ReserveMapper.class).deleteRs(r) == 1) {
				req.setAttribute("r", "글이 성공적으로 삭제되었습니다");
			} else {
				req.setAttribute("r", "글 삭제 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "글 삭제 실패 2");
		}
	}

	public void deleteID(HttpServletRequest req, Reserve r) {
		try {
			Customer c = (Customer) req.getSession().getAttribute("loginCustomer");
			r.setR_id(c.getC_id());
			if (ss.getMapper(ReserveMapper.class).deleteID(r) == 1) {
				req.setAttribute("r", "글이 성공적으로 삭제되었습니다");
			} else {
				req.setAttribute("r", "글 삭제 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
