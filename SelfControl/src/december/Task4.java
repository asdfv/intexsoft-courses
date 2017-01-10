package december;

// Spiral snake
public class Task4 {

	static final int N = 9;

	public static void main(String[] args) {
		
		int[][] matrix = new int[N][N];
		int count = 1;
		int step = N - 1;
		int turn = 0;

		while (turn < N / 2) {
			for (int j = turn; j < step + turn; j++) {
				matrix[turn][j] = count++;
			}
			for (int i = turn; i < step + turn; i++) {
				matrix[i][N - 1 - turn] = count++;
			}
			for (int j = N - 1 - turn; j > turn; j--) {
				matrix[N - 1 - turn][j] = count++;
			}
			for (int i = N - 1 - turn; i > turn; i--) {
				matrix[i][turn] = count++;
			}
			++turn;
			step = step - 2;
		}
		if (0 != N % 2)
			matrix[(N - 1) / 2][(N - 1) / 2] = N * N;
		
		CustomPrintArray.printArray(matrix);
	}
}
