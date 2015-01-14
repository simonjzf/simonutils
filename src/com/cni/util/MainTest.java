package com.cni.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class MainTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		String num="PCT201204237wA";
		double tempamout;
		try {
			tempamout = Double.parseDouble(num);
			System.out.println(tempamout);
		} catch (java.lang.NumberFormatException e) {
			System.out.println(num);
		}
		
		System.out.println(String.valueOf(Double.MAX_VALUE)); 
		System.out.println(String.valueOf(Double.MIN_VALUE));
		System.out.println("-----------");
		System.out.println(Integer.MAX_VALUE); 
		System.out.println(Integer.MIN_VALUE);

		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");    
//		System.out.println(sdf.format(new Date()));
//		System.out.println("1,".split(",").length);
	
//		
//		List<String> listTo = new ArrayList<String>();
//		listTo.add("sandjzf@hotmail.com");
//		System.out.println(SendMail.SendMail(listTo, "inin", "ininin"));
//		System.out.println(SendMail.sendMailResetPw("sandjzf@hotmail.com", "cc", "ccc"));
//		System.out.println(SendMail.sendMailChangePw("sandjzf@hotmail.com", "a", "b"));
		
//		System.out.println(StringUtil.getRandomString(8));
//		System.out.println(StringUtil.getRandomString(8));
//		System.out.println(StringUtil.getRandomString(8));
//		System.out.println(StringUtil.getRandomString(8));
//		System.out.println(StringUtil.getOtType(1));
//		System.out.println(StringUtil.getOtType(2));
//		System.out.println(StringUtil.getOtType(3));
//		System.out.println(StringUtil.getOtType(4));
//		System.out.println(StringUtil.getOtType(5));
//		System.out.println(StringUtil.getOtType(6));
//		System.out.println(StringUtil.getOtType(7));
//		System.out.println(StringUtil.getOtType(8));

//		
//		Date d1 = new Date();
//		Date d2 = new Date();
//		long dd1 = d1.getTime();
//		String dd2 = String.valueOf(d2.getTime());
//		int ddd1 = Integer.valueOf(dd1.substring(dd1.length()-9, dd1.length()));
//		int ddd2 = Integer.valueOf(dd2.substring(dd2.length()-9, dd1.length()));
//		System.out.println(dd1);
//		System.out.println(dd2);
//		System.out.println(ddd1);
//		System.out.println(ddd2);
//		System.out.println(dd2-dd1);
		
//
//		System.out.println(StringUtil.getDateFromString(StringUtil.getNextDate(StringUtil.getDateFromString("2009-09-01"))).getTime()/1000/3600/24);
//		System.out.println(StringUtil.getDateFromString("2009-09-02").getTime()/1000/3600/24);
//		System.out.println(StringUtil.getDateFromString("2009-09-03").getTime()/1000/3600/24);
//		System.out.println(StringUtil.getDateFromString("2009-09-04").getTime()/1000/3600/24);
//		System.out.println(StringUtil.getDateFromString("2009-09-05").getTime()/1000/3600/24);
//		System.out.println(StringUtil.getDateFromString("2009-09-19").getTime()/1000/3600/24);
		
		
		
//		System.out.println(StringUtil.getDateStringBetweenDateStringZone("2009-09-01", "2009-10-10"));
		
	/*
		int n=7;
		n<<=3;
		System.out.println(n);
		System.out.println(n&n);
		System.out.println(1|n);
		System.out.println(2^n);
		System.out.println(n&n+1|n);
		System.out.println(n&n+1|n+2^n);
		System.out.println(n&n+1|n+2^n+3);
		n=n&n+1|n+2^n+3;		
		n>>=2;
		System.out.println(n);
		System.out.println(56+57+58+3);
		System.out.println(StringUtil.getRandomStringContainDateInfo(8));
	*/
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Calendar cale = Calendar.getInstance();
//		cale.setTimeInMillis(cale.getTimeInMillis()-24*3600*1000);
//		
//		System.out.println(sdf.format(cale.getTime()));
//		

	}

}
