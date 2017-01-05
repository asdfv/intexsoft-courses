package operatorstest;

public class OperatorSequence {

	public static void main(String[] args) {
		
		int[] array = {0, 1, 2, 3};
		
		printArray(array);
		
		int i = 0;
		System.out.println("i = " + i + "\n");
		
		array[i++] = array[i++]++ + ++array[++i];
		
		printArray(array);
		System.out.println("i = " + i);
	}
	
	private static void printArray(int[] arr) {
		for(int value : arr) {
			System.out.println(value);
		}
	}
}
