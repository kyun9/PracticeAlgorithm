package B_Study;

import java.util.Scanner;

public class B_15988 {

	static int MOD = 1000000009;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[1000001];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 1000001; i++) {
			dp[i] += dp[i-3];
			dp[i] %= MOD;
			dp[i] += dp[i-2];
			dp[i] %= MOD;
			dp[i] += dp[i-1];
			dp[i] %= MOD;
		}

		int n = sc.nextInt();
		while (n-- > 0) {
			int val = sc.nextInt();
			System.out.println(dp[val]);
		}

	}

}
