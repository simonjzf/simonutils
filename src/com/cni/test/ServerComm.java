package com.cni.test;

import java.net.*;
import java.io.*;
import java.util.*;

class ServerComm {

	public static void main(String args[]) throws Exception {
		ServerSocket server = new ServerSocket(123);
		System.out.println("等待客户端连接...");
		Socket socket = server.accept();
		System.out.println("客户端已连接，连接信息如下：");
		System.out.println(server.toString());
		System.out.println(socket.toString());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader brfc = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String readLine = null;
		String readLineFromClient = null;
		
		while (true) {			
			readLine = br.readLine();
			if (readLine!= null) {
				System.out.println("服务器端 " + new Date().toString() + "\t"	+ readLine + "\n");
				bw.write("服务器端 " + new Date().toString() + "\t" + readLine + "\n");
				bw.flush();
				readLine = br.readLine();
			}
			readLineFromClient = brfc.readLine();
			if (readLineFromClient!= null) {				
				System.out.println("server 2:" + readLineFromClient);
				System.out.println("客户端 " + new Date().toString() + "\t" + readLineFromClient + "\n");
			}
			if(readLine.equalsIgnoreCase("bye")||readLineFromClient.equalsIgnoreCase("bye"))
				break;

		}
		bw.close();
		br.close();
		brfc.close();
		socket.close();
		server.close();
	}
}