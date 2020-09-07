package B_theSecondHalfOfTheYear;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_핀볼게임_5650 {
	static int T, N, result;
	static int[][] map;
	static Point[][] warm;
	// 북동남서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());

		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N + 2][N + 2];
			warm = new Point[2][5];
			result = Integer.MIN_VALUE;

			for (int i = 0; i < N + 2; i++) { // 테두리 벽
				map[0][i] = map[N + 1][i] = map[i][0] = map[i][N + 1] = 5;
			}

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] >= 6) {
						if (warm[0][map[i][j] - 6] != null) {
							warm[1][map[i][j] - 6] = new Point(i, j);
						} else {
							warm[0][map[i][j] - 6] = new Point(i, j);
						}
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != 0) {
						continue;
					}
					for (int k = 0; k < 4; k++) {
						game(i, j, k);
					}
				}
			}

			System.out.println("#" +test+ " " + result);
		}
	}

	static void game(int x, int y, int d) {
		int tempX = x;
		int tempY = y;
		int hit = 0;

		while (true) {
			int px = tempX + dx[d];
			int py = tempY + dy[d];

			if (map[px][py] == -1 || (px == x && py == y)) { // 종료
				break;
			}

			if (map[px][py] >= 6) { // 웜홀이면
				Point p = moveWarm(map[px][py], px, py);
				tempX = p.x;
				tempY = p.y;
				continue;
			} else if (map[px][py] >= 1) { // 블록 부딛히면
				d = changeDic(map[px][py], d);
				hit++;
			}

			tempX = px;
			tempY = py;
		}

		result = Math.max(result, hit);
	}

	static Point moveWarm(int warmNum, int x, int y) {
		Point p1 = warm[0][warmNum - 6];
		Point p2 = warm[1][warmNum - 6];

		if (p1.x == x && p1.y == y) {
			return p2;
		} else {
			return p1;
		}
	}

	// 북동남서 0 1 2 3
	static int changeDic(int block, int d) {
		switch (block) {
		case 1:
			switch (d) {
			case 0:
				d = 2;
				break;
			case 1:
				d = 3;
				break;
			case 2:
				d = 1;
				break;
			case 3:
				d = 0;
				break;
			}
			break;
		case 2:
			switch (d) {
			case 0:
				d = 1;
				break;
			case 1:
				d = 3;
				break;
			case 2:
				d = 0;
				break;
			case 3:
				d = 2;
				break;
			}
			break;
		case 3:
			switch (d) {
			case 0:
				d = 3;
				break;
			case 1:
				d = 2;
				break;
			case 2:
				d = 0;
				break;
			case 3:
				d = 1;
				break;
			}
			break;
		case 4:
			switch (d) {
			case 0:
				d = 2;
				break;
			case 1:
				d = 0;
				break;
			case 2:
				d = 3;
				break;
			case 3:
				d = 1;
				break;
			}
			break;
		case 5:
			switch (d) {
			case 0:
				d = 2;
				break;
			case 1:
				d = 3;
				break;
			case 2:
				d = 0;
				break;
			case 3:
				d = 1;
				break;
			}
			break;
		}

		return d;
	}
}