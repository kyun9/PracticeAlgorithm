package B_Study;

import java.util.Scanner;

public class B_16194 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[N+1];
		int[] dp= new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			arr[i]= sc.nextInt();
			dp[i]=Integer.MAX_VALUE;
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<=i;j++) {
				dp[i]= Math.min(dp[i], dp[i-j]+arr[j]);
			}
		}
		
		System.out.println(dp[N]);
	}

}
