package Alone;

public class Permutation_Last {

	public static void main(String[] args) {
		int n=3;
		int[] arr = {1,2,3};
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		
		System.out.println("visited 배열 사용 permutation");
		perm(arr, output, visited,0,n,3);
		System.out.println();
		System.out.println("swap 함수를 사용한 permutation");
		permutation(arr,0,n,3);
	}
	
	static void permutation(int[] arr, int depth, int n, int r) {
		if(depth==r) {
			print(arr,r);
			return;
		}
		for(int i=depth;i<n;i++) {
			swap(arr,depth,i);
			permutation(arr,depth+1,n,r);
			swap(arr,depth,i);
		}
	}
	
	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth]= arr[i];
		arr[i]= temp;
	}
	
	
	
	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if(depth ==r) {
			print(output, r);
			return;
		}
		for(int i=0;i<n;i++) {
			
			/*************************************** 

			여기서 visited 배열을 사용하지 않으면 중복 순열이 가능하다
					
			 *******************************************/

			if(!visited[i]) {
				visited[i]=true;
				output[depth]=arr[i];
				perm(arr,output,visited,depth+1,n,r);
				visited[i]=false;
			}
		}
	}
	
	static void print(int[] arr, int r) {
		for(int i=0;i<r;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
