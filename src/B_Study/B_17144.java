package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Dust {
	int x;
	int y;
	int val;

	Dust(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

public class B_17144 {
	static int R, C, T, result;
	static int[][] map;
	static int[][] copyMap;
	static ArrayList<Integer> machine;
	static ArrayList<Dust> dust;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		machine = new ArrayList<>();
		dust = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					machine.add(i);
				} else if (map[i][j] != 0 && map[i][j] != -1) {
					dust.add(new Dust(i, j, map[i][j]));
				}
			}
		}
		
		//T초후
		for (int i = 1; i <= T; i++) {
			solve();
		}
		
		//미세먼지 수 체크
		check();

		System.out.println(result);
	}

	static void solve() {
		spread();
		rotate();
		addDust();
	}
	
	//미세먼지 추가
	static void addDust() {
		dust.clear();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					dust.add(new Dust(i, j, map[i][j]));
				}
			}
		}
	}
	//미세먼지수 체크
	static void check() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					result += map[i][j];
				}
			}
		}
	}
	//공기청정기 회전
	static void rotate() {
		// machine 위
		int swap = 0;
		int x = machine.get(0);
		int temp = map[0][0];
		for (int i = 0; i < x; i++) {
			swap = temp;
			temp = map[i + 1][0];
			map[i + 1][0] = swap;
		}
		for (int i = 0; i < C - 1; i++) {
			swap = temp;
			temp = map[x][i + 1];
			map[x][i + 1] = swap;
		}
		for (int i = x; i > 0; i--) {
			swap = temp;
			temp = map[i - 1][C - 1];
			map[i - 1][C - 1] = swap;
		}
		for (int i = C - 1; i > 0; i--) {
			swap = temp;
			temp = map[0][i - 1];
			map[0][i - 1] = swap;
		}
		map[x][0] = -1;
		map[x][1] = 0;

		// machine 아래
		swap = 0;
		x = machine.get(1);
		temp = map[x][0];
		for (int i = 0; i < C - 1; i++) {
			swap = temp;
			temp = map[x][i + 1];
			map[x][i + 1] = swap;
		}
		for (int i = x; i < R - 1; i++) {
			swap = temp;
			temp = map[i + 1][C - 1];
			map[i + 1][C - 1] = swap;
		}
		for (int i = C - 1; i > 0; i--) {
			swap = temp;
			temp = map[R - 1][i - 1];
			map[R - 1][i - 1] = swap;
		}
		for (int i = R - 1; i > x; i--) {
			swap = temp;
			temp = map[i - 1][0];
			map[i - 1][0] = swap;
		}
		map[x][0] = -1;
		map[x][1] = 0;
	}

	//미세먼지 확산
	static void spread() {
		//임시 맵
		copyMap = new int[R][C];

		while (!dust.isEmpty()) {
			Dust p = dust.remove(0);
			int x = p.x;
			int y = p.y;
			int val = p.val;

			ArrayList<Integer> dic = checkDirection(x, y);
			if (!dic.isEmpty()) {
				int s = val / 5;
				for (int i = 0; i < dic.size(); i++) {
					int px = x + dx[dic.get(i)];
					int py = y + dy[dic.get(i)];
					copyMap[px][py] += s;
				}
				copyMap[x][y] += val - s * dic.size();
			} else {
				copyMap[x][y] += val;
			}
		}

		copyMap[machine.get(0)][0] = -1;
		copyMap[machine.get(1)][0] = -1;
		
		//복사
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}
	
	//미세먼지 확산 방향 확인
	static ArrayList<Integer> checkDirection(int x, int y) {
		ArrayList<Integer> dic = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < R && 0 <= py && py < C) {
				if (map[px][py] != -1) {
					dic.add(i);
				}
			}
		}
		return dic;
	}
}
