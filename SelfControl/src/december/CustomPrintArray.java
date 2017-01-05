package december;

// Fat method to perfect slow print
public class CustomPrintArray {
	public static void printArray(int[][] matrix, int dimension) {
		int maxDigitInNumber = (int) (Math.log10(dimension*dimension) + 1);
		for (int[] xSrting : matrix) {
			for(int i : xSrting){
				int currentDigitInNumber = (int) (Math.log10(i) + 1);
				int numberOfSpaces = maxDigitInNumber - currentDigitInNumber + 1;
				String spaces = String.format("%" + numberOfSpaces + "s", "");
				System.out.print(i + spaces);
			}
			System.out.println();			
		}
	}
//	public static void printArray(int[][] matrix, int dimension) {
//		for (int i = 0; i < dimension; i++) {
//			for (int j = 0; j < dimension; j++) 
//				System.out.print(matrix[i][j] + "\t");
//			System.out.println();
//		}
//	}
}
