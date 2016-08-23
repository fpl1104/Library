package com.fanpeilin.model;

public class BorrowRecord {
	private int id;
	private int userid;
	private int biid;//Õº Èπ› È±Ì
	private String username;
	private String bookname;
	private String borrowtime;
	private String lendtime;
	
	public BorrowRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BorrowRecord(int userid, int biid) {
		super();
		this.userid = userid;
		this.biid = biid;
	}



	



	public BorrowRecord(int userid, int biid, String borrowtime, String lendtime) {
		super();
		this.userid = userid;
		this.biid = biid;
		this.borrowtime = borrowtime;
		this.lendtime = lendtime;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getRid() {
		return id;
	}
	public void setRid(int rid) {
		this.id = rid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBiid() {
		return biid;
	}
	public void setBiid(int biid) {
		this.biid = biid;
	}
	public String getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	public String getLendtime() {
		return lendtime;
	}
	public void setLendtime(String lendtime) {
		this.lendtime = lendtime;
	}
	
	
}
