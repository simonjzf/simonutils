package com.cni.test;
import java.io.*;

public class IoFileReader_Writer_Demo{
	public static void main(String args[]){
	try{
		FileReader fr = new FileReader("txt.txt");
		FileWriter fw = new FileWriter("txt2.txt");
		
		int r = fr.read();
		while(r!=-1){
			fw.write(r);
			r=fr.read();
		}
		fr.close();
		fw.close();
	}catch(IOException e){
		e.printStackTrace();
	}	
	}

}