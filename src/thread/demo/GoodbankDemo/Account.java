package thread.demo.GoodbankDemo;

public class Account {
	public static Account account;
	
	/* Does make a sense to make it volatile because its not happening 
	 * two difference threads reading and writing on same balance 
	 * as its multiple thread on the same object monitor
	 * */
	private volatile static int balance = 1000; 
	private static Person person;

	private Account() {
	}

	public static Account getAccount(Person p) {
		if (account == null) {
			account = new Account();
		}
		Account.person = p;
		return account;
	}

	public static int getBal() {
		return balance;
	}

	public synchronized void withdraw(int bal) {
		try {

			if (balance >= bal) {
				System.out.println(person.getName() + " "
						+ "is try to withdraw");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance = balance - bal;
				System.out.println(person.getName() + " "
						+ "is complete the withdraw");
			} else {
				System.out.println(person.getName() + " "
						+ "doesn't have enough money for withdraw ");
			}
			System.out.println(person.getName() + " " + " withdraw Rs." + bal
					+ ", amt left = " + balance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void deposit(int bal) {
		try {
			if (bal > 0) {
				System.out.println(person.getName() + " "
						+ " is try to deposit");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance = balance + bal;
				System.out.println(person.getName() + " "
						+ "is complete the deposit");
			} else {
				System.out.println(person.getName() + " "
						+ "doesn't have enough money for deposit");
			}
			System.out.println(person.getName() + " deposite Rs." + bal
					+ ", amt left = " + balance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}