package thread.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class TestThread extends Thread{

	
	TwoSums o1;// = new  TwoSums();
	TwoSums o2;// = new  TwoSums();
	
	public TestThread(TwoSums o1, TwoSums o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	@Override
	public void run() {
		this.o1.add(12, 13);
		this.o2.add(2, 3);
	}
}

public class TwoSums {
    private int sum1 = 0;
    private int sum2 = 0;
    
    public void add(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;  
            System.out.println(Thread.currentThread().getName() +" --> "+ this.sum1);
        }
        
        synchronized(this){
            this.sum2 += val2;
            System.out.println(Thread.currentThread().getName() +" --> "+ this.sum2);
        }
    }
    
	public static void main(String[] args) {

		TwoSums o = new TwoSums();
		TwoSums o1 = new TwoSums();
		TwoSums o2 = new TwoSums();
		//(new TestThread(o,o)).start();
		//(new TestThread(o,o)).start();
		
		Counter c = new Counter();
		Counter c1 = new Counter();
		(new MyThread(c)).start();
		(new MyThread(c)).start();
		(new MyThread(c1)).start();
		(new MyThread(c)).start();
		(new MyThread(c)).start();
	}
}

class Counter{
	int count = 0 ;
	
	public void increment() {
	synchronized (this) {
		System.out.println(	Thread.currentThread().getName() +" : "+ count++);
		}
	}
	
}

class MyThread extends Thread{
	
	private Counter cObject = null;
	
	public MyThread(Counter c) {
		this.cObject = c;
	}
	
	@Override
	public void run() {
		this.cObject.increment();
	}
	
	
}