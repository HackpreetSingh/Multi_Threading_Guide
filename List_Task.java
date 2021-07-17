package Threads;

import java.util.*;

class User01 {
	int id;
	String name;

	User01(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User01 [id=" + id + ", name=" + name + "]";
	}

}

class Data {
	Map<User01, List<User01>> m = new LinkedHashMap<User01, List<User01>>();
	Map<User01, User01> res = new LinkedHashMap<User01, User01>();

	User01 u = new User01(1, "User1");
	User01 p1 = new User01(1, "Pro1");
	User01 p2 = new User01(2, "Pro2");
	User01 p3 = new User01(3, "Pro3");
	List<User01> pro = new ArrayList<User01>();

	Data() {
		pro.add(p1);
		pro.add(p2);
		pro.add(p3);

		m.put(u, pro);
	}

	@Override
	public String toString() {
		return "Data [toString()=" + super.toString() + "]";
	}

}

class multi_threading extends Thread{
	Data d;
	public multi_threading(Data d) {
		this.d=d;
	}
	
	@Override
	public void run() {
		while(!d.m.isEmpty()) {
			try{
				process();
			}
			catch(Exception  e)
			{
				e.printStackTrace();
			}
		}
	}
	
	void process()throws InterruptedException{
		synchronized (d.m) {
	
			Thread.sleep(0);
			List<User01> x=new ArrayList<User01>(d.m.keySet());
			List<User01> y=d.m.get(x.get(0));
			System.out.println(x);
			if(y!=null) {
				d.res.put(d.u, y.get(0));
				y.remove(0);
				d.m.remove(d.u);
				d.m.wait();
				d.m.put(d.u, y);
				System.out.println(d.res);
			}
			else {
				d.m.remove(d.u);
			}
			
			d.m.notifyAll();
		} 
	}
	
	
}

public class List_Task {

	public static void main(String[] args) {
		Data d=new Data();
		multi_threading u1 = new multi_threading(d);
		multi_threading u2 = new multi_threading(d);
		
		u1.start();
		u2.start();
		
	}

}
