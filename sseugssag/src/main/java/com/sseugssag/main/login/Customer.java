package com.sseugssag.main.login;

public class Customer {
private String c_id;
private String c_pw;
private String c_name;
private String c_phone;
private String c_address;

public Customer() {
	// TODO Auto-generated constructor stub
}

public Customer(String c_id, String c_pw, String c_name, String c_phone, String c_address) {
	super();
	this.c_id = c_id;
	this.c_pw = c_pw;
	this.c_name = c_name;
	this.c_phone = c_phone;
	this.c_address = c_address;
}

public String getC_id() {
	return c_id;
}

public void setC_id(String c_id) {
	this.c_id = c_id;
}

public String getC_pw() {
	return c_pw;
}

public void setC_pw(String c_pw) {
	this.c_pw = c_pw;
}

public String getC_name() {
	return c_name;
}

public void setC_name(String c_name) {
	this.c_name = c_name;
}

public String getC_phone() {
	return c_phone;
}

public void setC_phone(String c_phone) {
	this.c_phone = c_phone;
}

public String getC_address() {
	return c_address;
}

public void setC_address(String c_address) {
	this.c_address = c_address;
}





}
