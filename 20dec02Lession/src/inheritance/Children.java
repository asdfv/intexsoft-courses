package inheritance;

public class Children extends Parent {
	
	public Children() {
		System.out.println("Child constructor");
	}
	
	@Override
	public void programming() {
		System.out.print("[call super method from child] Parent can - ");
		super.programming();
		
		System.out.print("[call child overridden method] Child can - ");
		System.out.println("Code in Java!");
	}
}
