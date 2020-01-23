package review_2020_winter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_2819 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int[][] arr;
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			arr = new int[4][4];

			StringTokenizer st;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(0, i, j, String.valueOf(arr[i][j]));
				}
			}

			System.out.println("#" + test + " " + set.size());
		}
	}

	static void dfs(int depth, int x, int y, String s) {
		if (depth == 6) {
			set.add(s);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (0 <= px && px < 4 && 0 <= py && py < 4) {
				dfs(depth + 1, px, py, s + arr[px][py]);
			}
		}
	}
}
