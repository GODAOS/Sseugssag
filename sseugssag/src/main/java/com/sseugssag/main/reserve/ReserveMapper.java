package com.sseugssag.main.reserve;

import java.util.List;

public interface ReserveMapper {

	//예약하기 
	public abstract int getReserve(Reserve r);
	
	//기업 예약 확인
	public abstract List<Reserve> OrderCheck(Reserve r);

	//개인 예약 확인
	public abstract List<Reserve> reserveRoding(Reserve r);

	// 개인 예약 삭제
	public abstract int deleteRs(Reserve r);
	
	// 탈퇴시 예약 삭제
	public abstract int deleteID(Reserve r);
}
