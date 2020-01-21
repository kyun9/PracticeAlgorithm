package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//이 문제는 단순 dfs로 풀지 못한다
// 왜냐하면 십자같은 모양은 탐색을 할 수 없기 때문

public class B_1941_self {
	static int result;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				visited[i][j] = true;
				dfs(0, i, j, String.valueOf(map[i][j]));
				visited[i][j] = false;
			}
		}
		System.out.println(result);
	}

	static void dfs(int depth, int x, int y, String s) {
		if (depth == 6) {
			char[] arr = s.toCharArray();
			int cnt=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]=='S') {
					cnt++;
				}
			}
			if(cnt>=4) {
				result++;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < 5 && 0 <= py && py < 5) {
				if (!visited[px][py]) {
					visited[px][py] = true;
					dfs(depth + 1, px, py, s + map[px][py]);
					visited[px][py] = false;
				}
			}
		}
	}

}
