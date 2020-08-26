package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_청소년상어_19236 {

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

	static int[][] dir = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
			{ -1, 1 } };
	static int[][] map = new int[4][4];
	static boolean[] isLive = new boolean[17]; // 물고기가 죽었는지 살았는지 체크하는 배열
	static int answer = Integer.MIN_VALUE;
	static Fish[] fishes = new Fish[17];

	public static void main(String[] args) throws IOException {
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

//		isLive[0]= true;
		isLive[map[0][0]] = false; // 상어가 처음 먹은 물고기를 죽인다.
		int n = map[0][0];
		map[0][0] = -1; // 상어 표시
		eatFish(0, 0, fishes[n].d, n, 1);

		System.out.println(answer);
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

		fishMove();		//물고기 이동

		for (int i = 1; i <= 3; i++) {			//4x4임으로 범위줌

			int nr = r + (dir[direction][0] * i);
			int nc = c + (dir[direction][1] * i);

			if (isInside(nr, nc)) { // 경계 범위 안이고 살아있는 물고기면

				if (map[nr][nc] == 0)
					continue;

				map[r][c] = 0;
				int n = map[nr][nc];
				map[nr][nc] = -1;
				isLive[n] = false;
				eatFish(nr, nc, fishes[n].d, sum + n, cnt + 1);	//백트래킹부분
				isLive[n] = true;
				map[nr][nc] = n;
				map[r][c] = -1;

			} else
				break;
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

		for (int i = 1; i <= 16; i++) {

			if (!isLive[i])
				continue; // 이미 잡아먹힌 물고기면 pass

			Fish cur = fishes[i]; // 현재 움직일 물고기
			int nd = cur.d;
			int nx = cur.x, ny = cur.y;
			boolean flag = false;

			int[] changeDir = { 0, 2, 3, 4, 5, 6, 7, 8, 1 };

			for (int j = 0; j < 8; j++) {

				nx = cur.x + dir[nd][0];
				ny = cur.y + dir[nd][1];

				if (isInside(nx, ny)) {
					if (map[nx][ny] == -1) {	//상어일때
						nd = changeDir[nd];		//방향바꾸기
						continue;
					}
					if (map[nx][ny] == 0 || map[nx][ny] != -1) {	//상어가 아닐때
						flag = true;
						break;
					}
				} else {
					nd = changeDir[nd];
				}
			}

			if (!flag)
				continue;

			// 현재 움직일 물고기 좌표에 있는 물고기와 자리를 바꾼다.
			int swap = map[nx][ny];
			map[nx][ny] = map[cur.x][cur.y];
			map[cur.x][cur.y] = swap;

			// 값 갱신
			fishes[i] = new Fish(nx, ny, nd); // 현재 움직인 물고기

			if (swap != 0) { // 이동하는 빈칸이 아니면 갱신
				fishes[swap] = new Fish(cur.x, cur.y, fishes[swap].d);
			}

		}
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < 4 && y >= 0 && y < 4;
	}

	public static void print() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}