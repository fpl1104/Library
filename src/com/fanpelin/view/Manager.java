package com.fanpelin.view;

import java.util.List;
import java.util.Scanner;

import com.fanpeilin.biz.BookBiz;
import com.fanpeilin.biz.BookInfoBiz;
import com.fanpeilin.biz.IRecordBiz;
import com.fanpeilin.biz.OrderBiz;
import com.fanpeilin.biz.UserBiz;
import com.fanpeilin.biz.impl.BookBizImpl;
import com.fanpeilin.biz.impl.BookInfoBizImpl;
import com.fanpeilin.biz.impl.OrderBizImpl;
import com.fanpeilin.biz.impl.RecordBizImpl;
import com.fanpeilin.biz.impl.UserBizImpl;
import com.fanpeilin.model.AppointmentBook;
import com.fanpeilin.model.Book;
import com.fanpeilin.model.BookInfo;
import com.fanpeilin.model.BorrowRecord;
import com.fanpeilin.model.User;

public class Manager {
	UserBiz userBiz = new UserBizImpl();
	Scanner scanner = new Scanner(System.in);
	BookBiz bookbiz = new BookBizImpl();
	IRecordBiz RecordBiz = new RecordBizImpl();
	BookInfoBiz bib = new BookInfoBizImpl();
	OrderBiz order = new OrderBizImpl();

	// 查看所有用户
	public void showAllusers() {
		List<User> users = userBiz.selAll();
		if (users.size() > 0) {
			System.out.println("id\t名字\tVIP用户\t用户积分\t可借书数量\t爱惜度");
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				System.out.println(user.getId() + "\t" + user.getUsername() + "\t" + user.getVip() + "\t"
						+ user.getIntegral() + "\t" + user.getBorrowNumber()+"\t"+user.getCherish());
			}
		} else {
			System.out.println("无用户信息!");
		}
	}

	public void addbook() {
		System.out.println("请输入书的名字");
		String bname = scanner.next();
		bname.trim();
		System.out.println("请输入书的类型");
		String btype = scanner.next();
		btype.trim();
		System.out.println("请输入书的作者");
		String bau = scanner.next();
		bau.trim();
		Book book1 = bookbiz.queryBookByName(bname);
		Book book = new Book(bname, btype, bau);
		if (book1 != null) {
			if (book1.getBookname().equals(bname)) {
				System.out.println("重复啦!");
			}
		} else if (bookbiz.addBook(book)) {
			Book book2 = bookbiz.queryBookByName(bname);
			BookInfo bookInfo = new BookInfo(book2.getId());
			if (bib.addBook(bookInfo)) {
				System.out.println("添加成功!");
			}
		} else {
			System.out.println("添加失败!");
		}
	}

	public void updatabook() {
		List<BookInfo> books1 = null;
		List<BookInfo> books = null;
		System.out.println("请输入书ID");
		int bid = myUtil.in();
		System.out.println("请输入书的剩余数量");
		int bamount = myUtil.in();
		System.out.println("请输入书的借出次数");
		int btime = myUtil.in();
		Book book = new Book(bid, bamount, btime);
		if (bookbiz.modifyBook(book)) {
			Book book1 = bookbiz.queryBookById(bid);
			books = bib.selBookInfo(bid);// 可删除
			books1 = bib.selInfo(bid);// 所有的
			if (books != null) {
				if (bamount > books1.size()) {
					for (int i = 0; i < bamount - books1.size(); i++) {
						BookInfo bookInfo = new BookInfo(bid);
						bib.addBook(bookInfo);
					}
				}
				if (bamount < books1.size()) {
					for (int i = 0; i < books1.size() - bamount; i++) {
						bib.delBook(books.get(i).getId());
					}
				}
				System.out.println("请稍后");
			}
			System.out.println("操作成功!");
		} else {
			System.out.println("操作失败!");
		}
	}

	public void delbook() {
		System.out.println("请输入书名字");
		String bname = scanner.next();
		bname.trim();
		Book book = bookbiz.queryBookByName(bname);
		if (book.getBookrestamount() > 0) {
			if (bookbiz.delBook(book)) {
				System.out.println("操作成功!");
			} else {
				System.out.println("操作失败!");
			}
		} else {
			System.out.println("操作失败!");
		}
	}

	public void selAllbook() {
		List<Book> books = bookbiz.queryAllBookS();
		if (books.size() > 0) {
			System.out.println("id\t书名\t类型\t作者\t剩余书本数量");
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				System.out.println(book.getId() + "\t" + book.getBookname() + "\t" + book.getBooktype() + "\t"
						+ book.getBookauthor() + "\t" + book.getBookrestamount());
			}
		} else {
			System.out.println("无书本信息!");
		}
	}

	public void selAllbookInfo() {
		List<BookInfo> books = bib.queryAllBookS();
		if (books.size() > 0) {
			System.out.println("id\t书号\t是否在图书馆\t是否损坏\t是否丢失");
			for (int i = 0; i < books.size(); i++) {
				BookInfo book = books.get(i);
				System.out.println(book.getId() + "\t" + book.getBoodid() + "\t" + book.getExist() + "\t"
						+ book.getDamage() + "\t" + book.getLost());
			}
		} else {
			System.out.println("无信息!");
		}
	}

	public int recordbyuser(String name) {
		List<BorrowRecord> ubooks = RecordBiz.queryUserRecords(name);
		if (ubooks != null && ubooks.size() > 0) {
			System.out.println("id\t用户名\t书名字\t借出时间\t归还时间");
			for (BorrowRecord record : ubooks) {
				System.out.println(record.getRid() + "\t" + record.getUsername() + "\t" + record.getBookname() + "\t"
						+ record.getBorrowtime() + "\t"
						+ (record.getLendtime() == null ? "未归还" : record.getLendtime()));
			}
		} else {
			System.out.println("没有借还书的信息!");
			return 0;
		}
		return 1;
	}

	public void queryUserRecords() {
		System.out.println("请输入要查询的用户名:");
		String uname = scanner.next();
		uname.trim();
		recordbyuser(uname);
	}

	public void recordbybook() {
		System.out.println("请输入要查询的书名:");
		String name = scanner.next();
		name.trim();
		List<BorrowRecord> ubooks = RecordBiz.queryUserRecords(name);
		if (ubooks != null && ubooks.size() > 0) {
			System.out.println("id\t用户名\t名字\t借出时间\t归还时间");
			for (BorrowRecord record : ubooks) {
				System.out.println(record.getRid() + "\t" + record.getUsername() + "\t" + record.getBookname() + "\t"
						+ record.getBorrowtime() + "\t"
						+ (record.getLendtime() == null ? "未归还" : record.getLendtime()));
			}
		} else {
			System.out.println("没有借还书的信息!");
		}
	}

	public void showRakingBooks() {
		List<Book> books = bookbiz.ranking_top_five();
		if (books.size() > 0) {
			System.out.println("id\t书名字\t借出次数\t状态");
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				System.out.println(book.getId() + "\t" + book.getBookname() + "\t" + book.getBookborrowtime() + "\t"
						+ (book.getBookrestamount() > 0 ? "可借" : "已借"));
			}
		} else {
			System.out.println("无信息!");
		}
	}

	public void showAllOrders() {
		List<AppointmentBook> books = order.queryAllBookS();
		if (books.size() > 0) {
			System.out.println("id\t用户ID\t书ID");
			for (int i = 0; i < books.size(); i++) {
				AppointmentBook book = books.get(i);
				System.out.println(book.getid() + "\t" + book.getUserid() + "\t" + book.getBookid());
			}
		} else {
			System.out.println("无信息!");
		}
	}
}
