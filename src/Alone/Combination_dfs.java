package Alone;

public class Combination_dfs {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		boolean[] visited = new boolean[arr.length];
		
		//조합 arr.length 길이에서 2개
		comb(arr,visited,0,arr.length,2);
	}
	static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
		if(r==0) {
			for(int i=0;i<n;i++) {
				if(visited[i]==true) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		if(depth==n) {
			return;
		}
		visited[depth]=true;
		comb(arr, visited, depth+1,n,r-1);
		visited[depth]=false;
		comb(arr,visited,depth+1,n,r);
	}
}
