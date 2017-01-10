package myTestProject;

public class TestStaticClassB extends TestStaticClassA {
	
	int i = 2;
	
	static void print() {
		System.out.println("Child staic method");
	}
	
	public static void main(String[] args) {
		TestStaticClassA.print();
		
		TestStaticClassA instanceA = new TestStaticClassB();
		TestStaticClassB instanceB = new TestStaticClassB();
		
		instanceA.print();
		instanceB.print();
		
		System.out.println(instanceA.i);
		System.out.println(instanceB.i);
	}
}
