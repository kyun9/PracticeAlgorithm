package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준__아기상어_16236 {

	public static int N, numOfEat = 0, sharkRow, sharkCol, sharkSize = 2;
	public static int[][] map;
	public static int[] dirX = new int[] { 0, 0, -1, 1 };
	public static int[] dirY = new int[] { -1, 1, 0, 0 };
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		priorityQueue = new PriorityQueue<Node>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
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

	public static void searchFish() {

		Queue<Node> q = new LinkedList<Node>();
		boolean[][] visited = new boolean[N][N];
		int dist = Integer.MAX_VALUE;

		q.offer(new Node(sharkRow, sharkCol, 0));
		visited[sharkRow][sharkCol] = true;

		while (!q.isEmpty()) {

			Node node = q.poll();
			int row = node.row;
			int col = node.col;
			int cnt = node.cnt;

			for (int i = 0; i < 4; i++) {

				int nr = row + dirX[i];
				int nc = col + dirY[i];

				if (isBoundary(nr, nc) && !visited[nr][nc] && cnt < dist && map[nr][nc] <= sharkSize) {

					if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {

						dist = Math.min(dist, cnt + 1);
						priorityQueue.offer(new Node(nr, nc, cnt + 1));
						visited[nr][nc] = true;

					} else if (map[nr][nc] == 0 || map[nr][nc] == sharkSize) {

						q.offer(new Node(nr, nc, cnt + 1));
						visited[nr][nc] = true;
					}
				}
			}
		}

	}

	public static int solve() {

		int time = 0;

		while (true) {

			searchFish();
			if (priorityQueue.isEmpty())
				return time;

			Node fish = priorityQueue.poll();
			time += fish.cnt;
			map[sharkRow][sharkCol] = 0;
			sharkRow = fish.row;
			sharkCol = fish.col;
			numOfEat += 1;

			if (numOfEat == sharkSize) {
				sharkSize += 1;
				numOfEat = 0;
			}

			priorityQueue.clear();

		}
	}

	public static boolean isBoundary(int row, int col) {
		return (row >= 0 && row < N) && (col >= 0 && col < N);
	}
}

class Node implements Comparable<Node> {
	int row;
	int col;
	int cnt;

	public Node(int row, int col, int cnt) {
		super();
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Node o) {

		if (this.row > o.row)
			return 1;
		else if (this.row == o.row) {
			if (this.col > o.col)
				return 1;
			else
				return -1;
		} else {
			return -1;
		}
	}

}