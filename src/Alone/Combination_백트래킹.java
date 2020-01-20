package Alone;

public class Combination_백트래킹 {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		boolean[] visited= new boolean[arr.length];
		
		
		
		//(조합 : arr.length개에서 2개를 이루는 조합)
		combination(arr,visited,0,arr.length,2);
	}
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
        	for(int i=0;i<n;i++) {
				if(visited[i]==true) {
					System.out.print(arr[i]+" ");
				}
			}
        	System.out.println();
			return;
        } else {
            for(int i=start; i<n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
