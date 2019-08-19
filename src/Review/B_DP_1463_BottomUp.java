package Review;

import java.util.Scanner;

public class B_DP_1463_BottomUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int[] dp = new int[num+1];
		
		dp[1]=0;
		for(int i=2;i<=num;i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) dp[i]=Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i]=Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[num]);
	}

}
