package com.cni.test;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ServerComm_ {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        // 创建服务器套接字
        serverSocket = new ServerSocket(4700);
        Socket clientSocket = null;
        // 从服务器套接字中获取客户机套接字
        System.out.println("正在连接客户机.....");
        clientSocket = serverSocket.accept();
        // 获取一个输入流
        System.out.println("连接成功 - clientSocket.toString()：" + clientSocket.toString());
        System.out.println("连接成功 - serverSocket.toString()：" + serverSocket.toString());
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("br.toString():"+br.toString());
        System.out.println("br.readLine():"+br.readLine());
        System.out.println("br.read():"+br.read());
        String inLine;
        while ((inLine = br.readLine()) != null) {
            System.out.println(inLine);
            if ("bye".equals(inLine))
                break;
        }
        br.close();
        clientSocket.close();
        serverSocket.close();
    }
}