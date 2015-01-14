package com.cni.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoCopyBytes {
	public static void main(String[] args) {
		long start ,end;
		start = System.currentTimeMillis();
		String sFile, oFile;

		if (args.length < 2) {
			System.out.println("USE:java copyBytes source file | object file");
			return;
		} else {
			sFile = args[0];
			oFile = args[1];
		}
		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(new File(sFile)));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(new File(oFile)));
			int c;
			while ((c = bis.read()) != -1) {
				bos.write(c);
			}
			bis.close();
			bos.close();
		} catch (Exception e) {
			System.err.println();
		}
		end = System.currentTimeMillis();
		try {
			DataOutputStream bs = new DataOutputStream(new FileOutputStream(new File("d:\\record.txt")));
			bs.writeUTF("this app copy file run time : ");
			bs.writeLong(end-start);
			bs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}

}
