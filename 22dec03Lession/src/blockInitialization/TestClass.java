package blockInitialization;

class TestClass {
	public static String classVariable = "Class variable";
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
}
