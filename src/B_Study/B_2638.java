package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2638 {
	static int N, M, result,cnt;
	static int[][] map, group;
	static boolean[][] visited;
	static boolean[][] check;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

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

		result = 0;
		int size = N * M;
//		System.out.println(0);
		while (true) {
//			System.out.println(1);
			int count = 0;
			cnt=0;
			group = new int[N][M];
			visited = new boolean[N][M];
			check = new boolean[N][M];

//			System.out.println(2);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						group[i][j] = cnt;
						dfs(i, j);
						cnt++;
					}
					if (map[i][j] == 0) {
						count++;
					}
				}
			}
//			System.out.println(3);
			if (size == count) {
				break;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (group[i][j] != 0) {
						checkDic(i, j);
					}
				}
			}
//			System.out.println(4);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (check[i][j]) {
						map[i][j] = 0;
					}
				}
			}
			result++;
		}

		System.out.println(result);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(check[i][j] + " ");
//			}
//			System.out.println();
//
//		}

	}

	static void checkDic(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (0 <= px && px < N && 0 <= py && py < M) {
				if (group[px][py] == 0) {
					cnt++;
				}
			}
		}
		if (cnt >= 2) {
			check[x][y] = true;
		}
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (0 <= px && px < N && 0 <= py && py < M) {
				if (!visited[px][py] && map[x][y] == map[px][py]) {
					visited[px][py] = true;
					group[px][py] = cnt;
					dfs(px, py);
				}
			}
		}
	}
}
