package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Part {
	int x;
	int y;

	Part(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B_2573 {
	static int N, M, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Part> qu;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		qu = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					qu.add(new Part(i, j));
				}
			}
		}

		result = 0;
		while (true) {
			if (checkZero()) {
				result = 0;
				break;
			} else if (checkPart()) {
				break;
			}
			int[][] tempMap = new int[N][M];
			while (!qu.isEmpty()) {
				Part p = qu.poll();

				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int px = p.x + dx[i];
					int py = p.y + dy[i];

					if (0 <= px && px < N && 0 <= py && py < M) {
						if (map[px][py] == 0) {
							cnt++;
						}
					}
				}

				tempMap[p.x][p.y] = map[p.x][p.y] - cnt;
				if (tempMap[p.x][p.y] < 0) {
					tempMap[p.x][p.y] = 0;
				}
			}

			result++;
			copy(tempMap);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("result :  " + result);
		}

		System.out.println(result);
	}

	static boolean checkZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	static void copy(int[][] arr) {
		qu = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[i][j];
				if (map[i][j] != 0) {
					qu.add(new Part(i, j));
				}
			}
		}

	}

	static boolean checkPart() {
		visited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					cnt++;
					checkGroup(i, j);
				}
			}
		}
		if (cnt > 1) {
			return true;
		} else {
			return false;
		}
	}

	static void checkGroup(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < N && 0 <= py && py < M) {
				if (map[px][py] != 0 && !visited[px][py]) {
					checkGroup(px, py);
				}
			}
		}
	}
}
