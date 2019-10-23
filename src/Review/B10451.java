package Review;

import java.util.Scanner;

public class B10451 {
	static int count;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] result = new int[n];
		int val =0;
		
		while(n-->0) {
			int m= sc.nextInt();
			count=0;
			int[] arr = new int[m+1];
			visited = new boolean[m+1];
			for(int i=1;i<arr.length;i++) {
				arr[i]= sc.nextInt();
			}
			for(int i=1;i<arr.length;i++) {
				if(visited[i]==false) {
					dfs(arr,i);
				}
			}
			result[val++]=count;
		}
		for(int i : result) {
			System.out.println(i);
		}
		sc.close();
		
		
	}
	static void dfs(int[] arr , int i) {
		if(visited[i]==true) {
			count++;
			return;
		}
		visited[i]=true;
		dfs(arr,arr[i]);
	}
}
