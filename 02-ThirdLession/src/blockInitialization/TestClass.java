package blockInitialization;

public class TestClass {
	
	public static final String FINAL_STRING = "Private static final String!";
	
	public static String classVariable = "Class variable";

	public TestClass() {
		System.out.println("Constructor");
	}
	
	static {
		String valueInStaticBlock = "Value in static block";
		System.out.println("Static block");
	}
	{
		System.out.println("Simpl block");
	}
	public static String staticMethod() {
		return "Static method";
	}
	
	private static class InnerClass {
		static {
			System.out.println("Static block in inner Class");
		}
	}
}
