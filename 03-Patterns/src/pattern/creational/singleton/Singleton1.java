package pattern.creational.singleton;

// Synchronization reduces the performance with frequent calls 
public class Singleton1 {
	
	private static Singleton1 instance1;
	
	private Singleton1() {
	}
	
	public synchronized Singleton1 getSingleton(){
		if(instance1 == null) instance1 = new Singleton1();
		return instance1;
	}
}
