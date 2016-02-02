package thread.demo;

import java.util.*;
import java.util.Map.Entry;

public class BankTransactionDemo{
	
	HashMap<String, Long> bank;
	
	public BankTransactionDemo(List<String> users) {
		bank = new HashMap<String, Long>();
		for(String user: users){
			bank.put(user,(long) 0);
		}
	}
	
	public void deposit(String user, long amt){
		if(!bank.containsKey(user))
			System.out.println("User does not exist");
		else{
			synchronized (this) {
				long balance = bank.get(user);
				long amtLeft = balance + amt;
				bank.put(user, amtLeft);
				System.out.println( user +" Desposit sucesssful....");
				}
			}
		}
	
	public void withdraw(String user, long amt){
		if(!bank.containsKey(user))
			System.out.println("User does not exist");
		else{
			synchronized (this) {
				long balance = bank.get(user);
				long amtLeft = balance - amt;
				if(amtLeft < 0)
					System.out.println( user +" Insufficient balance....");
				else{
					bank.put(user, amtLeft);
					System.out.println( user +" Withdrawal sucesssful....");
				}
			}
		}
	}

	public void display() {
		for(Entry<String, Long> b : bank.entrySet()){
			System.out.println(b.getKey() + " has " + b.getValue() + " money in his account...");
		}
	}

	public static void main(String[] args) {
		
		List<String> users = new ArrayList<String>();
		users.add("akshay");
		users.add("anish");
		users.add("ankeeta");
		
		BankTransactionDemo  b = new BankTransactionDemo(users);
		
		Thread t1 = new Thread(){
			
			@Override
			public void run() {
				b.deposit("akshay", 100);
				b.deposit("akshay", 100);
				b.deposit("anish", 100);
				b.deposit("ankeeta", 100);
				b.deposit("ankeeta", 100);
				b.deposit("ankeeta", 100);
			}
		};
		

		Thread t2 = new Thread(){
			
			@Override
			public void run() {
				b.withdraw("anish",40);
				b.withdraw("akshay",40);
			}
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.display();
	}

}
