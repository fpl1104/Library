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
			System.out.println("1.注册");
			System.out.println("2.登录");
			System.out.println("3.退出");
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
			System.out.println("1.普通用户注册");
			System.out.println("2.管理员注册");
			System.out.println("3.返回上一级");
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
			System.out.println("管理员界面");
			System.out.println("1.查看所有用户");
			System.out.println("2.查看所有书");
			System.out.println("3.增加书");
			System.out.println("4.修改书");
			System.out.println("5.删除书");
			System.out.println("6.借还书记录");
			System.out.println("7.查看预约记录");
			System.out.println("8.解/冻结用户");
			System.out.println("9.退出登陆");
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
			System.out.println("1.查看用户借书记录");
			System.out.println("2.查看书本被借记录");
			System.out.println("3.查看热门书籍");
			System.out.println("4.返回上一级");
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
			System.out.println("用户界面");
			System.out.println("1.查看书");
			System.out.println("2.借书");
			System.out.println("3.还书");
			System.out.println("4.预约");
			System.out.println("5.查看个人信息");
			System.out.println("6.个人记录");
			System.out.println("7.退出登陆");
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
				System.out.println("请输入书名");
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
			System.out.println("账号：");
			String name = scanner.next();
			System.out.println("密码");
			String password = scanner.next();
			User user = new User(name, password, 0);

			int res = userBiz.registerUser(user);
			if (res == 1) {
				System.out.println("此用户名已经被注册!");
			} else if (res == 2) {
				System.out.println("注册成功!");
			} else {
				System.out.println("注册失败!");
			}
			System.out.println("是否继续");
			String choose = scanner.next();
			if (choose.equals("n")) {
				break;
			}
		}
	}

	public void adminregistMenu() {
		while (true) {
			System.out.println("账号：");
			String name = scanner.next();
			System.out.println("密码");
			String password = scanner.next();
			User user = new User(name, password, 1);

			int res = userBiz.registerUser(user);
			if (res == 1) {
				System.out.println("此用户名已经被注册!");
			} else if (res == 2) {
				System.out.println("注册成功!");
			} else {
				System.out.println("注册失败!");
			}
			System.out.println("是否继续");
			String choose = scanner.next();
			if (choose.equals("n")) {
				break;
			}
		}
	}

	public void loginMenu() {
		while (true) {
			System.out.println("账号：");
			String name = scanner.next();
			System.out.println("密码");
			String password = scanner.next();
			user = new User(name, password);
			user = userBiz.login(user);

				if (user != null) {
					if (user.getCherish() > 0) {
					System.out.println("登录成功");
					if (user.getType() == 1) {
						adminloginMenu();
					} else {
						userloginMenu();
					}
				} else {
					System.out.println("该账户已被冻结");
				}
			} else {
				System.out.println("登录失败");
				break;
			}

		}
	}

	private void borrowbook() {
		if (user.getBorrowNumber() == 0) {
			System.out.println("对不起,请先还书");
		} else {
			System.out.println("请输入书的名字");
			String dname = scanner.next();
			int res = bookbiz.lendbook(dname, user.getId());
			if (res == 0) {
				System.out.println("没有你要借的书");
			} else if (res == 1) {
				System.out.println("对不起,你要借的书已经借完了");
			} else if (res == 2) {
				System.out.println("恭喜你,操作成功!");
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
			System.out.println("请输入id号");
			int id = myUtil.in();
			BorrowRecord ubooks = RecordBiz.queryRecordsById(id);
			if (ubooks != null && ubooks.getUserid() == user.getId()) {
				int res = bookbiz.returnbook(id);
				if (res == 1) {
					System.out.println("不存在此编号的书!");
				} else if (res == 2) {
					System.out.println("此书已经归还!");
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
					System.out.println("归还成功!");
				} else {
					System.out.println("归还失败!");
				}
			} else {
				System.out.println("输入有误");
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
		System.out.println("请输入用户名");
		String dname = scanner.next();
		User user1 = userBiz.selUser(dname);
		System.out.println("请输入一个整数(0为冻结)");
		int num = myUtil.in();
		user1.setCherish(num);
		if (userBiz.updateUser(user1)) {
			System.out.println("操作成功");
		}
	}

	private void showself() {

		if (user.getVip() == 0) {
			System.out.println(
					"普通用户：" + user.getUsername() + "积分为：" + user.getIntegral() + "可借书数量" + user.getBorrowNumber());
		} else if (user.getType() == 0 && user.getVip() == 1) {
			System.out.println(
					"VIP用户：" + user.getUsername() + "积分为：" + user.getIntegral() + "可借书数量" + user.getBorrowNumber());
		}
	}
}
