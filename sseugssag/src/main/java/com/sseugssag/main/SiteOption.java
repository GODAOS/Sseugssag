package com.sseugssag.main;

public class SiteOption {
	// 페이지 당 리뷰 수
	private int rvPerPage;

	public SiteOption() {
		// TODO Auto-generated constructor stub
	}

	public SiteOption(int rvPerPage) {
		super();
		this.rvPerPage = rvPerPage;
	}

	public int getRvPerPage() {
		return rvPerPage;
	}

	public void setRvPerPage(int rvPerPage) {
		this.rvPerPage = rvPerPage;
	}
	
	
}
