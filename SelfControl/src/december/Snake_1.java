package december;

public class Snake_1 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		int n = 10;
		int[][] matrix = new int[n][n];

		int row = 0;
		int col = 0;
		int dx = 1;
		int dy = 0;
		int dirChanges = 0;
		int visits = n;

		for (int i = 0; i < n * n; i++) {
			matrix[row][col] = i + 1;
			if (--visits == 0) {
				visits = n * (dirChanges % 2) + n * ((dirChanges + 1) % 2) - (dirChanges / 2 - 1) - 2;
				int temp = dx;
				dx = -dy;
				dy = temp;
				dirChanges++;
			}
			col += dx;
			row += dy;
		}
		long end = System.currentTimeMillis();

		CustomPrintArray.printArray(matrix);
		System.out.println("Exe-time without printing - " + (end - start) + " ms");
	}
}
