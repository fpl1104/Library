package com.fanpelin.view;

import java.util.Scanner;

public class myUtil {
	public static int in() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请选择");
		int num = -1;
		while (num < 0) {
			try {
				num = scanner.nextInt();
				
			} catch (Exception e) {
				scanner.next();
//				System.out.println("输入有误，请重新输入");
			}
			if (num<0) {
				System.out.println("输入有误，请重新输入");
			}
		}
//		scanner.close();
		
		return num;
		
	}

	
}