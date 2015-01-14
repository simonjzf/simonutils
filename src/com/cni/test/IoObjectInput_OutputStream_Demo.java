package com.cni.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IoObjectInput_OutputStream_Demo {	
	
	public static void main(String[] args) throws IOException{
		MakeObjectFile mko = new MakeObjectFile();
		mko.mkof();
		System.out.println("ok");
		mko.readFile();
	}
}

class MakeObjectFile implements java.io.Serializable {
	public String str= new String();
	public void mkof(){
		try {
			FileOutputStream fos = new FileOutputStream("mkobj.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			MakeObjectFile mof = new MakeObjectFile();
			mof.str = "abcd";
			oos.writeObject(mof);
			oos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readFile(){			
		try {
			FileInputStream fis = new FileInputStream("mkobj.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			MakeObjectFile mof = (MakeObjectFile)ois.readObject();
			System.out.println(mof.str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}