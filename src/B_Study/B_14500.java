package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair111 {
	int x;
	int y;
	int val;

	Pair111(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

public class B_14500 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = Integer.MIN_VALUE;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1,map[i][j]);
				checkSpecialBlock(i, j);
				visited[i][j]=false;
			}
		}

		System.out.println(result);

	}

	static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			result = Math.max(result, sum);
			return;
		}
		for (int j = 0; j < 4; j++) {
			int px = x + dx[j];
			int py = y + dy[j];
			if (0 <= px && px < N && 0 <= py && py < M) {
				if (!visited[px][py]) {
					visited[px][py] = true;
					dfs(px, py, depth + 1,sum+map[px][py]);
					visited[px][py] = false;
				}
			}
		}
	}

	static void checkSpecialBlock(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int sum = map[x][y];
			boolean check = true;
			
			for (int j = 0; j < 3; j++) {
				int px = x + dx[(i + j) % 4];
				int py = y + dy[(i + j) % 4];

				if (0 <= px && px < N && 0 <= py && py < M) {
					sum += map[px][py];
				} else {
					check = false;
					break;
				}
			}
			if (check) {
				result = Math.max(result, sum);
			}
		}
	}
}
