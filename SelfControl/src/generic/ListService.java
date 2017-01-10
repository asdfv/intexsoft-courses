package generic;

import java.util.List;

public class ListService {
	
	// Fills in List<T> specified values T and size
	public static <T> void fill(List<T> list, T value, Integer size) {
		for (int index = 0; index < size; index++) {
			list.add(value);
		}
	}
}
