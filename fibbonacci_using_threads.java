package Threads;

import java.util.*;

class storage {
	static List<Integer> a = new ArrayList<Integer>();
	static List<Integer> b = new ArrayList<Integer>();
	static List<Integer> c = new ArrayList<Integer>();

	@SuppressWarnings("removal")
	public static void init() {
		a.add(new Integer(0));
		b.add(new Integer(1));
//		c.add(new Integer(1));

	}

	static int sum = 0, i = 0;

}

class num extends Thread {

	public void run() {
		while (storage.i <= 10) {

			storage.c.add(storage.a.get(storage.i) + storage.b.get(storage.i));
			storage.a.add(storage.b.get(storage.i));
			storage.b.add(storage.c.get(storage.i));
			System.out.println(
					storage.a.get(storage.i) + " + " + storage.b.get(storage.i) + " = " + storage.c.get(storage.i));
			storage.i++;
		}
	}

}

class sums extends Thread {
	
	public void run() {
			storage.sum += storage.c.get(storage.i);
	}
}

public class fibbonacci_using_threads {

	public static void main(String[] args) {
		storage.init();
		num n = new num();

		sums m = new sums();

		n.start();
		synchronized (m) {
			try {
				m.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		n.notify();
		m.start();
		System.out.println("Sum is : " + storage.sum);
	}

}
