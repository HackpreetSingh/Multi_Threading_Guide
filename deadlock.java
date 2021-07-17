package Threads;

import java.util.*;

class series extends Thread {
	List<Integer> c;

	series(List<Integer> c) {
		this.c = c;
	}

	@Override
	public void run() {
		int i = 1;
		while (i <= 10) {
			try {
				seriesfunc(i++);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void seriesfunc(int i) throws InterruptedException {
		synchronized (c) {
			Thread.sleep(100);
			c.add(c.get(i - 1) + c.get(i));
			System.out.println(c.get(i - 1) + " + " + c.get(i) + " = " + c.get(i + 1));
			c.notify();
		}
	}
}

class Sum extends Thread {
	List<Integer> c;
	int sum = 0;
	int x = 0,a=0;

	Sum(List<Integer> c) {
		this.c = c;
	}

	@Override
	public void run() {
		int i = 1;
		while (i <= 10) {
			try {
				summer(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (i > 10)
			System.out.println("Sum is : " + sum);
	}

	public void summer(int i) throws InterruptedException {
		synchronized (c) {
			while (a <= x) {
				Thread.sleep(100);
				sum += c.get(x);
				if(x<=10) x++;
				a++;
				c.notifyAll();
			}
		}
	}
}

class deadlock {
	public static void main(String[] args) {

		List<Integer> c = new ArrayList<Integer>();
		c.add(0);
		c.add(1);

		series s = new series(c);
		Sum s1 = new Sum(c);
		s.start();
		s1.start();

	}
}