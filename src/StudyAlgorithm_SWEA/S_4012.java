package StudyAlgorithm_SWEA;

import java.util.ArrayList;
import java.util.Scanner;

public class S_4012 {
	static int[][] table;
	static boolean[] check;
	static int[] arr;
	static int N, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			table = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}

			check = new boolean[N];
			arr = new int[N];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}
			combination(0, N, N / 2);
			System.out.println("#" + test + " " + result);
		}
		sc.close();
	}

	static void combination(int start, int n, int r) {
		if (r == 0) {
			ArrayList<Integer> tmp1 = new ArrayList<>();
			ArrayList<Integer> tmp2 = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (check[i]) {
					tmp1.add(arr[i]);
				} else {
					tmp2.add(arr[i]);
				}
			}

			int t1 = hap(tmp1);
			int t2 = hap(tmp2);
			result = Math.min(result, Math.abs(t1 - t2));
			return;
		}
		for (int i = start; i < n; i++) {
			check[i] = true;
			combination(i + 1, n, r - 1);
			check[i] = false;
		}
	}

	static int hap(ArrayList<Integer> alist) {
		int sum = 0;
		for (int i = 0; i < alist.size(); i++) {
			for (int j = i + 1; j < alist.size(); j++) {
				sum += table[alist.get(i)][alist.get(j)] + table[alist.get(j)][alist.get(i)];
			}
		}
		return sum;
	}
}
