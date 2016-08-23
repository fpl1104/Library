package dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fanpeilin.model.Book;

import dao.BookDao;


public class BookDaoImpl extends BaseDaoImpl implements BookDao{

	@Override
	public boolean save(Book book) {
		sql = "insert into book(bookname,booktype,bookauthor)values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(book.getBookname());
		params.add(book.getBooktype());
		params.add(book.getBookauthor());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean del(Book book) {
		sql = "update book set bookrestamount=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(book.getBookrestamount()-1);
		params.add(book.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updata(Book book) {
		sql = "update book set bookrestamount=?,bookborrowtime=?,bookborrowamount=?,damage=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(book.getBookrestamount());
		params.add(book.getBookborrowtime());
		params.add(book.getBookborrowamount());
		params.add(book.getDamage());
		params.add(book.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public Book sel(Book book) {
		List<Book> uList=null;
		sql="select id,bookname,booktype,bookauthor,bookrestamount,bookborrowtime,bookborrowamount from book where bookname=? and bookauthor=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(book.getBookname());
		params.add(book.getBookauthor());
		try {
			uList=this.operQuery(sql, params,Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(uList.size()>0){
			return uList.get(0);
		}
		return null;
	}

	@Override
	public List<Book> selAll() {
		String sql = "select * from Book";
		List<Book> dList = null;
		try {
			dList = this.operQuery(sql, null, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

	@Override
	public Book queryBookByName(String dname) {
		String sql = "select id,bookname,booktype,bookauthor,bookrestamount,bookborrowtime,bookborrowamount,damage from book where bookname=?";
		List<Object> params = new ArrayList<Object>();
		Book book = null;
		params.add(dname);
		List<Book> dList = null;
		try {
			dList = this.operQuery(sql, params, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dList.size() > 0) {
			book = dList.get(0);
		}
		return book;
	}
	//≈≈–Ú
	@Override
	public List<Book> querySortBookByLimit(int index, int number) {
		String sql = "select id,bookname,bookauthor,bookborrowtime from book order by bookborrowtime desc limit "
				+ index + "," + number;
		List<Book> dList = null;
		try {
			dList = this.operQuery(sql, null, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

	@Override
	public Book queryBookById(int bok) {
		String sql = "select id,bookname,booktype,bookauthor,bookrestamount,bookborrowtime,bookborrowamount,damage from book where id=?";
		List<Object> params = new ArrayList<Object>();
		Book book = null;
		params.add(bok);
		List<Book> dList = null;
		try {
			dList = this.operQuery(sql, params, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dList.size() > 0) {
			book = dList.get(0);
		}
		return book;
	}
	}


