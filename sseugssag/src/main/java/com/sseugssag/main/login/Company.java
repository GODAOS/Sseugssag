package com.sseugssag.main.login;

public class Company {
private String com_id;
private String com_phone;
private String com_pw;
private String com_name;
private String com_address;
private String com_category;

public Company() {
	// TODO Auto-generated constructor stub
}

public Company(String com_id, String com_phone, String com_pw, String com_name, String com_address,
		String com_category) {
	super();
	this.com_id = com_id;
	this.com_phone = com_phone;
	this.com_pw = com_pw;
	this.com_name = com_name;
	this.com_address = com_address;
	this.com_category = com_category;
}

public String getCom_id() {
	return com_id;
}

public void setCom_id(String com_id) {
	this.com_id = com_id;
}

public String getCom_phone() {
	return com_phone;
}

public void setCom_phone(String com_phone) {
	this.com_phone = com_phone;
}

public String getCom_pw() {
	return com_pw;
}

public void setCom_pw(String com_pw) {
	this.com_pw = com_pw;
}

public String getCom_name() {
	return com_name;
}

public void setCom_name(String com_name) {
	this.com_name = com_name;
}

public String getCom_address() {
	return com_address;
}

public void setCom_address(String com_address) {
	this.com_address = com_address;
}

public String getCom_category() {
	return com_category;
}

public void setCom_category(String com_category) {
	this.com_category = com_category;
}




}
