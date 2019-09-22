package B_Study;

import java.util.Scanner;

public class B_DP_add_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[11];
		
		arr[0]=1;
		for(int i=1;i<11;i++) {
			for(int j=1;j<4;j++) {
				if(i-j>=0) {
					arr[i]+=arr[i-j];
				}
			}
		}
		
		int n=sc.nextInt();
		while(n-->0) {
			int val=sc.nextInt();
			System.out.println(arr[val]);
		}
		
		
	}

}
