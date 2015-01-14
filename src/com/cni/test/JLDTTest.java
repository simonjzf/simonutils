package com.cni.test;

public class JLDTTest{
	public static void main(String args[]){
		int[] x = new int[25];
		System.out.println(x[0]);//0
		System.out.println(x[24]);//0
		System.out.println(x.length);//25
		System.out.println(x[25]);//ArrayIndexOutOfBoundsException
		
	}
	
	/*
	 * test 4
	public static void main(String args[]){
		int x,a=6,b=7;
		x=a+++b++;
		
		System.out.println(x);//13
		System.out.println(a);//7
		System.out.println(b);//8
	}
	*/
	/*
	 * test 5	 
	public static void main(String args[]){
		StringBuffer s = new StringBuffer("Hello");
		if((s.length()>5)&&(s.append("there").equals("False")))
		//do nothing
		System.out.println("values is "+s);
	}
	*/
	/*
	 //test 6
	void jLDTTest(int i){
		System.out.println("int version ");
	}
	void jLDTTest(String i){
		System.out.println("String version ");
	}
	public static void main(String[] args) {
		JLDTTest crun = new JLDTTest();
		char ch='p';
		crun.jLDTTest(ch);
	}
	
	*/
	/*
	 * test 7	 
	public float aMethod(float a,float b){return 0;}
	public int aMethod(int a,int b){return 0;}
	public float aMethod(float a,float b){reutrn 0;}
	public float aMethod(float a,float b,int c)throws Exception{return 0;}
	public float aMethod(float c,float d){return 0;}
	private float aMethod(int a,int b,int c){return 0;}
	*/
	/*
	// test 8
	public static void main(String args[]){
		String s = "abcde";
//		String s1= new String("abcde");
		StringBuffer s1 = new StringBuffer("abcde");
		
		System.out.println("s.equals(s1):"+s.equals(s1));
		
		if(s.equals(s1)){
			s1=null;
			System.out.println(s);
			System.out.println(s1);
		}
		System.out.println("s1.equals(s):"+s1.equals(s));
		if(s1.equals(s)){
			s=null;
			System.out.println(s);
			System.out.println(s1);
		}	
	}
	*/
	

}
