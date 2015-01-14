package com.cni.test;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FTPClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("wins2-web-hk01.xincache.cn", 21);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();

		byte[] buffer = new byte[100];
		int length = is.read(buffer);
		String s = new String(buffer, 0, length);
		System.out.println(s);
		
		String str = "USER host2451132\n";
		os.write(str.getBytes());
		length = is.read(buffer);
		s = new String(buffer, 0, length);
		System.out.println(s);
		
		str = "PASS S8W6h9M8\n";
		os.write(str.getBytes());
		length = is.read(buffer);
		s = new String(buffer, 0, length);
		System.out.println(s);
		
		str = "CWD /www\n";
		os.write(str.getBytes());
		length = is.read(buffer);
		s = new String(buffer, 0, length);
		System.out.println(s);

		str = "EPSV ALL\n";
		os.write(str.getBytes());
		length = is.read(buffer);
		s = new String(buffer, 0, length);
		System.out.println(s);

		str = "EPSV\n";
		os.write(str.getBytes());
		length = is.read(buffer);
		s = new String(buffer, 0, length);
		System.out.println(s);

		String portlist = s.substring(s.indexOf("(|||") + 4, s.indexOf("|)"));
		System.out.println(portlist);

		ShowList sl = new ShowList();
		sl.port = Integer.parseInt(portlist);
		sl.start();

		str = "LIST\n";
		os.write(str.getBytes());
		length = is.read(buffer);
		s = new String(buffer, 0, length);
		System.out.println(s);

		is.close();
		os.close();
		socket.close();
	}
}

class ShowList extends Thread {
	public int port = 0;

	public void run() {
		try {
			Socket socket = new Socket("183.90.185.46", this.port);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			byte[] buffer = new byte[10000];
			int length = is.read(buffer);
			String s = new String(buffer, 0, length);
			System.out.println(s);
			is.close();
			os.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
