package com.sseugssag.main.reserve;

import java.math.BigDecimal;
import java.util.Date;

public class Reserve {
	private String r_id;
	private String r_name;
	private String r_phone;
	private String r_address;
	private BigDecimal r_num;
	private String r_area;
	private Date r_date;


public Reserve() {
	// TODO Auto-generated constructor stub
}


public Reserve(String r_id, String r_name, String r_phone, String r_address, BigDecimal r_num, String r_area,
		Date r_date) {
	super();
	this.r_id = r_id;
	this.r_name = r_name;
	this.r_phone = r_phone;
	this.r_address = r_address;
	this.r_num = r_num;
	this.r_area = r_area;
	this.r_date = r_date;
}


public String getR_id() {
	return r_id;
}


public void setR_id(String r_id) {
	this.r_id = r_id;
}


public String getR_name() {
	return r_name;
}


public void setR_name(String r_name) {
	this.r_name = r_name;
}


public String getR_phone() {
	return r_phone;
}


public void setR_phone(String r_phone) {
	this.r_phone = r_phone;
}


public String getR_address() {
	return r_address;
}


public void setR_address(String r_address) {
	this.r_address = r_address;
}


public BigDecimal getR_num() {
	return r_num;
}


public void setR_num(BigDecimal r_num) {
	this.r_num = r_num;
}


public String getR_area() {
	return r_area;
}


public void setR_area(String r_area) {
	this.r_area = r_area;
}


public Date getR_date() {
	return r_date;
}


public void setR_date(Date r_date) {
	this.r_date = r_date;
}


}