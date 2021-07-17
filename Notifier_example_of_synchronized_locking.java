package Threads;

import java.util.*;

class Producer implements Runnable {
	private List<Integer> nums;
	private int capacity;

	Producer(List<Integer> nums, int size) {

		this.nums = nums;
		this.capacity = size;

	}

	@Override
	public void run() {

		int i = 0;
		while (i < 200) {
			try {
				produce(i++);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void produce(int i) throws InterruptedException {
		synchronized (nums) {
			while (nums.size() == capacity)
				{
				System.out.println("List is Full " + Thread.currentThread().getName() + " Size is : " + nums.size());
				nums.wait();
				}
			Thread.sleep(300);
			nums.add(i);
			System.out.println("Produced::" + i);
		nums.notifyAll();
		}
	}

}

class Consumer implements Runnable {

	private List<Integer> nums;

	public Consumer(List<Integer> nums) {
		this.nums = nums;
	}

	void consume() throws InterruptedException {
		synchronized (nums) {
			int i=0;
			while (i<300) {
				System.out.println(
						"list is Empty" + Thread.currentThread().getName() + " is waiting. Size is : " + nums.size());
			nums.wait();
				i++;
				
			}
				Thread.sleep(100);
				int num = nums.remove(0);
				System.out.println("Consumed::"+num);
			nums.notifyAll();
		}
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 300) {
			try {
				consume();
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
	}

}

public class Notifier_example_of_synchronized_locking {

	public static void main(String[] args) {
		List<Integer> integer = new ArrayList<>();
		int size=20;
		Producer producer=new Producer(integer,size);
		Consumer consumer=new Consumer(integer);
		Thread t1=new Thread(producer);
		Thread t2=new Thread(consumer);
		t1.start();
		t2.start();
		

	}

}
