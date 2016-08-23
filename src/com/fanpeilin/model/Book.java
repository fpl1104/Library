package com.fanpeilin.model;

import java.util.Random;

public class Book {
	Random random=new Random();
	private int id;
	private String bookname;
	private String booktype;
	private String bookauthor;
	private int bookrestamount;//剩余数量
	private int bookborrowtime;//借出次数
	private int bookborrowamount;//借出数量
	private int damage;

	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id,int bookrestamount, int bookborrowtime) {
		super();
		this.bookrestamount = bookrestamount;
		this.bookborrowtime = bookborrowtime;
		this.id=id;
	}

	public Book(String bookname) {
		super();
		this.bookname = bookname;
	}

	public Book(int id, int bookrestamount, int bookborrowtime, int bookborrowamount) {
		super();
		this.id = id;
		this.bookrestamount = bookrestamount;
		this.bookborrowtime = bookborrowtime;
		this.bookborrowamount = bookborrowamount;
	}

	public Book(String bookname, String booktype, String bookauthor) {
		super();
		this.bookname = bookname;
		this.booktype = booktype;
		this.bookauthor = bookauthor;
	}

	public Book(String bookname, String booktype, String bookauthor,
			int bookrestamount, int bookborrowtime, int bookborrowamount,
			int damage) {
		super();
		this.bookname = bookname;
		this.booktype = booktype;
		this.bookauthor = bookauthor;
		this.bookrestamount = bookrestamount;
		this.bookborrowtime = bookborrowtime;
		this.bookborrowamount = bookborrowamount;
		this.damage = damage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBooktype() {
		return booktype;
	}

	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public int getBookrestamount() {
		return bookrestamount;
	}

	public void setBookrestamount(int bookrestamount) {
		this.bookrestamount = bookrestamount;
	}

	public int getBookborrowtime() {
		return bookborrowtime;
	}

	public void setBookborrowtime(int bookborrowtime) {
		this.bookborrowtime = bookborrowtime;
	}

	public int getBookborrowamount() {
		return bookborrowamount;
	}

	public void setBookborrowamount(int bookborrowamount) {
		this.bookborrowamount = bookborrowamount;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
