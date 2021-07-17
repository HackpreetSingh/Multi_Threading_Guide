package Threads;

import java.util.*;

class fibb extends Thread {

	List<Integer> l = new ArrayList<Integer>();

	public static int a = 0, b = 1, c = 1,i=0;
	public synchronized void run() {

		while(i<=10) {
			c = a + b;
			System.out.println(a + " + " + b + " = " + c);
			a = b;
			b = c;
			i++;
			l.add(c);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class fibbo {
	public static void main(String[] args) {
		fibb m1 = new fibb();
		fibb m2 = new fibb();
		m1.start();
		m2.start();
	}
}