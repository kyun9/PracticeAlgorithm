package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_1208 {
	static int[] arr = new int[100];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			int count = Integer.parseInt(br.readLine().trim());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}

			while (count-- > 0) {
				int max = pq.poll();
				max -= 1;
				while (pq.size() != 1) {
					tmp.add(pq.poll());
				}
				int min = pq.poll();
				min += 1;
				pq.addAll(tmp);
				pq.add(max);
				pq.add(min);
				tmp.clear();
			}

			int max = pq.poll();
			while (pq.size() != 1) {
				tmp.add(pq.poll());
			}
			int min = pq.poll();

			int result = max - min;
			System.out.println("#" + test + " "+result);
		}
	}

}
