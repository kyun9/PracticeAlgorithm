package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_경사로_14890 {
	static int N, L, count = 0;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] arr = map[0];

		// 가로먼저
		int[] row = new int[N];
		for (int i = 0; i < N; i++) {
			row = map[i];
			if (checkRoad(row)) {
				count++;
			}
		}

		// 세로
		int[] col = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				col[j] = map[j][i];
			}
			if (checkRoad(col)) {
				count++;
			}
		}

		System.out.println(count);
	}

	static boolean checkRoad(int[] arr) {
		//경사로 확인
		boolean[] check = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			// 높이가 같으면 패스
			if (arr[i] == arr[i + 1])
				continue;

			if (Math.abs(arr[i] - arr[i + 1]) > 1)
				return false;

			// 내려가야되는 경우
			if (arr[i] - arr[i + 1] == 1) {
				for (int j = i + 1; j <= i + L; j++) {
					// j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우
					if (j >= N || arr[i + 1] != arr[j] || check[j] == true)
						return false;
					check[j] = true;
				}
			}
			// 올라가야되는 경우
			else if (arr[i + 1] - arr[i] == 1) {
				for (int j = i; j > i - L; j--) {
					if (j < 0 || arr[i] != arr[j] || check[j] == true)
						return false;
					check[j] = true;
				}
			}
		}
		return true;
	}
}
