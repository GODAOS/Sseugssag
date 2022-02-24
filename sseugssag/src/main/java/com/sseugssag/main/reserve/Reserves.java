package com.sseugssag.main.reserve;

import java.util.List;


public class Reserves {
private List<Reserve>reserve;

public Reserves() {
	// TODO Auto-generated constructor stub
}

public Reserves(List<Reserve> reserve) {
	super();
	this.reserve = reserve;
}

public List<Reserve> getReserve() {
	return reserve;
}

public void setReserve(List<Reserve> reserve) {
	this.reserve = reserve;
}

}
