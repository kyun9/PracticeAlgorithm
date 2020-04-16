package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2468 {
	static int N, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		map = new int[N][N];

		StringTokenizer st;
		int size = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (size < map[i][j]) {
					size = map[i][j];
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i <= size; i++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k] && map[j][k] > i) {
						dfs(i, j, k);
						cnt++;
					}
				}
			}
			result=Math.max(result, cnt);
		}
		
		
		System.out.println(result);
	}

	static void dfs(int depth, int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < N && 0 <= py && py < N) {
				if(map[px][py]>depth && !visited[px][py]) {
					dfs(depth, px,py);
				}
			}
		}
	}
}
