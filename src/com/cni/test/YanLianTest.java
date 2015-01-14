package com.cni.test;
import java.util.concurrent.TimeoutException;
import java.util.zip.DataFormatException;

public class YanLianTest {
	public String YanLianTest(){
		return "aa";
	}
	
	public static void main(String[] args) {
		int count = 0;
		while (count<10) {
			try {
				if (count++ == 1) {
					throw new TimeoutException();
				} else if (count == 2) {
					throw new DataFormatException();
				}
				System.out.println(count+" no exception thrown");
			} catch (TimeoutException e) {
				System.out.println(count+" TimeoutException thrown");
			} catch (DataFormatException e) {
				System.out.println(count+" DataFormatException thrown");
				break;
			} finally {
				System.out.println(count+" finally called");
			}
		}
	}
	/*
	public void Test(){
		try {
			method();
			System.out.println("Hello World");
		} catch (Exception e) {
			System.out.println("Exception1");
		}finally{
			System.out.println("Thank you!");
		}
		System.out.println("Test");
	}
	*/
	
}
