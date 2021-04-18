package p2021_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {

	static int N;
	static int x;
	static int y;
	static int dir = 0;
	static int[][] map;
	static int result = 0;

	static int dx[][] = { { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 }, { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 },
			{ -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 }, { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 } };
	static int dy[][] = { { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 },
			{ -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } };
	static int percent[] = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int start = N / 2;

		rotate(start);
	}

	static void rotate(int start) {
		x = start;
		y = start;
		int cnt = 0;
		int move_cnt = 1;

		while (true) { // 회전 하는 반복문
			if (cnt == 2) { // 왼쪽 아래, 오른쪽 위
				cnt = 0;
				move_cnt++;
			}
			for (int i = 0; i < move_cnt; i++) {
				move(dir);
				spread();
				if (x == 0 && y == 0) {
					System.out.println(result);
					return;
				}
				//print();
			}
			dir = dir_change(dir);
			cnt += 1;
		}
	}

	static void move(int dir) {
		switch (dir) {
		case 0:
			y -= 1;
			break;
		case 1:
			x += 1;
			break;
		case 2:
			y += 1;
			break;
		case 3:
			x -= 1;
			break;
		}
	}

	static void spread() {
		int total_sand = map[x][y];
		int tmp_sand = total_sand;

		int nx, ny;
		for (int i = 0; i < 9; i++) {
			nx = x + dx[dir][i];
			ny = y + dy[dir][i];

			int spread_sand = (total_sand * percent[i]) / 100;
			tmp_sand -= spread_sand;

			if (isInside(nx, ny)) {
				map[nx][ny] += spread_sand;
			} else {
				result += spread_sand;
			}
		}

		nx = x + dx[dir][9];
		ny = y + dy[dir][9];

		if (isInside(nx, ny)) {
			map[nx][ny] += tmp_sand;
		} else {
			result += tmp_sand;
		}

		map[x][y] = 0;
	}

	static boolean isInside(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		} else {
			return false;
		}
	}

	static int dir_change(int dir) {
		if (dir == 3) {
			dir = 0;
		} else {
			dir += 1;
		}
		return dir;
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
