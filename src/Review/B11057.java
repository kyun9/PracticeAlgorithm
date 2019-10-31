package Review;

import java.util.Scanner;

public class B11057 {
	static int mod =10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		int[][] arr = new int[n+1][10];
		for(int i=0;i<10;i++) {
			arr[1][i]=1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<10;k++) {
					if(j<=k) {
						arr[i][j]+=arr[i-1][k];
					}
				}
				arr[i][j]%=mod;
			}
		}
		
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=arr[n][i];
		}
		sum%=mod;
		System.out.println(sum);
	}

}
