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

	// �鿴�����û�
	public void showAllusers() {
		List<User> users = userBiz.selAll();
		if (users.size() > 0) {
			System.out.println("id\t����\tVIP�û�\t�û�����\t�ɽ�������\t��ϧ��");
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				System.out.println(user.getId() + "\t" + user.getUsername() + "\t" + user.getVip() + "\t"
						+ user.getIntegral() + "\t" + user.getBorrowNumber()+"\t"+user.getCherish());
			}
		} else {
			System.out.println("���û���Ϣ!");
		}
	}

	public void addbook() {
		System.out.println("�������������");
		String bname = scanner.next();
		bname.trim();
		System.out.println("�������������");
		String btype = scanner.next();
		btype.trim();
		System.out.println("�������������");
		String bau = scanner.next();
		bau.trim();
		Book book1 = bookbiz.queryBookByName(bname);
		Book book = new Book(bname, btype, bau);
		if (book1 != null) {
			if (book1.getBookname().equals(bname)) {
				System.out.println("�ظ���!");
			}
		} else if (bookbiz.addBook(book)) {
			Book book2 = bookbiz.queryBookByName(bname);
			BookInfo bookInfo = new BookInfo(book2.getId());
			if (bib.addBook(bookInfo)) {
				System.out.println("��ӳɹ�!");
			}
		} else {
			System.out.println("���ʧ��!");
		}
	}

	public void updatabook() {
		List<BookInfo> books1 = null;
		List<BookInfo> books = null;
		System.out.println("��������ID");
		int bid = myUtil.in();
		System.out.println("���������ʣ������");
		int bamount = myUtil.in();
		System.out.println("��������Ľ������");
		int btime = myUtil.in();
		Book book = new Book(bid, bamount, btime);
		if (bookbiz.modifyBook(book)) {
			Book book1 = bookbiz.queryBookById(bid);
			books = bib.selBookInfo(bid);// ��ɾ��
			books1 = bib.selInfo(bid);// ���е�
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
				System.out.println("���Ժ�");
			}
			System.out.println("�����ɹ�!");
		} else {
			System.out.println("����ʧ��!");
		}
	}

	public void delbook() {
		System.out.println("������������");
		String bname = scanner.next();
		bname.trim();
		Book book = bookbiz.queryBookByName(bname);
		if (book.getBookrestamount() > 0) {
			if (bookbiz.delBook(book)) {
				System.out.println("�����ɹ�!");
			} else {
				System.out.println("����ʧ��!");
			}
		} else {
			System.out.println("����ʧ��!");
		}
	}

	public void selAllbook() {
		List<Book> books = bookbiz.queryAllBookS();
		if (books.size() > 0) {
			System.out.println("id\t����\t����\t����\tʣ���鱾����");
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				System.out.println(book.getId() + "\t" + book.getBookname() + "\t" + book.getBooktype() + "\t"
						+ book.getBookauthor() + "\t" + book.getBookrestamount());
			}
		} else {
			System.out.println("���鱾��Ϣ!");
		}
	}

	public void selAllbookInfo() {
		List<BookInfo> books = bib.queryAllBookS();
		if (books.size() > 0) {
			System.out.println("id\t���\t�Ƿ���ͼ���\t�Ƿ���\t�Ƿ�ʧ");
			for (int i = 0; i < books.size(); i++) {
				BookInfo book = books.get(i);
				System.out.println(book.getId() + "\t" + book.getBoodid() + "\t" + book.getExist() + "\t"
						+ book.getDamage() + "\t" + book.getLost());
			}
		} else {
			System.out.println("����Ϣ!");
		}
	}

	public int recordbyuser(String name) {
		List<BorrowRecord> ubooks = RecordBiz.queryUserRecords(name);
		if (ubooks != null && ubooks.size() > 0) {
			System.out.println("id\t�û���\t������\t���ʱ��\t�黹ʱ��");
			for (BorrowRecord record : ubooks) {
				System.out.println(record.getRid() + "\t" + record.getUsername() + "\t" + record.getBookname() + "\t"
						+ record.getBorrowtime() + "\t"
						+ (record.getLendtime() == null ? "δ�黹" : record.getLendtime()));
			}
		} else {
			System.out.println("û�н軹�����Ϣ!");
			return 0;
		}
		return 1;
	}

	public void queryUserRecords() {
		System.out.println("������Ҫ��ѯ���û���:");
		String uname = scanner.next();
		uname.trim();
		recordbyuser(uname);
	}

	public void recordbybook() {
		System.out.println("������Ҫ��ѯ������:");
		String name = scanner.next();
		name.trim();
		List<BorrowRecord> ubooks = RecordBiz.queryUserRecords(name);
		if (ubooks != null && ubooks.size() > 0) {
			System.out.println("id\t�û���\t����\t���ʱ��\t�黹ʱ��");
			for (BorrowRecord record : ubooks) {
				System.out.println(record.getRid() + "\t" + record.getUsername() + "\t" + record.getBookname() + "\t"
						+ record.getBorrowtime() + "\t"
						+ (record.getLendtime() == null ? "δ�黹" : record.getLendtime()));
			}
		} else {
			System.out.println("û�н軹�����Ϣ!");
		}
	}

	public void showRakingBooks() {
		List<Book> books = bookbiz.ranking_top_five();
		if (books.size() > 0) {
			System.out.println("id\t������\t�������\t״̬");
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				System.out.println(book.getId() + "\t" + book.getBookname() + "\t" + book.getBookborrowtime() + "\t"
						+ (book.getBookrestamount() > 0 ? "�ɽ�" : "�ѽ�"));
			}
		} else {
			System.out.println("����Ϣ!");
		}
	}

	public void showAllOrders() {
		List<AppointmentBook> books = order.queryAllBookS();
		if (books.size() > 0) {
			System.out.println("id\t�û�ID\t��ID");
			for (int i = 0; i < books.size(); i++) {
				AppointmentBook book = books.get(i);
				System.out.println(book.getid() + "\t" + book.getUserid() + "\t" + book.getBookid());
			}
		} else {
			System.out.println("����Ϣ!");
		}
	}
}
