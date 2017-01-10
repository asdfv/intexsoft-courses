package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
	public static void main(String[] args) {
		
		List<String> listStr = new ArrayList<String>();
		ListService.fill(listStr, "Java", 5);
		System.out.println(listStr.toString());
		
		List<Integer> listInt = new ArrayList<Integer>();
		ListService.fill(listInt, 6969, 5);
		System.out.println(listInt.toString());
	}
}
