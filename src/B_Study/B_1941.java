package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 어려움 다시 풀어보기
public class B_1941 {
	static int ans, cnt;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static char[][] array;
	static boolean[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new char[5][5];

		for (int i = 0; i < 5; i++) {
			array[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < 25; i++) {
			//visited를  25로 잡은 이유가 dfs이용한 백트래킹으로는 십자가 같은 모양의 연결은 찾지 못함
			visited = new boolean[25];
			map = new boolean[5][5];
			dfs(i, 1, 0);
		}
		System.out.println(ans);
	}

	//25 boolean 배열을 통하여 랜덤하게 7개를 뽑아냄
	public static void dfs(int n, int cnt, int s) {
		if (array[n / 5][n % 5] == 'S') {
			++s;
		}

		visited[n] = true;
		map[n / 5][n % 5] = true;

		if (7 == cnt) {
			if (s >= 4) {
				find();
			}
		} else {
			for (int i = n + 1; i < 25; i++) {
				if (!visited[i]) {
					dfs(i, cnt + 1, s);
				}
			}
		}
		// backtracking
		visited[n] = false;
		map[n / 5][n % 5] = false;
	}

	//찾아 낸걸 visited 이차원배열에  다시 표시하고 전부 연결된 요소인지 확인 하기 dfs다시 실행
	public static void find() {
		for (int i = 0; i < 25; i++) {
			if (visited[i]) {
				int y = i / 5;
				int x = i % 5;

				boolean[][] visited = new boolean[5][5];
				visited[y][x] = true;
				cnt = 1;
				isComponent(y, x, visited);
				return;
			}
		}
	}

	// true/false를 통하여 연결 여부 확인후 ans 증가
	public static void isComponent(int y, int x, boolean[][] checked) {
		if (7 == cnt) {
			++ans;
		} else {
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + y;
				int nx = dx[i] + x;

				if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
					if (map[ny][nx] && !checked[ny][nx]) {
						checked[ny][nx] = true;
						++cnt;
						isComponent(ny, nx, checked);
					}
				}
			}
		}
	}

}
