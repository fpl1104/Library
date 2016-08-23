package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.Book;


public interface BookBiz {
	public boolean addBook(Book book);// 添加book

	public boolean delBook(Book Book);// 删除book

	public boolean modifyBook(Book book);// 修改book

	public List<Book> queryAllBookS();// 查询所有book

	public Book queryBookByName(String dname);// 根据名字查询book


	public List<Book> ranking_top_five();// 查看前5张最受欢迎的book

	// 借
	public int lendbook(String dname, int uid);// 你可以按编号和名字来借
	// 还
	public int returnbook(int rid);
	
	public Book queryBookById(int bid);
}
