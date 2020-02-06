package P_Study;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_Heap_doublePriorityQueue {

	public static void main(String[] args) {
		String[] operations = { "I 16", "D 1" };
		String[] operations2 = { "I 7", "I 5", "I -5", "D -1" };
		String[] operations3 = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		String[] operations4 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		System.out.println(solution(operations3));
	}

	static int[] solution(String[] operations) {
		int[] answer = {};

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> tmp = new PriorityQueue<>();

		StringTokenizer st;
		for (int i = 0; i < operations.length; i++) {
			st = new StringTokenizer(operations[i]);
			String s = st.nextToken();
			if (s.equals("I")) {
				pq.offer(Integer.parseInt(st.nextToken()));
			} else if (s.equals("D")) {
				if (!pq.isEmpty()) {
					String s1 = st.nextToken();
					if (s1.equals("-1")) {
						pq.poll();
					} else {
						while (pq.size() != 1) {
							tmp.offer(pq.poll());
						}
						pq.poll();
						pq.addAll(tmp);
						tmp.clear();
					}
				}
			}
		}

		int max = 0, min = 0;
		if (!pq.isEmpty()) {
			while (pq.size() != 1) {
				tmp.offer(pq.poll());
			}
			max = pq.poll();
			pq.addAll(tmp);
			min = pq.poll();
		} else {
			max = 0;
			min = 0;
		}

		answer = new int[2];
		answer[0] = max;
		answer[1] = min;

		return answer;
	}
}
