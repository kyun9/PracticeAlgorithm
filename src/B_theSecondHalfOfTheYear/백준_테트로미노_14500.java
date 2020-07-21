package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_테트로미노_14500 {
	static int N, M, result = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				solve(i, j, map[i][j], 0);
				checkSpecialChar(i, j);
				visited[i][j] = false;
			}
		}

		System.out.println(result);
	}

	static void solve(int x, int y, int sum, int depth) {
		if (depth == 3) {    //3개만 찾으면 된다.
			result = Math.max(result, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < N && 0 <= py && py < M) {
				if (!visited[px][py]) {
					visited[px][py] = true;
					solve(px, py, sum + map[px][py], depth + 1);
					visited[px][py] = false;
				}
			}
		}
	}

	static void checkSpecialChar(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int sum = map[x][y];
			boolean flag = true;
			for (int j = 0; j < 3; j++) {
				int px = x + dx[(i + j) % 4];
				int py = y + dy[(i + j) % 4];

				if (0 <= px && px < N && 0 <= py && py < M) {
					sum += map[px][py];
				} else {
					flag = false;
					break;
				}
			}
			if (flag) {
				result = Math.max(result, sum);
			}
		}

	}
}
