package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S_1868 {
	static char[][] map;
	static boolean[][] visited;
	static int[][] copy;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int N;
	static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int a = 1; a < T + 1; a++) {
			N = Integer.valueOf(br.readLine());

			map = new char[N][N];
			copy = new int[N][N];
			visited = new boolean[N][N];
			set = new HashSet<>();

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						countMine(i, j);
					} else if (map[i][j] == '*') {
						copy[i][j] = -1;
					}
				}
			}

			int cnt = 9;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '0' && !visited[i][j]) {
						solve(i, j, cnt++);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copy[i][j] == 0 && !visited[i][j]) {
						copy[i][j] = cnt++;
						visited[i][j] = true;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copy[i][j] != -1) {
						set.add(copy[i][j]);
					}
				}
			}

			System.out.println("#" + a+" "+set.size());
		}
	}

	static void countMine(int a, int b) {
		int count = 0;

		for (int i = 0; i < 8; i++) {
			int x = a + dx[i];
			int y = b + dy[i];

			if (0 <= x && x < N && 0 <= y && y < N) {
				if (map[x][y] == '*') {
					count++;
				}
			}
		}
		map[a][b] = (char) (count + '0');
	}

	static void solve(int a, int b, int count) {
		if (visited[a][b]) {
			return;
		}
		visited[a][b] = true;
		copy[a][b] = count;
		if (map[a][b] != '0') {
			return;
		}
		for (int i = 0; i < 8; i++) {
			int x = a + dx[i];
			int y = b + dy[i];

			if (0 <= x && x < N && 0 <= y && y < N) {
				solve(x, y, count);
			}
		}
	}
}
