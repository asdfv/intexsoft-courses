package myTestProject;

import java.util.PriorityQueue;
import java.util.Queue;

class TestAll extends AbsClass {
	public static void main(String[] args) {
		
		Queue<Integer> q = new PriorityQueue<>();
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		System.out.println(q.poll() + "\n");

		for (Integer i : q) {
			System.out.println(i);
		}
	}
}
