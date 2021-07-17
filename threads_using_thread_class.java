package Threads;

class thread_example1 extends Thread{
	public void run() {
		for(int i=1;i<=4;i+=1)
			System.out.println(Thread.currentThread().getName()+"----"+i);
	}
}
public class threads_using_thread_class {

	public static void main(String[] args) {

		thread_example1 t1=new thread_example1();
		thread_example1 t2=new thread_example1();
		t1.setName("first");
		t1.setPriority(1);
		t1.start();
		t2.setName("second");
		t2.start();
		System.out.println(t1.hashCode());
		System.out.println(t1.toString());
	}

}
