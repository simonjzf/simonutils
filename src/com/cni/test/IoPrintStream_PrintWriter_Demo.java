package com.cni.test;
import java.io.*;

public class IoPrintStream_PrintWriter_Demo{
	public static void main(String args[]){
	try{
	BufferedReader br = new BufferedReader(new FileReader("txt.txt"));
	PrintWriter pw = new PrintWriter(new FileWriter("txt4.txt"));
	
	String s = br.readLine();
	while(s!=null){
	pw.println(s);
	s=br.readLine();
	}
	br.close();
	pw.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
}