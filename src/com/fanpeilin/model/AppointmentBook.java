package com.fanpeilin.model;

public class AppointmentBook {
	private int id;
	private int userid;
	private int bookid;
	
	public AppointmentBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentBook( int userid, int bookid) {
		super();
		this.userid = userid;
		this.bookid = bookid;
	}
	public int getid() {
		return id;
	}
	public void setAbid(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "‘§‘ºÕº È±Ì –Ú∫≈" + id + ", userid=" + userid
				+ ", bookid=" + bookid + "]";
	}
	
	
}
