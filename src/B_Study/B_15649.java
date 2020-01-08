package B_Study;

import java.util.Scanner;

public class B_15649 {
	static boolean[] check = new boolean[10];
	static int[] nums = new int[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		solve(0, N, M);

	}

	static void solve(int depth, int n, int m) {
		if (depth == m) {
			for(int i=0;i<m;i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (check[i])
				continue;
			check[i] = true;
			nums[depth] = i;
			solve(depth + 1, n, m);
			check[i] = false;
		}
	}
}
