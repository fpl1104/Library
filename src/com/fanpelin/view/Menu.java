package com.fanpelin.view;

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
import com.fanpeilin.model.Book;
import com.fanpeilin.model.BookInfo;
import com.fanpeilin.model.BorrowRecord;
import com.fanpeilin.model.User;

public class Menu {
	Scanner scanner = new Scanner(System.in);
	UserBiz userBiz = new UserBizImpl();
	BookBiz bookbiz = new BookBizImpl();
	OrderBiz order = new OrderBizImpl();
	BookInfoBiz bib = new BookInfoBizImpl();
	IRecordBiz RecordBiz = new RecordBizImpl();
	Manager man = new Manager();
	User user = null;

	public void mainMenu() {
		while (true) {
			System.out.println("1.ע��");
			System.out.println("2.��¼");
			System.out.println("3.�˳�");
			String choose = scanner.next();
			switch (choose) {
			case "1":
				registMenu();
				break;
			case "2":
				loginMenu();
				break;
			case "3":
				System.exit(0);

			default:
				break;
			}
		}
	}

	public void registMenu() {
		while (true) {
			System.out.println("1.��ͨ�û�ע��");
			System.out.println("2.����Աע��");
			System.out.println("3.������һ��");
			String choose = scanner.next();
			switch (choose) {
			case "1":
				userregistMenu();
				break;
			case "2":
				adminregistMenu();
				break;
			case "3":
				mainMenu();
			default:
				break;
			}
		}
	}

	public void adminloginMenu() {
		while (true) {
			System.out.println("����Ա����");
			System.out.println("1.�鿴�����û�");
			System.out.println("2.�鿴������");
			System.out.println("3.������");
			System.out.println("4.�޸���");
			System.out.println("5.ɾ����");
			System.out.println("6.�軹���¼");
			System.out.println("7.�鿴ԤԼ��¼");
			System.out.println("8.��/�����û�");
			System.out.println("9.�˳���½");
			String choose = scanner.next();
			switch (choose) {
			case "1":
				man.showAllusers();
				break;
			case "3":
				man.addbook();
				break;
			case "4":
				man.updatabook();
				break;
			case "5":
				man.delbook();
				break;
			case "2":
				man.selAllbook();
				break;
			case "6":
				recordMenu();
				break;
			case "7":
				man.showAllOrders();
				break;
			case "8":
				Frozen();
				break;
			case "9":
				mainMenu();
				break;
			default:
				break;
			}
		}
	}

	public void recordMenu() {
		while (true) {
			System.out.println("1.�鿴�û������¼");
			System.out.println("2.�鿴�鱾�����¼");
			System.out.println("3.�鿴�����鼮");
			System.out.println("4.������һ��");
			String choose = scanner.next();
			switch (choose) {
			case "1":
				man.queryUserRecords();
				break;
			case "2":
				man.recordbybook();
				break;
			case "3":
				man.showRakingBooks();
				break;
			case "4":
				adminloginMenu();
				break;
			default:
				break;
			}
		}
	}

	public void userloginMenu() {
		while (true) {
			System.out.println("�û�����");
			System.out.println("1.�鿴��");
			System.out.println("2.����");
			System.out.println("3.����");
			System.out.println("4.ԤԼ");
			System.out.println("5.�鿴������Ϣ");
			System.out.println("6.���˼�¼");
			System.out.println("7.�˳���½");
			String choose = scanner.next();
			switch (choose) {
			case "1":
				man.selAllbook();
				break;
			case "2":
				borrowbook();
				break;
			case "3":
				returnbook();
				break;
			case "4":
				System.out.println("����������");
				String bname = scanner.next();
				IO.myThread(bname);
				bookbiz.lendbook(bname, user.getId());
				break;
			case "5":
				showself();
				break;
			case "6":
				man.recordbyuser(user.getUsername());
				break;
			case "7":
				mainMenu();
				break;
			default:
				break;
			}
		}
	}

	public void userregistMenu() {
		while (true) {
			System.out.println("�˺ţ�");
			String name = scanner.next();
			System.out.println("����");
			String password = scanner.next();
			User user = new User(name, password, 0);

			int res = userBiz.registerUser(user);
			if (res == 1) {
				System.out.println("���û����Ѿ���ע��!");
			} else if (res == 2) {
				System.out.println("ע��ɹ�!");
			} else {
				System.out.println("ע��ʧ��!");
			}
			System.out.println("�Ƿ����");
			String choose = scanner.next();
			if (choose.equals("n")) {
				break;
			}
		}
	}

	public void adminregistMenu() {
		while (true) {
			System.out.println("�˺ţ�");
			String name = scanner.next();
			System.out.println("����");
			String password = scanner.next();
			User user = new User(name, password, 1);

			int res = userBiz.registerUser(user);
			if (res == 1) {
				System.out.println("���û����Ѿ���ע��!");
			} else if (res == 2) {
				System.out.println("ע��ɹ�!");
			} else {
				System.out.println("ע��ʧ��!");
			}
			System.out.println("�Ƿ����");
			String choose = scanner.next();
			if (choose.equals("n")) {
				break;
			}
		}
	}

	public void loginMenu() {
		while (true) {
			System.out.println("�˺ţ�");
			String name = scanner.next();
			System.out.println("����");
			String password = scanner.next();
			user = new User(name, password);
			user = userBiz.login(user);

				if (user != null) {
					if (user.getCherish() > 0) {
					System.out.println("��¼�ɹ�");
					if (user.getType() == 1) {
						adminloginMenu();
					} else {
						userloginMenu();
					}
				} else {
					System.out.println("���˻��ѱ�����");
				}
			} else {
				System.out.println("��¼ʧ��");
				break;
			}

		}
	}

	private void borrowbook() {
		if (user.getBorrowNumber() == 0) {
			System.out.println("�Բ���,���Ȼ���");
		} else {
			System.out.println("�������������");
			String dname = scanner.next();
			int res = bookbiz.lendbook(dname, user.getId());
			if (res == 0) {
				System.out.println("û����Ҫ�����");
			} else if (res == 1) {
				System.out.println("�Բ���,��Ҫ������Ѿ�������");
			} else if (res == 2) {
				System.out.println("��ϲ��,�����ɹ�!");
				user.setBorrowNumber(user.getBorrowNumber() - 1);
				User euser = new User(user.getId(), user.getIntegral(), user.getVip(), user.getBorrowNumber(),
						user.getCherish());
				userBiz.updateUser(euser);
				// Book book = bookbiz.queryBookByName(dname);
				// BookInfo bookinfo = bib.queryBookById(book.getId(),1);
				// bookinfo.setExist(0);
				// bib.modifyBook(bookinfo);

			}
		}
	}

	private void returnbook() {
		int a = man.recordbyuser(user.getUsername());
		if (a != 0) {
			System.out.println("������id��");
			int id = myUtil.in();
			BorrowRecord ubooks = RecordBiz.queryRecordsById(id);
			if (ubooks != null && ubooks.getUserid() == user.getId()) {
				int res = bookbiz.returnbook(id);
				if (res == 1) {
					System.out.println("�����ڴ˱�ŵ���!");
				} else if (res == 2) {
					System.out.println("�����Ѿ��黹!");
				} else if (res == 3) {
					user.setIntegral(user.getIntegral() + 1);
					user.setBorrowNumber(user.getBorrowNumber() + 1);
					setvip();
					BorrowRecord br = RecordBiz.queryRecordsById(id);
					Book book = bookbiz.queryBookById(br.getBiid());
					BookInfo bookinfo = bib.queryBookById(br.getBiid(), 0);
					bookinfo.setExist(1);
					bib.modifyBook(bookinfo);
					if (book.getDamage() != 0) {
						user.setCherish(user.getCherish() - book.getDamage());
					}
					User euser = new User(user.getId(), user.getIntegral(), user.getVip(), user.getBorrowNumber(),
							user.getCherish());
					userBiz.updateUser(euser);
					System.out.println("�黹�ɹ�!");
				} else {
					System.out.println("�黹ʧ��!");
				}
			} else {
				System.out.println("��������");
			}
		}
	}

	private void setvip() {
		if (user.getIntegral() > 10) {
			user.setvip(1);
			user.setBorrowNumber(4);
		}
	}

	private void Frozen() {
		System.out.println("�������û���");
		String dname = scanner.next();
		User user1 = userBiz.selUser(dname);
		System.out.println("������һ������(0Ϊ����)");
		int num = myUtil.in();
		user1.setCherish(num);
		if (userBiz.updateUser(user1)) {
			System.out.println("�����ɹ�");
		}
	}

	private void showself() {

		if (user.getVip() == 0) {
			System.out.println(
					"��ͨ�û���" + user.getUsername() + "����Ϊ��" + user.getIntegral() + "�ɽ�������" + user.getBorrowNumber());
		} else if (user.getType() == 0 && user.getVip() == 1) {
			System.out.println(
					"VIP�û���" + user.getUsername() + "����Ϊ��" + user.getIntegral() + "�ɽ�������" + user.getBorrowNumber());
		}
	}
}
