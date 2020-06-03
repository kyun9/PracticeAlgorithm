package B_Study;

import java.util.Scanner;

public class B_11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			arr[i]= sc.nextInt();
		}
		
		//일반화 시키는 식을 늘 생각하자
		//  D[i] = P[n] + D[i-n] 
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				dp[i]= Math.max(dp[i], dp[i-j]+arr[j]);
			}
		}
		
		System.out.println(dp[N]);
	}

}
