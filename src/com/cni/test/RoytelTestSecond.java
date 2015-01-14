package com.cni.test;
public class RoytelTestSecond {

	public static String str = "i am RoytelTestSecond";
	static{
		int i = 88;
	}
	public static void main(String[] args) {
		RoytelTestSecond rts1 = new RoytelTestSecond();
		RoytelTestSecond rts2 = new RoytelTestSecond();
		rts1.str = "i am rts1";
		rts2.str = "i am rts2";
		System.out.println(rts1.str);
		System.out.println(rts2.str);
		rts2.str=null;
		System.out.println(str);
		System.out.println(rts1.str);
		System.out.println(rts2.str);
		
	}

}
