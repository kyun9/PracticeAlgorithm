package p2021_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 청소년상어 {
	static class Fish {
		int x;
		int y;
		int d;

		Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int[][] dir = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
	static int[][] map = new int[4][4];
	static boolean[] isLive = new boolean[17];
	static int answer = Integer.MIN_VALUE;
	static Fish[] fishes = new Fish[17];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Arrays.fill(isLive, true);

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				fishes[num] = new Fish(i, j, dir);
			}
		}

		isLive[map[0][0]] = false;
		int n = map[0][0];
		map[0][0] = -1;
		eatFish(0, 0, fishes[n].d, n, 1);
		
		System.err.println(answer);
	}

	public static void eatFish(int r, int c, int direction, int sum, int cnt) {
		int[][] copyMap = new int[4][4];
		Fish[] copyFishes = new Fish[17];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		for (int i = 1; i <= 16; i++) {
			copyFishes[i] = fishes[i];
		}

		fishMove();

		for (int i = 1; i < 4; i++) {
			int nr = r + (dir[direction][0] * i);
			int nc = c + (dir[direction][1] * i);

			if (isInside(nr, nc)) {
				if (map[nc][nr] == 0)
					continue;

				map[r][c] = 0;
				int n = map[nr][nc];
				map[nr][nc] = -1;
				isLive[n] = false;
				eatFish(nr, nc, fishes[n].d, sum + n, cnt + 1);
				isLive[n] = true;
				map[nr][nc] = n;
				map[r][c] = -1;
			} else {
				break;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = copyMap[i][j];
			}
		}

		for (int i = 1; i <= 16; i++) {
			fishes[i] = copyFishes[i];
		}

		answer = Math.max(sum, answer);

	}

	public static void fishMove() {
		for (int i = 0; i < 17; i++) {
			if (!isLive[i]) {
				continue;
			}

			Fish cur = fishes[i];
			int nd = cur.d;
			int nx = cur.x;
			int ny = cur.y;
			boolean flag = false;

			int[] changeDir = { 0, 2, 3, 4, 5, 6, 7, 8, 9, 1 };

			for (int j = 0; j < 8; j++) {
				nx = cur.x + dir[nd][0];
				ny = cur.y + dir[nd][1];

				if (isInside(nx, ny)) {
					if (map[nx][ny] == -1) {
						nd = changeDir[nd];
						continue;
					}
					if (map[nx][ny] == 0 || map[nx][ny] != -1) {
						flag = true;
						break;
					}
				} else {
					nd = changeDir[nd];
				}
			}

			if (!flag)
				continue;

			int swap = map[nx][ny];
			map[nx][ny] = map[cur.x][cur.y];
			map[cur.x][cur.y] = swap;

			fishes[i] = new Fish(nx, ny, nd);

			if (swap != 0) {
				fishes[swap] = new Fish(cur.x, cur.y, fishes[swap].d);
			}
		}
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < 4 && y >= 0 && y < 4;
	}
}
