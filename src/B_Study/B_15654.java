package B_Study;

import java.util.Arrays;
import java.util.Scanner;

public class B_15654 {
	static int[] nums = new int[10];
	static boolean[] check = new boolean[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0, N, M, arr);
	}

	static void dfs(int depth, int n, int m, int[] arr) {
		if (depth == m) {
			for(int i=0;i<m;i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			if(check[i]) continue;
			check[i]= true;
			nums[depth]= arr[i];
			dfs(depth+1,n,m,arr);
			check[i]=false;
		}
	}
}
