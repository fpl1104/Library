package com.fanpeilin.model;

public class BookInfo {
	private int id;
	private int boodid;
	private String bookname;
	private int exist=1;
	private int damage=1;
	private int lost=1;
	
	
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookInfo(int boodid) {
		super();
		this.boodid = boodid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoodid() {
		return boodid;
	}
	public void setBoodid(int boodid) {
		this.boodid = boodid;
	}
	public int getExist() {
		return exist;
	}
	public void setExist(int exist) {
		this.exist = exist;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", boodid=" + boodid + ", bookname=" + bookname + ", exist=" + exist + ", damage="
				+ damage + ", lost=" + lost + "]";
	}
	
	
}
