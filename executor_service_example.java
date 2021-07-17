package Threads;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class threadpool implements Runnable{

	public void process()throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" ---- "+i);
//		Thread.sleep(1000);
		
		}
	}
	@Override
	public void run() {
     try {
		process();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}
	
}
class Callable_example implements Callable<String>{
	StringBuilder nm=new StringBuilder();

	
	@Override
	public String call() throws Exception {
		for(int i=0;i<=10;i++) {
			nm.append(i);
			nm.append("_");
		}
			return nm.toString();
	}
	
	
}
public class executor_service_example {

	public static void main(String[] args) {
		
		threadpool t=new threadpool();
		ExecutorService ser=Executors.newFixedThreadPool(2);
		ser.execute(t);
		ser.execute(t);
//		ser.shutdown();
		
//		ser.execute(t);//causing exception because ser has been shut down
		
		Callable_example c=new Callable_example();
		Future<String> string=ser.submit(c);
		
		try {
			if(string.isDone()) System.out.println("Future from Call Service"+string.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Future<String> nm=ser.submit(c);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		nm.cancel(true);
		try {
			if(nm.isCancelled())
			{
				System.out.println("Future step not reached!!\n Status is : ");
		}else if(nm.isDone()) System.out.println("Future step reached!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ser.shutdown();
				
	}

}
