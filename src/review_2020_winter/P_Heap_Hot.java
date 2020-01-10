package review_2020_winter;

import java.util.PriorityQueue;

public class P_Heap_Hot {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}

	static int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		int cnt = 0;
		for (int i : scoville) {
			heap.offer(i);
		}
		while (heap.peek() <= K) {
			if(heap.size()==1) {
				return -1;
			}
			int first = heap.poll();
			int second = heap.poll();

			heap.offer(first + 2 * second);
			cnt++;
		}

		answer = cnt;
		return answer;
	}
}
