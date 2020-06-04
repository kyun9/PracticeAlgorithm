package B_Study;

import java.util.Scanner;

public class B_15990 {
	static long M = 1000000009;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long[][] dp = new long[100001][3];

		dp[1][0] = dp[2][1] = dp[3][0] = dp[3][1] = dp[3][2] = 1;
		for (int i = 4; i < 100001; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % M;
			dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % M;
			dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % M;
		}
		
		int T = sc.nextInt();
		int n;long answer;
		for(int i=0;i<T;i++) {
			n= sc.nextInt();
			answer = (dp[n][0]+ dp[n][1]+ dp[n][2])%M;
			System.out.println(answer);
		}
		sc.close();
	}

}
