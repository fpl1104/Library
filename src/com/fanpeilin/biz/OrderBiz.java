package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.AppointmentBook;


public interface OrderBiz {
	public boolean addBook(AppointmentBook book);// 添加book

	public boolean delBook(int userid);// 删除book

	public boolean modifyBook(AppointmentBook book);// 修改book

	public List<AppointmentBook> queryAllBookS();// 查询所有book
	public int lendbook(String dname, int uid);

}
