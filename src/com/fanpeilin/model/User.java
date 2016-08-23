package com.fanpeilin.model;

import java.util.Random;

public class User {
	Random random=new Random();
	private int id;
	private String username;
	private String password;
	private int integral;// 积分
	private int vip;
	private int borrowNumber;
	private int type;
	private int Cherish;// 爱惜

	public User(String username, String password, int type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, int integral, int vip, int borrowNumber, int cherish) {
		super();
		this.username = username;
		this.password = password;
		this.integral = integral;
		this.vip = vip;
		this.borrowNumber = borrowNumber;
		this.Cherish = cherish;
	}

	public User(int id,int integral, int vip, int borrowNumber, int cherish) {
		super();
		this.id=id;
		this.integral = integral;
		this.vip = vip;
		this.borrowNumber = borrowNumber;
		Cherish = cherish;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public int getBorrowNumber() {
		return borrowNumber;
	}

	public void setBorrowNumber(int borrowNumber) {
		this.borrowNumber = borrowNumber;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setvip(int vip) {
		this.vip = vip;
	}

	public int getVip() {
		return vip;
	}

	public int getCherish() {
		return Cherish;
	}

	public void setCherish(int cherish) {
		Cherish = cherish;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "用户：" + username + ", 积分：" + integral + ", 是否为vip：" + vip + ", 可借书数量" + borrowNumber + ", 用户类型：" + type
				+ "。";
	}

}
