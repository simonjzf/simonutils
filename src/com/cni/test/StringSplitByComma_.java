package com.cni.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSplitByComma_ {
	public static void main(String[] args) throws IOException {
//		char[] c = args[0].toCharArray();
//		char[] c = new char[];
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		long start,end;
		start = System.nanoTime();
		char[] c = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ',') {
				count++;
			}
		}

		int[] res = new int[count + 1];
		count = 0;
		for (int j = 0; j < c.length; j++) {

			if (c[j] == ',') {
				count++;
				res[count - 1] = Integer.parseInt(sb.toString());
				sb = new StringBuffer();
				continue;
			} else {
				sb.append(c[j]);
				if (j == c.length - 1) {
					count++;
					res[count - 1] = Integer.parseInt(sb.toString());
				}
			}

		}
/**
 * @author Simon
 * 选择法排序
 */
//		for (int i = 0; i < res.length; i++) {
//			for (int j = i + 1; j < res.length; j++) {
//				int temp;
//				if (res[i] > res[j]) {
//					temp = res[i];
//					res[i] = res[j];
//					res[j] = temp;
//				}
//
//			}
//		}
		
/**
 * @author Simon
 * 冒泡法排序
 */		
		for (int i = 0; i < res.length-1; i++) {
			for (int j = 0; j < res.length-i-1; j++) {
				int temp;
				if (res[j] > res[j+1]) {
					temp = res[j+1];
					res[j+1] = res[j];
					res[j] = temp;
				}

			}
		}
		
		System.out.println("升序");
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);

		}
		System.out.println("降序");
		for (int i = res.length-1; i >= 0; i--) {
			System.out.println(res[i]);

		}
		end = System.nanoTime();
		System.out.println("StringSplitByComma Run time is "+(end-start));
	}

}
