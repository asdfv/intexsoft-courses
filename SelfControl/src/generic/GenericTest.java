package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>(10);
		ListService.fill(list, "Java", 5);
		System.out.println(list.toString());
	}
}
