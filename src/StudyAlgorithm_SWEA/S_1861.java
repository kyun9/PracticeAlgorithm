package StudyAlgorithm_SWEA;

import java.util.Scanner;

class Point {
	int val;
	int distance;

	Point(int val, int distance) {
		this.val = val;
		this.distance = distance;
	}
}

public class S_1861 {
	static int N, T, result;
	static int[][] map;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			Point p = new Point(0, 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					result = 1;
					dfs(i, j);
					if (p.distance < result) {
						p.val = map[i][j];
						p.distance = result;
					} else if (p.distance == result) {
						if (p.val > map[i][j]) {
							p.val = map[i][j];
						}
					}
				}
			}
			System.out.println("#" + test + " " + p.val + " " + p.distance);
		}
		sc.close();
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < N && 0 <= py && py < N) {
				if (!visited[px][py] && map[px][py] - map[x][y] == 1) {
					result++;
					dfs(px, py);
					return;
				}
			}
		}
	}
}
