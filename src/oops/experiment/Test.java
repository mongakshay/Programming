package oops.experiment;

class Test2{
	 
	public Test2() {
		 System.out.println("1");
	}
}

class Test1 extends Test2{
	 public Test1() {
		 System.out.println("2");
	}
}
public class Test extends Test1{

	public Test(int x) {
		super();
		System.out.println("3");
	}
	 
	public static void main(String[] args) {
		Test t = new Test(2);
	}

}
