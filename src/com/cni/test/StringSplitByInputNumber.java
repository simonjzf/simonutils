package com.cni.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringSplitByInputNumber {

	public static void main(String[] args) throws IOException{
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
//		String str ="javaweb星.ada";
//		int n=4;
		String[] strs = stringSplitByInputNumber(str,n);
		System.out.println("source string :"+str+"\t split number:"+n);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}
	
	public static String[] stringSplitByInputNumber(String str,int n){
		String[] res = new String[new Double(Math.ceil((double)str.length()/n)).intValue()];
		for (int i = 0,j=0; i <str.length(); i+=n,j++) {		
			if(i+n>str.length()){
				res[j] = str.substring(i, str.length());
			}else{
				res[j] = str.substring(i, i+n);				
			}
		}
		return res;
	}
}
