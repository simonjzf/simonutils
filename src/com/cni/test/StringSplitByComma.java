package com.cni.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringSplitByComma {

	
	public static void main(String[] args) throws IOException {
//		String[] str = split("123,45,25,85,99,103,193");
		long start,end;
		String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		start = System.nanoTime();
//		String[] str = split(s);
		String[] str = s.split(",");
		
		int[] res = new int[str.length];
		for (int i = 0; i < res.length; i++) {
			res[i]=Integer.parseInt(str[i]);
		}
		Arrays.sort(res);
		System.out.println("升序");
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		System.out.println("降序");
		for (int i = res.length-1; i >=0; i--) {
			System.out.println(res[i]);
		}
		
		end = System.nanoTime();
		System.out.println("StringSplitByComma Run time is "+(end-start));
	}

	public static String[] split(String str){
		if(str==null||str.trim().equals("")){
			return null;
		}
		StringTokenizer stk = new StringTokenizer(str,",");
		String[] res = new String[stk.countTokens()];
		int i=0;
		while(stk.hasMoreTokens()){
			res[i]=stk.nextToken();
			i++;
		}
		return res;
	}
}
