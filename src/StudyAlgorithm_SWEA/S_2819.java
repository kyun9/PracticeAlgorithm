package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S_2819 {

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static HashSet<String> hash;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		char[][] arr = new char[4][4];

		for (int a = 1; a <= T; a++) {

			for (int i = 0; i < arr.length; i++) {
				String[] line = bf.readLine().split(" ");
				for (int j = 0; j < line.length; j++) {
					arr[i][j] = line[j].charAt(0);
				}
			}

			hash = new HashSet<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					String result = String.valueOf(arr[i][j]);
					dfs(i, j, 0, result, arr);
				}
			}

			System.out.println("#" + a + " " + hash.size());
		}

	}

	static void dfs(int row, int col, int depth, String result, char[][] arr) {
		if (depth == 6) {
			hash.add(result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int x = row + dx[i];
			int y = col + dy[i];

			if (x >= 0 && x < 4 && y >= 0 && y < 4) {
				result = arr[x][y] + result;
				dfs(x, y, depth + 1, result, arr);
				result = result.substring(1);
			}
		}
	}
}
