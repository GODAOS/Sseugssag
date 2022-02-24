package com.sseugssag.main.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseugssag.main.reserve.Reserve;
import com.sseugssag.main.reserve.ReserveMapper;

@Service
public class OrderDAO {
@Autowired
private SqlSession ss;
	public void OrderCheck(Reserve r,HttpServletRequest req) {
		//주문번호 , 날짜 , 고객 아이디, 고객이름, 고객전화번호
		//고객 주소 , 몇평인지
		//DB에 담은거 가져오기
		try {
			List<Reserve>CheckReserve=ss.getMapper(ReserveMapper.class).OrderCheck(r);
			req.setAttribute("CheckReserve", CheckReserve);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
