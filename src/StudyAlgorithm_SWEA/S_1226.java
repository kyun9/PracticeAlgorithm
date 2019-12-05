package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_1226 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static boolean find;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int a = 1; a < 11; a++) {
			int testcase=Integer.valueOf(br.readLine());
			
			map = new int[16][16];
			visited = new boolean[16][16];
			
			for (int i = 0; i < 16; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					map[i][j] = temp[j] - '0';
					if (map[i][j] == 1) {
						visited[i][j] = true;
					}
				}
			}

			find = false;
			solve(1, 1);
			int result = 0;
			if (find)
				result = 1;

			System.out.println("#" + testcase + " " + result);
		}
	}

	static void solve(int row, int col) {
		if (map[row][col] == 3) {
			find = true;
			return;
		}
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int x = row + dx[i];
			int y = col + dy[i];

			if (0 <= x && x < 16 && 0 <= y && y < 16) {
				if (!visited[x][y] && map[x][y] != 1) {
					solve(x, y);
				}
			}
		}
	}

}
