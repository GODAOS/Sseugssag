package com.sseugssag.main.calculate;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class CalcDAO {
	public void calculate(POJO po, HttpServletRequest req) {
		DecimalFormat df = new DecimalFormat("###,###");

		if (po.getCal() >= 1 && po.getCal() <= 9) {
			req.setAttribute("result", "150,000");
		} else if (po.getCal() >= 10 && po.getCal() <= 18) {
			req.setAttribute("result", "200,000");
		} else if(po.getCal()>=19){
			//int result = 200000+(po.getCal()-18)*10900;
			int result=po.getCal()*10900;
			String result1=df.format(result);
			req.setAttribute("result", result1);
		}
	}
}
