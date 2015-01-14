package com.cni.test;
import java.util.Hashtable;

class Mn {

	public static void main(String[] args) {
		// int[] m = new int[8];
		// int[] n = new int[3];
		int[] m = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] n = { 0, 1, 2, 3 };

		Hashtable ht = new Hashtable();
		for (int i = 0; i < m.length; i++) {
			ht.put(i, m[i]);

		}
		for (int i = 0; i < n.length; i++) {
			if(ht.containsValue(n[i])){
				System.out.println(n[i]);
			}
		}
		
	}

}
