package B_Study;

import java.util.Arrays;
import java.util.Scanner;

public class B_15656 {
	static int[] nums = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		String s ="";
		dfs(0, N, M, arr,s);
	}

	static void dfs(int depth, int n, int m, int[] arr,String s) {
		if(depth == m) {
			System.out.println(s);
			return;
		}
		for(int i=0;i<arr.length;i++) {
			nums[depth]= arr[i];
			if(s.equals("")) {
				dfs(depth+1,n,m,arr,s+nums[depth]);
			}
			else {
				dfs(depth+1,n,m,arr,s+" "+nums[depth]);
			}
		}
	}
}
