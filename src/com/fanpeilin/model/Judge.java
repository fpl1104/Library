package com.fanpeilin.model;

public class Judge {
	private int id;
	private int userid;
	private int star;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Judge [id=" + id + ", userid=" + userid + ", star=" + star
				+ ", content=" + content + "]";
	}
	
	
}
