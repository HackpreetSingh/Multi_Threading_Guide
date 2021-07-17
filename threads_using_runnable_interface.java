package Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User implements Runnable{

	private List<Integer> Integers=Collections.emptyList();
	@Override
	public void run() {
		Integers=new ArrayList<>();
	for(int i=10;i>0;--i)
	{
		Integers.add(i);
		System.out.println(Thread.currentThread().getName()+"----"+i);
	}

	}
	public List<Integer> getIntegers() {
		return Integers;
	}
	
}
public class threads_using_runnable_interface {

	public static void main(String[] args) {
		User u=new User();
		Thread t1=new Thread(u);
		Thread t2=new Thread(u);
		Thread t3=new Thread(u);
		Thread t4=new Thread(u);
		Thread t5=new Thread(u);
		Thread t6=new Thread(u);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			u.wait(100);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Wait not executed");
		}
		
		u.getIntegers().stream().forEach(i->System.out.println(i));
	}

}
