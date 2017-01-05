package december;

// Hit in to area
public class Task1 {
	static boolean hitCircle(float x, float y) {
		return (x * x <= 1) && (y * y <= 1);
	}

	static void isHit(float x, float y) {
		if (hitCircle(x, y) && (y <= x * x) && (y >= 0)) {
			System.out.println("Penetration!");
		} else {
			System.out.println("You lose!");
		}
	}

	public static void main(String[] args) {
		isHit(0.2f, 0.8f);
	}
}
