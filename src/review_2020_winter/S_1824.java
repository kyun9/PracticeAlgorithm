package review_2020_winter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1824 {
	static int T, R, C;
	static char[][] map;
	static boolean endFind, find;
	static boolean[][][][] visited;
	// 북 서 동 남
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visited = new boolean[R][C][4][16];

			endFind=false;
			find =false;
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '@') {
						endFind = true;
					}
				}
			}

			if (endFind) {
				solve(0, 0, 2, 0);
			}

			String s = find ? "YES" : "NO";
			System.out.println("#" + test + " " + s);
		}
	}

	static void solve(int x, int y, int d, int mem) {
		if (map[x][y] == '@') {
			find = true;
			return;
		}
		if (visited[x][y][d][mem]) {
			return;
		}
		visited[x][y][d][mem] = true;

		int nd = d;
		int nm = mem;

		switch (map[x][y]) {
		case '<':
			nd = 1;
			break;
		case '>':
			nd = 2;
			break;
		case '^':
			nd = 0;
			break;
		case 'v':
			nd = 3;
			break;
		case '_':
			nd = (mem == 0 ? 2 : 1);
			break;
		case '|':
			nd = (mem == 0 ? 3 : 0);
			break;
		case '+':
			nm = (mem == 15 ? 0 : mem + 1);
			break;
		case '-':
			nm = (mem == 0 ? 15 : mem - 1);
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			nm = map[x][y] - '0';
			break;
		}

		if (map[x][y] == '?') {
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] < 0) {
					solve(R - 1, y + dy[i], i, nm);
				} else if (x + dx[i] >= R) {
					solve(0, y + dy[i], i, nm);
				} else if (y + dy[i] < 0) {
					solve(x + dx[i], C - 1, i, nm);
				} else if (y + dy[i] >= C) {
					solve(x + dx[i], 0, i, nm);
				} else {
					solve(x + dx[i], y + dy[i], i, nm);
				}
			}
		}

		else {
			if (x + dx[nd] < 0) {
				solve(R - 1, y + dy[nd], nd, nm);
			} else if (x + dx[nd] >= R) {
				solve(0, y + dy[nd], nd, nm);
			} else if (y + dy[nd] < 0) {
				solve(x + dx[nd], C - 1, nd, nm);
			} else if (y + dy[nd] >= C) {
				solve(x + dx[nd], 0, nd, nm);
			} else {
				solve(x + dx[nd], y + dy[nd], nd, nm);
			}
		}
	}
}
