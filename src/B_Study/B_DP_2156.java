package B_Study;

import java.util.Scanner;

public class B_DP_2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size+1];
		for(int i=1;i<=size;i++) {
			arr[i]= sc.nextInt();
		}
		
		int[] dp = new int[size+1];
		dp[1]=arr[1];
		if(size>=2) {
			dp[2]=arr[2]+arr[1];
		}
		
		for(int i=3;i<=size;i++) {
			dp[i]=dp[i-1];
//			if(dp[i]<dp[i-2]+arr[i]) {
//				dp[i]=dp[i-2]+arr[i];
//			}
//			if(dp[i]<dp[i-3]+arr[i-1]+arr[i]) {
//				dp[i]=dp[i-3]+arr[i-1]+arr[i];
//			}
			dp[i]=Math.max(dp[i], dp[i-2]+arr[i]);
			dp[i]=Math.max(dp[i], dp[i-3]+arr[i-1]+arr[i]);
		}
		
		int result = dp[size];
		System.out.println(result);
	}

}
