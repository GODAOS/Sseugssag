package com.sseugssag.main.login;

import java.util.List;
// responsebody쓸면 뭉덩이로 보내야할 리스트 자바빈 필요함
public class Customers {
private List<Customer>customer;

public Customers() {
	// TODO Auto-generated constructor stub
}

public Customers(List<Customer> customer) {
	super();
	this.customer = customer;
}

public List<Customer> getCustomer() {
	return customer;
}

public void setCustomer(List<Customer> customer) {
	this.customer = customer;
}



}
