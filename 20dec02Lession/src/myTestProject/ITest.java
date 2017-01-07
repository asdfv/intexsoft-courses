package myTestProject;

interface ITest {
	
	static void read() {
		System.out.println("Static method");
	}
	
	default void defaultMethod(){
		System.out.println("Default method!");
	}
}
