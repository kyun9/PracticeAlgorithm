package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S_1249 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static boolean[][] check;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

//		int T = Integer.parseInt(st.nextToken());
//		for(int t=1; t<=T; t++) {
		int size = Integer.valueOf(br.readLine());
		int[][] arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < line.length; j++) {
				arr[i][j] = Integer.valueOf(line[j]);
			}
		}
		
		check = new boolean[size][size];
		answer=999999999;
		int result = 0;
		dfs(0, 0, size, arr, result);

		System.out.println(answer);
//			System.out.println("#" + t + " " + list.get(0));
//		}

	}

	static void dfs(int row, int col, int size, int[][] arr, int result) {
		if (row == size - 1 && col == size - 1) {
			if(result<answer) {
				answer=result;
			}
			return;
		}
		check[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int x = row + dx[i];
			int y = col + dy[i];

			if (x >= 0 && x < size && y >= 0 && y < size) {
				if (check[x][y] == false) {
					result += arr[x][y];
					dfs(x, y, size, arr, result);
					result -= arr[x][y];
					check[x][y] = false;
				}
			}
		}
	}

}
