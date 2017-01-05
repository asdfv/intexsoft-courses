package arraytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsTest {
	public static void main(String[] args) {
		System.out.println("ArrayList");
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2, 99);
		Integer[] intArray = {11, 12, 13};
		Collections.addAll(list, intArray);
		System.out.println("\nAfter initialization: " + list);
		System.out.println("Size: " + list.size());
		System.out.println("List contains nuber 13? - " + list.contains(13));
		System.out.println("Third element is - " + list.get(2));
		System.out.println("Index of first element '2' is " + list.indexOf(2));
		System.out.println("Index of non-existent element '22' is " + list.indexOf(22));
		list.remove(2);
		System.out.println("After remove 3th element: " + list);
		list.clear();
		System.out.println("After clear: " + list);
		
		//HashMap
		System.out.println("\n\nHashMap");
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("\nIs map empty? - " + map.isEmpty());
		System.out.println("Putting in the map...");
		map.put(0, "Null");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(1, "One");
		System.out.println("Is map empty? - " + map.isEmpty());
		System.out.println("\nMap elements:");
		for(Map.Entry entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println("\nRemoving element with key = 2...");
		map.remove(2);
		for(Map.Entry entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println("\nCleaning map...");
		map.clear();
		System.out.println("Is map empty? - " + map.isEmpty());
		
		//HashSet
		System.out.println("\n\nHashSet");
		Set<Integer> set = new HashSet<Integer>();
		System.out.println("\nIs set empty? - " + set.isEmpty());
		System.out.println("Add elements in the set...");
		set.add(0);
		set.add(2);
		set.add(3);
		set.add(1);
		System.out.println("Is set empty? - " + set.isEmpty());
		System.out.println("\nSet elements:");
		for(int entry : set) {
			System.out.println(entry);
		}
		System.out.println("\nRemoving element with key = 2...");
		set.remove(2);
		for(int entry : set) {
			System.out.println(entry);
		}
		System.out.println("\nCleaning set...");
		set.clear();
		System.out.println("Is set empty? - " + set.isEmpty());
	}
}
