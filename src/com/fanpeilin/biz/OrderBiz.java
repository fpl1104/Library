package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.AppointmentBook;


public interface OrderBiz {
	public boolean addBook(AppointmentBook book);// ���book

	public boolean delBook(int userid);// ɾ��book

	public boolean modifyBook(AppointmentBook book);// �޸�book

	public List<AppointmentBook> queryAllBookS();// ��ѯ����book
	public int lendbook(String dname, int uid);

}
