package com.cni.test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoFileInput_OutputStream_Demo{
	public static void main(String args[]){
	int size;
	/*
	try{
		FileInputStream fis = new FileInputStream("2.jpg");
		FileOutputStream fos = new FileOutputStream("c.jpg");	
		int r = fis.read();
		size=r;
		System.out.println("size="+size);
		System.out.println("r="+r);
		while(r!=-1){
			fos.write(r);
			r = fis.read();
			size+=r;
		}
		System.out.println("size="+size);
		fis.close();
		fos.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	*/
	
	try{
		FileInputStream fis = new FileInputStream("2.jpg");
		FileOutputStream fos = new FileOutputStream("c.jpg");	
		byte[] b = new byte[1024];
		int r = fis.read(b);
		System.out.println("r="+r);
		size=r;
		while(r!=-1){
			fos.write(b,0,r);
			r = fis.read(b);
			size+=r;
		System.out.println("R="+r);
		}
		System.out.println("size="+(size+1));
		fis.close();
		fos.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	/*
	try{
		FileInputStream fis = new FileInputStream("2.jpg");
		FileOutputStream fos = new FileOutputStream("c.jpg");	
		byte[] b = new byte[1024];
		int r = fis.read(b,0,10);
		System.out.println("r="+r);
		size=r;
		while(r!=-1){
			fos.write(b,0,r);
			r = fis.read(b,0,10);
			size+=r;
		System.out.println("R="+r);
		}
		System.out.println("size="+(size+1));
		fis.close();
		fos.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	*/
}