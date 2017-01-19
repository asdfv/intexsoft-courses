package pattern.creational.singleton;

// Lazy init, but problem catching exception in constructor still persists 
public class Singleton3 {
	
	private Singleton3(){
	}
	
	private static class InnerClass {
		private static final Singleton3 instance3 = new Singleton3();
	}
	
	public static Singleton3 getInstance() {
		return InnerClass.instance3;
	}
}
