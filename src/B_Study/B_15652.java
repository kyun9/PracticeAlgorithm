package B_Study;

import java.util.Scanner;

public class B_15652 {
	static int[] nums = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		dfs(0,N,M);
	}

	static void dfs(int depth, int n, int m) {
		if(depth==m) {
			for(int i =0;i<m;i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			nums[depth]=i;
			if(depth == 0) {
				dfs(depth+1,n,m);
			}
			if(depth>0&&nums[depth]>=nums[depth-1]) {
				dfs(depth+1,n,m);
			}
		}
	}
}
