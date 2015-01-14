package com.cni.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class NumTransferToEn {

	public static void main(String[] args) throws Exception {
		String str = null;
		do{
		System.out.println("Please input number(1-10):");
		
		str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Input number is '"+str+"' has been transfered to ");
		
		switch(Integer.parseInt(str)){
		case 0:System.out.println("zero");break;
		case 1:System.out.println("one");break;
		case 2:System.out.println("two");break;
		case 3:System.out.println("three");break;
		case 4:System.out.println("four");break;
		case 5:System.out.println("five");break;
		case 6:System.out.println("six");break;
		case 7:System.out.println("seven");break;
		case 8:System.out.println("eight");break;
		case 9:System.out.println("nine");break;
		case 10:System.out.println("ten");break;
		default:System.out.println("Not a number or the number >10");
		}
		}while (Integer.parseInt(str)<=10);
		
	}

}
