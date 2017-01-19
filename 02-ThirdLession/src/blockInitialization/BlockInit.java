package blockInitialization;

// Class for testing sequence initialization
public class BlockInit {
	public static void main(String[] args) {
		System.out.println(TestClass.FINAL_STRING);
		System.out.println("Call staic value without creating instance: " + TestClass.classVariable);
		System.out.println("Call staic method without creating instance: " + TestClass.staticMethod());
		System.out.println("Creat instanse of class...");
		TestClass test = new TestClass();
		test.staticMethod();
	}
}
