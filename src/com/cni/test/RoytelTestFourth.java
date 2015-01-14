package com.cni.test;

public class RoytelTestFourth {
	
	static class Demo {
		public synchronized void test1() {
			System.out.println("enter into test1 ...");
			while (true) {
				try {
//					Thread.sleep(1000);
					this.wait(1000);
				} catch (Exception e) {
				}
			}
		}
		
		public synchronized void test2() {
			System.out.println("enter into test2 ...");
		}

		public void test3() {
			System.out.println("enter into test3 ...");
		}

		public void test4() {
			synchronized (this) {
				System.out.println("enter into test4 ...");
			}
		}
	}

	static Demo dm = new Demo();

	static class MyThread1 extends Thread {
		public void run() {
			dm.test1();
		}
	}

	static class MyThread2 extends Thread {
		public void run() {
			dm.test2();
		}
	}

	static class MyThread3 extends Thread {
		public void run() {
			dm.test3();
		}
	}

	static class MyThread4 extends Thread {
		public void run() {
			dm.test4();
		}
	}

	public static void main(String[] args) {
		new MyThread1().start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		new MyThread2().start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		new MyThread3().start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		new MyThread4().start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println("end");
	}
}
