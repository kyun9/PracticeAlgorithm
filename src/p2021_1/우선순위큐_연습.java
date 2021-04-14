package p2021_1;

import java.util.Collections;
import java.util.PriorityQueue; //import

public class 우선순위큐_연습 {

	public static void main(String[] args) {
		int[] arr = { 5, -1, 2, 4, 3 };
		// int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
		PriorityQueue<Integer> qu1 = new PriorityQueue<>();

		for (int i : arr) {
			System.out.print(i + " ");
			qu1.add(i);
		} // 5 -1 2 4 3
		System.out.println();
		while (!qu1.isEmpty()) {
			System.out.print(qu1.poll() + " ");
		} // -1 2 3 4 5
		System.out.println();

		// int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
		PriorityQueue<Integer> qu2 = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : arr) {
			System.out.print(i + " ");
			qu2.add(i);
		} // 5 -1 2 4 3
		System.out.println();
		while (!qu2.isEmpty()) {
			System.out.print(qu2.poll() + " ");
		} // 5 4 3 2 -1

		// String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
		PriorityQueue<String> qu3 = new PriorityQueue<>();

		// String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
		PriorityQueue<String> qu4 = new PriorityQueue<>(Collections.reverseOrder());

	}

}
