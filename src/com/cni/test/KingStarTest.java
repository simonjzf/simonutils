package com.cni.test;

import java.util.Random;

public class KingStarTest {

	public static void main(String[] args) {
		
		byte[] s = {'z','b','c'};
		byte[] t = {'a','b','c'};		
		System.out.println("strcmp(s,t): "+strcmp(s,t));
		
		System.out.println("-----------------------");
		
		Random r = new Random(7);
		int[][] n = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {			
				n[i][j]=r.nextInt(100)+1;
				System.out.print(n[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("The min of max numbers is "+getMin(n));
	}
	
	/*
	 * 函数说明：函数strcmp() 是比较两个字符串s 和 t 的大小，若s<t 函数返回负数，若s=t 函数返回0，若s>t 函数返回正数
	 * compareTo() 方法解析
	 * 首先，按索引值由低到高逐个比较每个索引位上的unicode 的大小，返回unicode 值差值；
	 * 其次，如果每个索引位上的unicode 大小相同，且字符串长度相同，则返回0；
	 * 最后，如果每个索引位上的unicode 大小相同，字符串长度不同，则返回长度差值
	 * 
	 */
	
	static int strcmp(byte[] s,byte[] t){
		int index=-1;
		for(int i=0;i<s.length&&i<t.length;i++){
			if(s[i]>t[i]){
				index=i;
				break;
			}		
		}
		System.out.println("index:"+index);
		return (s.length==t.length)&&(index==-1)?0:index;
	}
	
	
	
	
	static int getMin(int a[][]){
		int row,col,max,min = 0;
		for(row=0;row<a.length;row++){
			for(max=a[row][0],col=1;col<a[row].length;col++){
				if(max<a[row][col]) max=a[row][col];
			}
			if(row==0) min=max;
			else if(min>max) min=max;
		}
		return min;
	}
	
}
