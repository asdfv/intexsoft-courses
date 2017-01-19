package pattern.creational.singleton;

// No lazy initialization, no catching exceptions in constructor
class Singleton2 {
	
	private static Singleton2 instance2 = new Singleton2();
	
	private Singleton2() {
	}
	
	public static Singleton2 getSingleton2(){
		return instance2;
	}
}
