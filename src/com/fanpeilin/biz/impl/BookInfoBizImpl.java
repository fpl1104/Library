package com.fanpeilin.biz.impl;

import java.util.List;

import com.fanpeilin.biz.BookInfoBiz;
import com.fanpeilin.model.BookInfo;

import dao.BookInfoDao;
import dao.impl.BookInfoDaoImpl;

public class BookInfoBizImpl implements BookInfoBiz{
	private BookInfoDao bookinfoDao = null;
	public BookInfoBizImpl() {
		bookinfoDao = new BookInfoDaoImpl();
	}
	
	@Override
	public boolean addBook(BookInfo bookinfo) {
		// TODO Auto-generated method stub
		return bookinfoDao.save(bookinfo);
	}

	@Override
	public boolean delBook(int id) {
		// TODO Auto-generated method stub
		return bookinfoDao.del(id);
	}

	@Override
	public boolean modifyBook(BookInfo bookinfo) {
		// TODO Auto-generated method stub
		return bookinfoDao.updata(bookinfo);
	}

	@Override
	public List<BookInfo> queryAllBookS() {
		// TODO Auto-generated method stub
		return bookinfoDao.selAll();
	}

	@Override
	public List<BookInfo> selInfo(int bid) {
		// TODO Auto-generated method stub
		return bookinfoDao.sel(bid);
	}

	@Override
	public List<BookInfo> selBookInfo(int bid) {
		// TODO Auto-generated method stub
		return bookinfoDao.selInfo(bid);
	}

	@Override
	public BookInfo queryBookById(int id,int exist) {
		// TODO Auto-generated method stub
		return bookinfoDao.sel(id,exist);
	}

}
