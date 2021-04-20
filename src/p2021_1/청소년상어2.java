package p2021_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 청소년상어2 {

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

	static int[][] map = new int[4][4];
	static Fish[] fishes = new Fish[17];
	static boolean[] isLive = new boolean[17];
	static int result = Integer.MIN_VALUE;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = n;
				fishes[n] = new Fish(i, j, d);
			}
		}

		Arrays.fill(isLive, true);
		int n = map[0][0];
		isLive[n] = false;
		map[0][0] = -1;

		start(0, 0, fishes[n].d, n);

		System.out.println(result);
	}

	static void start(int x, int y, int d, int sum) {
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

		move();

		for (int i = 1; i < 4; i++) {
			int px = x + (dx[d]*i);
			int py = y + (dy[d]*i);

			if (isInside(px, py)) {
				if (map[px][py] == 0)
					continue;

				map[x][y] = 0;
				int n = map[px][py];
				map[px][py] = -1;
				isLive[n] = false;
				start(px, py, fishes[n].d, sum + n);
				isLive[n] = true;
				map[px][py] = n;
				map[x][y] = -1;
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

		result = Math.max(sum, result);
	}

	static void move() {
		for (int i = 1; i < 17; i++) {
			if (!isLive[i])
				continue;

			Fish cur = fishes[i];
			int x = cur.x;
			int y = cur.y;
			int d = cur.d;

			boolean check = false;
			int[] changeD = { 1, 2, 3, 4, 5,6, 7, 0 };

			for (int j = 0; j < 8; j++) {
				 x = cur.x + dx[d];
				 y = cur.y + dy[d];

				if (isInside(x, y)) {
					if (map[x][y] == -1) {
						d = changeD[d];
						continue;
					} else if (map[x][y] == 0 || map[x][y] != -1) {
						check = true;
						break;
					}
				} else {
					d = changeD[d];
				}
			}
			if (!check) {
				continue;
			}

			int swap = map[x][y];
			map[x][y] = map[cur.x][cur.y];
			map[cur.x][cur.y] = swap;

			fishes[i] = new Fish(x, y, d);

			if (swap != 0) {
				fishes[swap] = new Fish(cur.x, cur.y, fishes[swap].d);
			}
		}
	}

	static boolean isInside(int x, int y) {
		return (0 <= x && x < 4 && 0 <= y && y < 4);
	}

}
