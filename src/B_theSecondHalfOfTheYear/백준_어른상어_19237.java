package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_어른상어_19237 {
	static class Pair222 { // 리스트를 위한 class
		int x;
		int y;
		int idx;

		Pair222(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
	}

	static class Shark { // 상어 class
		int x;
		int y;
		int d;
		int[][] priority;

		Shark(int x, int y) {
			this.x = x;
			this.y = y;
			d = 0;
			priority = new int[5][5];
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}

	static int N, M, k, time = 0;
	static int[][] map, timeArr;
	static boolean[] isLive;
	static Shark[] sharks;
	static ArrayList<Pair222> list = new ArrayList<>();
	// 중앙, 위, 아래, 왼, 오른
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		timeArr = new int[N][N];
		sharks = new Shark[M + 1];
		isLive = new boolean[M + 1];
		Arrays.fill(isLive, true);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					timeArr[i][j] = k;
					sharks[map[i][j]] = new Shark(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			sharks[i].d = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < M + 1; i++) {
			for (int j = 1; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k < 5; k++) {
					sharks[i].priority[j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		solve();// 풀이시작
	}

	static void solve() {
		while (time <= 1000) { // 1000초 조건 반복
			time++;
			list.clear();
			// 상어이동
			for (int i = 1; i <= M; i++) {
				if (!isLive[i]) { // 상어가 쫓아나있다면 제외!
					continue;
				}
				Shark shark = sharks[i];
				int px = 0, py = 0, pd = 0;
				boolean flag = false;
				for (int j = 1; j <= 4; j++) {
					pd = shark.priority[shark.d][j];
					px = shark.x + dx[shark.priority[shark.d][j]];
					py = shark.y + dy[shark.priority[shark.d][j]];
					if (isPossible(px, py) && map[px][py] == 0) {	// N*N 범위이내, 비어있는칸
						flag = true;
						break;
					}
				}
				if (flag) { // 이동
					sharks[i].x = px;
					sharks[i].y = py;
					sharks[i].d = pd;
					list.add(new Pair222(px, py, i));
				} else { // 이동할 칸이 없음
					for (int j = 1; j <= 4; j++) {
						pd = shark.priority[shark.d][j];
						px = shark.x + dx[shark.priority[shark.d][j]];
						py = shark.y + dy[shark.priority[shark.d][j]];
						if (isPossible(px, py) && map[px][py] == i) { // N*N 범위이내, 자신의 냄새가 있는 칸으로 이동!
							sharks[i].x = px;
							sharks[i].y = py;
							sharks[i].d = pd;
							list.add(new Pair222(px, py, i));
							break;
						}
					}
				}

			}

			// 1초 냄새제거
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (timeArr[i][j] != 0) {
						timeArr[i][j] -= 1;
						if (timeArr[i][j] == 0) {
							map[i][j] = 0;
						}
					}
				}
			}

			// 상어 중복 제외 및 1초 이동(냄새 추가)
			boolean[][] check = new boolean[N][N];
			for (int i = 0; i < list.size(); i++) {
				Pair222 p = list.get(i);
				if (!check[p.x][p.y]) {
					check[p.x][p.y] = true;
					map[p.x][p.y] = p.idx;
					timeArr[p.x][p.y] = k;
				} else {
					isLive[p.idx] = false; // 중복되면 쫓아냄
				}
			}

			// 1번 상어만 살아있는지 검사
			boolean flag = true;
			for (int i = 2; i <= M; i++) {
				if (isLive[i]) {
					flag = false;
				}
			}
			if (flag) { // 1번 상어만 있으면 while문 종료
				break;
			}
		}

		if (time == 1001)
			System.out.println(-1);
		else
			System.out.println(time);
	}

	static boolean isPossible(int px, int py) {
		return 0 <= px && px < N && 0 <= py && py < N;
	}

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
