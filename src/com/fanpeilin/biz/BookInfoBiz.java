package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.BookInfo;


public interface BookInfoBiz {
	public boolean addBook(BookInfo bookinfo);// ���

	public boolean delBook(int id);// ɾ��

	public boolean modifyBook(BookInfo bookinfo);// �޸�
	
	public List<BookInfo> selInfo(int  bid);
	public List<BookInfo> selBookInfo(int  bid);//��ɾ����Ϣ
	public BookInfo queryBookById(int id,int exist);
	public List<BookInfo> queryAllBookS();// ��ѯ����

}
