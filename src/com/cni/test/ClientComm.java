package com.cni.test;

import java.net.*;
import java.io.*;
import java.util.*;

class ClientComm{
public static void main(String args[]) throws Exception{
	Socket socket = new Socket("localhost",123);
	System.out.println("连接已建立,连接信息如下");
	System.out.println(socket.toString());
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	BufferedReader brfs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
	String readLine =null;
	String readLineFromServer =null;
	System.out.println("Please Input words ");
	
	while(true) {
		readLine = br.readLine();
		if(readLine!=null){
			System.out.println("client 1:" + readLine);
			System.out.println("客户端 "+new Date().toString()+"\t"+readLine+"\n");
			bw.write("客户端 "+new Date().toString()+"\t"+readLine+"\n");
			bw.flush();
			}
		readLineFromServer=brfs.readLine();
		if(readLineFromServer!=null){
			System.out.println("client 2:" + readLineFromServer);
			System.out.println("服务器端 "+new Date().toString()+"\t"+readLineFromServer +"\n");
		} 
		if(readLine.equalsIgnoreCase("bye")||readLineFromServer.equalsIgnoreCase("bye"))
			break;

	}
	bw.close();
	br.close();
	brfs.close();
	socket.close();
}
}