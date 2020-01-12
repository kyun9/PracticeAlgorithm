package B_Study;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class B_15666 {
	static int[] nums = new int[10];
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr =new int[N];
		for(int i=0;i<arr.length;i++) {
			arr[i]= sc.nextInt();
		}
		
		Arrays.sort(arr);
		dfs(0,N,M,arr,"");
		
		for(String s : set) {
			System.out.println(s);
		}
	}
	static void dfs(int depth, int n, int m, int[] arr, String s) {
		if(depth==m) {
			set.add(s);
			return;
		}
		for(int i=0;i<arr.length;i++) {
			nums[depth]=arr[i];
			if(depth==0) {
				dfs(depth+1,n,m,arr,s+nums[depth]+" ");
			}
			if(depth>0&&nums[depth]>=nums[depth-1]) {
				dfs(depth+1,n,m,arr,s+nums[depth]+" ");
			}
		}
	}
}
