package com.cni.test;

import java.io.*;

public class IoBufferedReader_Writer_Demo {
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("txt.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("txt3.txt"));

			String s = br.readLine();
			while (s != null) {
				bw.write(s);
				bw.newLine();
				s = br.readLine();
			}
			br.close();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}