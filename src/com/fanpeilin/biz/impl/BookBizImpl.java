package com.fanpeilin.biz.impl;
import java.util.*;
import java.text.SimpleDateFormat;

import com.fanpeilin.biz.BookBiz;
import com.fanpeilin.biz.BookInfoBiz;
import com.fanpeilin.model.Book;
import com.fanpeilin.model.BookInfo;
import com.fanpeilin.model.BorrowRecord;

import dao.BookDao;
import dao.BorrowRecordDao;
import dao.impl.BookDaoImpl;
import dao.impl.RecordDaoImpl;

public class BookBizImpl implements BookBiz{
	Random random=null;
	BookInfoBiz bib = new BookInfoBizImpl();
	private BookDao bookDao = null;
	private BorrowRecordDao recordDao = null;
	public BookBizImpl() {
		bookDao = new BookDaoImpl();
		recordDao = new RecordDaoImpl();
		random=new Random();
	}
	@Override
	public boolean addBook(Book book) {
		return bookDao.save(book);
	}
	@Override
	public boolean delBook(Book book) {
		return bookDao.del(book);
	}
	@Override
	public boolean modifyBook(Book book) {
		return bookDao.updata(book);
	}
	@Override
	public List<Book> queryAllBookS() {
		return bookDao.selAll();
	}
	@Override
	public Book queryBookByName(String dname) {
		return bookDao.queryBookByName(dname);
	}
	@Override
	public List<Book> ranking_top_five() {
		return bookDao.querySortBookByLimit(0, 5);
	}
	@Override
	public int lendbook(String dname, int uid) {
		Book book = bookDao.queryBookByName(dname);// ��ѯ
		if (book == null) {
			return 0;// û���ҵ�
		} else {
			if (book.getBookrestamount() <= 0&&book.getDamage()<=0) {
				return 1;// ���ɽ裨
			} else {
				book.setBookrestamount(book.getBookrestamount()-1);//����ʣ������
				book.setBookborrowtime(book.getBookborrowtime()+1);//���½������
				book.setBookborrowamount(book.getBookborrowamount()+1);
				boolean flag1 = bookDao.updata(book);// ����
				BorrowRecord record = new BorrowRecord(uid, book.getId(),
						new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
						null);
				boolean flag2 = recordDao.saveRecord(record);// ����һ���軹��¼
				Book book1 = queryBookByName(dname);
				BookInfo bookinfo = bib.queryBookById(book.getId(),1);
				bookinfo.setExist(0);
				bib.modifyBook(bookinfo);
			
				if (flag1 && flag2) {
					return 2;// ����ɹ�!
				} else {
					return 3;// ���ʧ��
				}
			}
		}
	}

	@Override
	public int returnbook(int rid) {
		int a =random.nextInt(101);
		BorrowRecord record = recordDao.queryRecordById(rid);
		if (record == null) {
			return 1;// ���벻��ȷ
		} else if (record.getLendtime() != null) {
			return 2;// �����ѹ黹
		} else {
			record.setLendtime(new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()));
			boolean flag1 = recordDao.updateRecord(record);// ���¼�¼��
			Book book=bookDao.queryBookById(record.getBiid());
			book.setBookrestamount(book.getBookrestamount()+1);;
			book.setBookborrowamount(book.getBookborrowamount()-1);
			book.setDamage(a);
			boolean flag2 = bookDao.updata(book);//���±�
			if (flag1&&flag2) {
				return 3;// �黹�ɹ�
			} else {
				return 4;// �黹ʧ��
			}
		}
	}
	@Override
	public Book queryBookById(int bid) {
		return bookDao.queryBookById(bid);
	}




}
