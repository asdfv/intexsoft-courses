package inheritance;

public class Grandson extends Children {
	
	public Grandson() {
		System.out.println("Grandson constructor");
	}

	@Override
	public void programming() {
		System.out.println("I'm too small, i can't coding anything... =(");
		System.out.println("But i can call my father(Children), he can coding: ");
		super.programming();
	}
}
