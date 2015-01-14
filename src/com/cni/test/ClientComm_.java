package com.cni.test;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class ClientComm_ {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        System.out.println("建立一个C/S连接...");
        socket = new Socket("localhost", 4700);
        System.out.println("连接成功,请输入信息测试(bye)结束:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("Socket.toString()：" + socket.toString());
        System.out.println("br.toString():"+br.toString());
        System.out.println("br.readLine():"+br.readLine());
        System.out.println("br.read():"+br.read());
        
        System.out.println("bw.toString():"+bw.toString());

        String inLine;
        while ((inLine = br.readLine()) != null) {
        	System.out.println("readLine inwhile1:"+inLine);
        	System.out.println("br.readLine() inwhile:"+br.readLine());
        	System.out.println("readLine inwhile2:"+inLine);
            bw.write(inLine + "\n");
            bw.flush();
            if ("bye".equals(inLine))
                break;
        }
        bw.close();
        br.close();
        socket.close();
    }
}




