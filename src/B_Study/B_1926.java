package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1926 {
	static int n, m, result,sum,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result=0;
		cnt=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1&&!visited[i][j]) {
					sum=0;
					dfs(i, j);
					result= Math.max(result, sum);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(result);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		sum++;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < n && 0 <= py && py < m && map[px][py] == 1) {
				if (!visited[px][py]) {
					dfs(px, py);
				}
			}
		}
	}
}
