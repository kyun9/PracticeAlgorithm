package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_원판돌리기_17822 {
	static int N, M, T;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			move(x, d, k); // 동작
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					result += map[i][j];
				}
			}
		} // 전체 합 구하기

		System.out.println(result);
	}

	static void move(int x, int d, int k) {
		int tempX = x;
		while (tempX - 1 < N) { // 회전
			if (d == 0) { // 시계방향
				for (int j = 0; j < k; j++) {
					int temp = map[tempX - 1][M - 1];
					for (int i = M - 1; i >= 1; i--) {
						map[tempX - 1][i] = map[tempX - 1][i - 1];
					}
					map[tempX - 1][0] = temp;
				}
			} else if (d == 1) { // 반시계방향
				for (int j = 0; j < k; j++) {
					int temp = map[tempX - 1][0];
					for (int i = 0; i < M - 1; i++) {
						map[tempX - 1][i] = map[tempX - 1][i + 1];
					}
					map[tempX - 1][M - 1] = temp;
				}
			}

			tempX += x;
		}

		flag = false;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != -1) {
					check(i, j, map[i][j]); // 인접확인하기
				}
			}
		}

		if (!flag) { // 인접하는 값이 없을때, 처리
			updateMap();
		}
	}

	static void updateMap() {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					sum += map[i][j];
					cnt++;
				}
			}
		}

		float avg = (float) (sum) / cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					if (map[i][j] < avg) {
						map[i][j] += 1;
					} else if (map[i][j] > avg) {
						map[i][j] -= 1;
					}
				}
			}
		}
	}

	// 인접 확인하기
	static void check(int x, int y, int val) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (py < 0) {
				py = M - 1;
			} else if (py >= M) {
				py = 0;
			}

			if (0 <= px && px < N) {
				if (!visited[px][py] && map[px][py] == val) {
					flag = true;
					map[x][y] = -1; // -1로 변환
					map[px][py] = -1;
					check(px, py, val); // 값이 같으면 반복
				}
			}

		}

	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
