package december;

// Pyramidal 2D array
public class Task2 {
	static final int N = 9;

	public static void main(String[] args) {
		int[][] matrix = new int[N][N];
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				for (int count = 1; count <= N; count++) {
					if ((i == count - 1 || j == count - 1) || (i == N - count || j == N - count)) {
						matrix[i][j] = N + 1 - count;
					}
				}
			}
		}
		CustomPrintArray.printArray(matrix);
	}
}
