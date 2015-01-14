package com.cni.test;
import java.util.ArrayList;
import java.util.List;

public class RoytelTestFirst {
	
	private static List<String> test1(List<String> lst) {
		lst.add("3");
		return lst;
	}

	private static List<String> test2(List<String> lst) {
		lst.add("3");
		List<String> lst1 = new ArrayList<String>();
		lst1.add("4");
		return lst1;
	}

	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		lst.add("1");
		List lst1 = test1(lst);
		lst.add("2");
		System.out.println(lst.toString());// 1,3,2
		System.out.println(lst1.toString());// 1,3,2
		List lst2 = test2(lst);
		lst2.add("5");
		System.out.println(lst.toString());// 1,3,2,3
		System.out.println(lst2.toString());// 4,5
	}

}
