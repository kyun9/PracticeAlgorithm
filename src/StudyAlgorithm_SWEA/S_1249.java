package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_1249 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			int size = Integer.valueOf(br.readLine());
			int[][] maps = new int[size][size];
			int[][] distance = new int[size][size];

			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split("");
				Arrays.fill(distance[i], Integer.MAX_VALUE);
				for (int j = 0; j < line.length; j++) {
					maps[i][j] = Integer.valueOf(line[j]);
				}
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);
				}
			});

			pq.offer(new int[] { 0, 0, 0 });
			distance[0][0]=0;
			while (!pq.isEmpty()) {
				int[] temp = pq.poll();

				for (int i = 0; i < 4; i++) {
					int x = temp[0] + dx[i];
					int y = temp[1] + dy[i];

					if (x >= 0 && x < size && y >= 0 && y < size) {
						int weight = temp[2] + maps[x][y];
						if (distance[x][y] > weight) {
							distance[x][y] = weight;
							pq.offer(new int[] { x, y, distance[x][y] });
						}
					}
				}
			}
			System.out.println("#" + t + " " + distance[size - 1][size - 1]);
		}
	}

}
