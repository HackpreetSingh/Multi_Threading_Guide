package Threads;

import java.util.*;
import java.util.stream.Collectors;


class User1 implements Runnable{

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
public class Task1 {

	public static void main(String[] args) {
		User1 u=new User1();
		Thread t1=new Thread(u);
		Thread t2=new Thread(u);
		
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unused")
		List<Integer> la=new ArrayList<>();
		la=Collections.emptyList();
		la=u.getIntegers().stream().filter(i-> Collections.frequency(u.getIntegers(), i) == 1).collect(Collectors.toList());
	}

}
