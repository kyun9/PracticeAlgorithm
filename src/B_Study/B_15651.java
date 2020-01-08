package B_Study;

import java.util.Scanner;

public class B_15651 {
	static int[] nums = new int[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		solve(0, N, M,"");

	}

	static void solve(int depth, int n, int m, String s) {
		if (depth == m) {
			System.out.println(s);
			return;
		}
		for (int i = 1; i <= n; i++) {
			nums[depth] = i;
			if(s.equals("")) {
				solve(depth + 1, n, m, s+nums[depth]);
			}
			else {
				solve(depth + 1, n, m, s+" "+nums[depth]);
			}
		}
	}
}
