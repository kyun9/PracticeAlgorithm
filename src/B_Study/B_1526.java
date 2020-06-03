package B_Study;

import java.util.Scanner;

public class B_1526 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] += dp[i-3];
			dp[i] += dp[i-2];
			dp[i] += dp[i-1];
		}

		int n = sc.nextInt();
		while (n-- > 0) {
			int val = sc.nextInt();
			System.out.println(dp[val]);
		}

	}

}
