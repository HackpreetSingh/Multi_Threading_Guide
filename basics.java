package Threads;

public class basics {

	public static void main(String[] args) {
		System.out.println("Main thread___"+Thread.currentThread().getName()+"___"+Thread.currentThread().getId());
		Thread motu=new Thread("Khuji");
		Thread chotu=new Thread("Suar");
		System.out.println("Motu thread___"+motu.getName()+"___"+motu.getId());
		System.out.println("Chotu thread___"+chotu.getName()+"___"+chotu.getId());
		/*
		 * Daemon thread is a low priority thread that runs in background to perform tasks such as garbage collection.
		 * */
		System.out.println(motu.isDaemon());
		/*
		 * ways of creating thread :
		 * Thread Class
		 * Runnable interface
		 * Callable interface
		 * Executor serice/Framework
		 * In Java, we can just start and pause the thread. We can neither suspend nor stop/terminate any thread. This function lies in the hands of O.S.
		 * If multiple threads are started all at once, even that we cannot tell that which thread will start first and which later. This could be told by JVM. We can just set priority of the threads.
		 * Priority is from 1-10 where;
		 * 1- lowest
		 * 10-highest
		 * 5-moderate(default)
		*/
		
		
		
		
		
		/* LifeCycle Of a Thread
		 * 1. New
		 * 2. Runnable
		 * 3. Waiting/Sleep
		 * 4. Blocked
		 * 5. Terminated
		 */
		motu.start();
		chotu.start();
		motu.setPriority(10);
		System.out.println("priority of motu is : "+motu.getPriority()+"___priority of chotu is : "+chotu.getPriority());

		//chotu.setDaemon(true);    throws error as We cannot set thread as daemon after starting it.
		Thread bona=new Thread("bona");
		bona.setDaemon(true); //works fine because not started yet
		System.out.println(bona.isDaemon()+" is daemon thread(has low priority) so it has priority : "+bona.getPriority());
	}

}
