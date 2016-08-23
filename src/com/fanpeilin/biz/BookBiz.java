package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.Book;


public interface BookBiz {
	public boolean addBook(Book book);// ���book

	public boolean delBook(Book Book);// ɾ��book

	public boolean modifyBook(Book book);// �޸�book

	public List<Book> queryAllBookS();// ��ѯ����book

	public Book queryBookByName(String dname);// �������ֲ�ѯbook


	public List<Book> ranking_top_five();// �鿴ǰ5�����ܻ�ӭ��book

	// ��
	public int lendbook(String dname, int uid);// ����԰���ź���������
	// ��
	public int returnbook(int rid);
	
	public Book queryBookById(int bid);
}
