package B_Study;

import java.util.Scanner;

public class B_9663_N_Queen {
	static int N, result;
	static int[] cols;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		cols = new int[15];

		for (int i = 1; i <= N; i++) {
			cols[1] = i;
			dfs(1);
		}
		System.out.println(result);
		sc.close();
	}

	static void dfs(int num) {
		if (num == N) {
			result++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			cols[num + 1] = i;
			if (confirmPoint(num + 1)) {
				dfs(num + 1);
			}
		}
	}

	static boolean confirmPoint(int p) {
		for (int i = 1; i < p; i++) {
			if (cols[i] == cols[p]) {
				return false;
			}
			if (Math.abs(cols[i] - cols[p]) == Math.abs(i - p)) {
				return false;
			}
		}
		return true;
	}

}
