
public class ExceptionInStatic {
	
	static {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Catched");
		} finally {
			System.out.println("finnaly");
		}
	}

	public static void main(String[] args) {
		System.out.println("main");
	}

}
