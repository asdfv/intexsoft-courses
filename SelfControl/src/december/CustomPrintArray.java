package december;

// Print matrix with tab
public class CustomPrintArray {
	public static void printArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) 
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
}
