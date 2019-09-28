package B_Study;

import java.util.Scanner;

public class B_DP_10844_self {
	public static long mod = 1000000000L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		long[][] arr= new long[input+1][10];
		for(int i=1;i<10;i++) {
			arr[1][i]=1;
		}
		for(int i=2;i<=input;i++) {
			for(int j=0;j<10;j++) {
				arr[i][j]=0;
				if(j-1>=0) {
					arr[i][j] += arr[i-1][j-1];
				}
				if(j+1<=9) {
					arr[i][j] +=arr[i-1][j+1];
				}
				arr[i][j] %= mod;
			}
		}
		long sum=0;
		for(int i =0;i<10;i++) {
			sum+=arr[input][i];
		}
		sum%=mod;
		System.out.println(sum);
		
	}

}
