package com.fanpelin.view;

import java.util.Scanner;

public class myUtil {
	public static int in() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ѡ��");
		int num = -1;
		while (num < 0) {
			try {
				num = scanner.nextInt();
				
			} catch (Exception e) {
				scanner.next();
//				System.out.println("������������������");
			}
			if (num<0) {
				System.out.println("������������������");
			}
		}
//		scanner.close();
		
		return num;
		
	}

	
}