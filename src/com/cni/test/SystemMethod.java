package com.cni.test;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemMethod {

	public static void main(String[] args) {
		System.out.println("1秒=1000毫秒 1毫秒=1000微秒 1微秒=1000毫微秒 1毫微秒＝1纳秒 1纳秒=10埃秒");
		System.out.println("返回最准确的可用系统计时器的当前值，以毫微秒为单位 " + System.nanoTime());
		System.out.println("返回以毫秒为单位的当前时间 " + System.currentTimeMillis());
		
		System.out.println("------------");
		Map<String,String> maps = System.getenv();
		Set<Map.Entry<String,String>> sets = maps.entrySet();
		Iterator its = sets.iterator();
		while(its.hasNext()){			
			System.out.println(its.next().toString());
		}
		System.out.println("------------");
		Properties ps = System.getProperties();	
		
		Enumeration en = ps.propertyNames();
		
		while(en.hasMoreElements()){
			System.out.println(en.nextElement()+" : "+ps.getProperty(en.nextElement().toString()));
		}
		
		
		
		
	}

}
