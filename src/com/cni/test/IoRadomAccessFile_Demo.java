package com.cni.test;

import java.io.RandomAccessFile;

public class IoRadomAccessFile_Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String str;
			byte[] s;
			RandomAccessFile rf = new RandomAccessFile("temp.txt ", "rw");

			long count = rf.length();

			rf.seek(count);

			// 如要换行，用 \r\n 次序不要乱

			for (int i = 0; i < 4; i++) {
				str = "这是第   " + i + "行文本示例\r\n ";
				s = str.getBytes();
				rf.write(s);
			}
			rf.close();

		} catch (Exception e) {
			System.err.println("读写出错 ");
			e.printStackTrace();
		}
	}

}

/*
  try{ 
          RandomAccessFile   rf=new   RandomAccessFile( "temp.txt ", "rw "); 
        
          String   str= " "; 
          
          int   count=(int)rf.length(); 
          
          //注意，此处我把long转换为int，实际操作中文件较大时，你还用long 
          
          //但分成若干次读入，一次读一部分。 
          
          byte[]   s=new   byte[count]; 
          
          rf.read(s); 
          
          str=new   String(s); 
          
          System.out.println(str); 
          rf.close(); 
        }catch(Exception   e){ 
        } 

 
 */