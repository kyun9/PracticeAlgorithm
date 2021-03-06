package B_Study;

import java.util.Arrays;
import java.util.Scanner;

public class B_15655 {
	static int[] nums = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]= sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0,N,M, arr);
	}
	static void dfs(int depth, int N, int M, int[] arr) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<arr.length;i++) {
			nums[depth]= arr[i];
			if(depth ==0) {
				dfs(depth+1,N,M,arr);
			}
			if(depth>0&&nums[depth]>nums[depth-1]) {
				dfs(depth+1,N,M,arr);
			}
		}
	}
}
