package com.fanpelin.view;

import java.util.Scanner;

import com.fanpeilin.biz.OrderBiz;
import com.fanpeilin.biz.impl.OrderBizImpl;

public class IO {

	public static OrderBiz order = new OrderBizImpl();
	Scanner scanner = new Scanner(System.in);

	public static void myThread(String bname) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				int res =order.lendbook(bname, 3);
				if (res==0) {
					System.out.println("���޴���");
				}else if (res==1) {
					System.out.println("��������");
				}else if (res==2) {
					System.out.println("ԤԼ�ɹ�,����ѷ���.����1���Ӻ����");
					long etime = System.currentTimeMillis() + 10000;
					while (etime > System.currentTimeMillis()) {
					}
					System.out.println("�鵽��");
				}
			}
		}).start();

	}

}
