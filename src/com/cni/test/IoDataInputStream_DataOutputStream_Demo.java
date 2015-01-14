package com.cni.test;

import java.io.*;

public class IoDataInputStream_DataOutputStream_Demo {
	public static void main(String args[]) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(
					"dos.txt"));
			dos.writeUTF("马立.贾正峰。");
			dos.writeInt(23);
			dos.close();

			DataInputStream dis = new DataInputStream(new FileInputStream(
					"dos.txt"));
			System.out.println("Name:" + dis.readUTF());
			System.out.println("Age:" + dis.readInt());
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}