package december;

// Easy snake
public class Task3 {

	static final byte N = 15;

	public static void main(String[] args) {
		int[][] matrix = new int[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < N; j++) {
					count++;
					matrix[i][j] = count;
				}
			} else {
				for (int j = N - 1; j >= 0; j--) {
					count++;
					matrix[i][j] = count;
				}
			}
		}
		CustomPrintArray.printArray(matrix, N);
	}
}
