package com.sseugssag.main.review;

import java.math.BigDecimal;
import java.util.Date;

public class Review {
	//member
	private String c_id;
	
	//board
	private BigDecimal r_no;
	private String r_photo;
	private String r_txt;
	private Date r_date;
	
	//star
	private String r_star;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String c_id, BigDecimal r_no, String r_photo, String r_txt, Date r_date, String r_star) {
		super();
		this.c_id = c_id;
		this.r_no = r_no;
		this.r_photo = r_photo;
		this.r_txt = r_txt;
		this.r_date = r_date;
		this.r_star = r_star;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public BigDecimal getR_no() {
		return r_no;
	}

	public void setR_no(BigDecimal r_no) {
		this.r_no = r_no;
	}

	public String getR_photo() {
		return r_photo;
	}

	public void setR_photo(String r_photo) {
		this.r_photo = r_photo;
	}

	public String getR_txt() {
		return r_txt;
	}

	public void setR_txt(String r_txt) {
		this.r_txt = r_txt;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public String getR_star() {
		return r_star;
	}

	public void setR_star(String r_star) {
		this.r_star = r_star;
	}

}