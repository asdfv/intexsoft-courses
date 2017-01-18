package inheritance;

public class ClassForTestInheritance {
	
	public static void main(String[] args) {
		
		System.out.println("Start programm");

		System.out.println("\nCreating Parent instance");
		Parent father = new Parent();
		
		System.out.println("\nCreating child instance");
		Children child = new Children();
		
		System.out.println("\nCreating grandson instance");
		Children grandson = new Grandson();
		
		System.out.println("\nCall parent method: ");
		father.programming();
		
		System.out.println("\nCall child method: ");
		child.programming();
		
		System.out.println("\nCall grandson method: ");
		grandson.programming();
	}
}
