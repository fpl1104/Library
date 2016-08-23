package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.BookInfo;


public interface BookInfoBiz {
	public boolean addBook(BookInfo bookinfo);// 添加

	public boolean delBook(int id);// 删除

	public boolean modifyBook(BookInfo bookinfo);// 修改
	
	public List<BookInfo> selInfo(int  bid);
	public List<BookInfo> selBookInfo(int  bid);//可删的信息
	public BookInfo queryBookById(int id,int exist);
	public List<BookInfo> queryAllBookS();// 查询所有

}
