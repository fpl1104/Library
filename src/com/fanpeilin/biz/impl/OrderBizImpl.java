package com.fanpeilin.biz.impl;

import java.util.List;

import com.fanpeilin.biz.OrderBiz;
import com.fanpeilin.model.AppointmentBook;
import com.fanpeilin.model.Book;

import dao.AppointmentBookDao;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;

public class OrderBizImpl implements OrderBiz {
	private AppointmentBookDao Order = null;
	private BookDao bookDao = null;

	public OrderBizImpl() {
		Order = new OrderDaoImpl();
		bookDao = new BookDaoImpl();
	}

	@Override
	public boolean addBook(AppointmentBook book) {
		return Order.save(book);
	}

	@Override
	public boolean delBook(int userid) {
		return Order.del(userid);
	}

	@Override
	public boolean modifyBook(AppointmentBook book) {
		return Order.updata(book);
	}

	@Override
	public List<AppointmentBook> queryAllBookS() {
		return Order.selAll();
	}

	@Override
	public int lendbook(String dname, int uid) {

		Book book = bookDao.queryBookByName(dname);// ��ѯ
		if (book == null) {
			return 0;// û���ҵ�
		} else {
			if (book.getBookrestamount() == 0) {
				return 1;// ���ɽ裨
			} else {
				AppointmentBook record = new AppointmentBook(uid, book.getId());
				boolean flag = Order.save(record);
				if (flag) {
					return 2;
				}
				return 3;
			}
		}
	}
}
