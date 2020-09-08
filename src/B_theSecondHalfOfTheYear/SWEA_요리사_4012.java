package B_theSecondHalfOfTheYear;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_요리사_4012 {
	static int N, result;
	static int[][] table;
	static int[] arr;
	static boolean[] check;

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

			System.out.println("#" + test+" "+ result);
		}
	}

	static void combination(int depth, int n, int r) {
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
			int hap1 = hap(tmp1);
			int hap2 = hap(tmp2);
			
			result = Math.min(result, Math.abs(hap1-hap2));
			return;
		}
		if (depth == n) {
			return;
		} else {
			check[depth] = true;
			combination(depth + 1, n, r - 1);
			check[depth] = false;
			combination(depth + 1, n, r);
		}

	}

	static int hap(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				sum += table[list.get(i)][list.get(j)] + table[list.get(j)][list.get(i)];
			}
		}
		return sum;
	}
}
