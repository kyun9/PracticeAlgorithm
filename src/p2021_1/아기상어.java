package p2021_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static class Node2 implements Comparable<Node2> {
		int row;
		int col;
		int cnt;

		Node2(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node2 o) {
			if (this.row > o.row) {
				return 1;
			} else if (this.row == o.row) {
				if (this.col > o.col)
					return 1;
				else
					return -1;
			} else {
				return -1;
			}
		}

	}

	public static int N, numOfEat = 0, sharkRow, sharkCol, sharkSize = 2;
	public static int[][] map;
	public static int[] dirX = { 0, 0, -1, 1 };
	public static int[] dirY = { -1, 1, 0, 0 };
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static PriorityQueue<Node2> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine().trim());
		pq = new PriorityQueue<Node2>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkRow = i;
					sharkCol = j;
				}
			}
		}

		System.out.println(solve());
	}

	public static int solve() {
		int time = 0;

		while (true) {
			searchFish();
			if (pq.isEmpty()) {
				return time;
			}

			Node2 fish = pq.poll();
			time += fish.cnt;
			map[sharkRow][sharkCol] = 0;
			sharkRow = fish.row;
			sharkRow = fish.col;
			numOfEat += 1;

			if (numOfEat == sharkSize) {
				sharkSize += 1;
				numOfEat = 0;
			}

			pq.clear();

		}
	}

	public static void searchFish() {
		Queue<Node2> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int dist = Integer.MAX_VALUE;

		q.offer(new Node2(sharkRow, sharkCol, 0));
		visited[sharkRow][sharkCol] = true;

		while (!q.isEmpty()) {
			Node2 node = q.poll();
			int row = node.row;
			int col = node.col;
			int cnt = node.cnt;

			for (int i = 0; i < 4; i++) {
				int nr = row + dirX[i];
				int nc = col + dirY[i];

				if (isBoundary(nr, nc) && !visited[nr][nc] && cnt < dist && map[nr][nc] <= sharkSize) {
					if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
						dist = Math.min(dist, cnt + 1);
						pq.offer(new Node2(nr, nc, cnt + 1));
						visited[nr][nc] = true;
					} else if (map[nr][nc] == 0 && map[nr][nc] == sharkSize) {
						q.offer(new Node2(nr, nc, cnt + 1));
						visited[nr][nc] = true;
					}
				}

			}
		}
	}

	public static boolean isBoundary(int row, int col) {
		return (row >= 0 && row < N) && (col >= 0 && col < N);
	}
}
