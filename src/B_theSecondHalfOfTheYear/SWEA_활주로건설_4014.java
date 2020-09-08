package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_활주로건설_4014 {
	static int T, N, X, result;
	static int[][] map;
	static ArrayList<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = 0;
			searchRoad();
			confirmRoad();
			System.out.println("#" + test + " " + result);
		}
	}

	static void searchRoad() {
		list = new ArrayList<>();
		String s = "";
		for (int i = 0; i < N; i++) {
			s = "";
			for (int j = 0; j < N; j++) {
				s += map[i][j];
			}
			list.add(s);
		}

		for (int i = 0; i < N; i++) {
			s = "";
			for (int j = 0; j < N; j++) {
				s += map[j][i];
			}
			list.add(s);
		}
	}

	static void confirmRoad() {
		int[] arr = new int[N];

		label: while (!list.isEmpty()) {
			boolean[] check = new boolean[N];

			String s = list.remove(0);
			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}

			for (int i = 0; i < N - 1; i++) {
				if (arr[i] == arr[i + 1]) {
					continue;
				}

				if (Math.abs(arr[i] - arr[i + 1]) > 1) {
					continue label;
				}

				if (arr[i] - 1 == arr[i + 1]) {
					for (int j = i + 1; j <= i + X; j++) {
						if (j >= N || arr[i + 1] != arr[j] || check[j]) {
							continue label;
						}
						check[j] = true;
					}
				}

				else if (arr[i] + 1 == arr[i + 1]) {
					for (int j = i; j > i - X; j--) {
						if (j < 0 || arr[i] != arr[j] || check[j]) {
							continue label;
						}
						check[j] = true;
					}
				}
			}
			result++;
		}
	}
}
