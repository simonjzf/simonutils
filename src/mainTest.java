import java.util.Calendar;


public class mainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("java.home"));
	}

	/*public static String nowServerTime()
	{
		Calendar calendar = Calendar.getInstance();
		String s = String.valueOf(calendar.get(1));			//output = 2013
		String s1 = String.valueOf(calendar.get(2) + 1); 	//output = 07
		String s2 = String.valueOf(calendar.get(5) + 1);	//output = 16
		String s3 = String.valueOf(calendar.get(10));		//output = 1
		String s4 = String.valueOf(calendar.get(12));		//output = 24
		String s5 = String.valueOf(calendar.get(13));		//output = 53
		s1 = Integer.parseInt(s1) <= 9 ? "0" + s1 : s1;	
		s2 = Integer.parseInt(s2) <= 9 ? "0" + s2 : s2;
		String s6 = String.valueOf((int) (Math.random() * 100000D));	
		String s7 = "_" + s6 + "_" + s + s1 + s2 + s3 + s4 + s5;		
		return s7;
	}*/

}
