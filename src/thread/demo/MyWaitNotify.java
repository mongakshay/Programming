package thread.demo;

//class MonitorObject{}

public class MyWaitNotify {

	Object mutex = new Object();
	Object mutex2 = new Object();
	boolean wasSignalled = false;

	public void doWait() {
		synchronized (mutex) {
			if (!wasSignalled) {
				try {
					System.out.println(Thread.currentThread().getName() + " is Waiting...");
					mutex.wait();
				} catch (InterruptedException e) {
					System.out.println("ERROR");
				}
			}
			// clear signal and continue running.
			System.out.println(Thread.currentThread().getName() + " has Got signal....");
			wasSignalled = false;
		}
	}
	
	public void doNotify() {
		synchronized (mutex) {
			System.out.println(Thread.currentThread().getName() + " is Signalling...");
			wasSignalled = true;
			mutex.notify();
		}
	}

	public static void main(String[] args) {
		MyWaitNotify o1 = new MyWaitNotify();
		MyWaitNotify o2 = new MyWaitNotify();
		new Thread() {
			@Override
			public void run() {
				o2.doWait();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				o2.doNotify();
			}
		}.start();
	}
}