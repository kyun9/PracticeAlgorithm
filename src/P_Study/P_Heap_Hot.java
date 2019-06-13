package P_Study;

import java.util.PriorityQueue;

public class P_Heap_Hot {

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int k = 7;

		System.out.println(solution(scoville, k));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int val : scoville)
			heap.offer(val);

		int first = 0, second = 0;
		int cnt = 0;

		while (heap.peek() <= K) {
			if (heap.size() == 1) {
                return -1;
            }
			first = heap.poll();
			second = heap.poll();

			heap.offer(first + second * 2);
			cnt++;
		}

		answer = cnt;

		return answer;
	}
}
