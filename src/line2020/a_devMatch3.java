package line2020;

public class a_devMatch3 {
	static int result;
	public static void main(String[] args) {
		int[] numbers = {10, 40, 30, 20};
		int K =20;
		int[] numbers1 = {3, 7, 2, 8, 6, 4, 5, 1};
		int K1 =3;
		int[] numbers2 = {1,10};
		int K2 =15;
//		System.out.println(solution(numbers, K));
//		System.out.println(solution(numbers1, K1));
		System.out.println(solution(numbers2, K2));
	}
	static public int solution(int[] numbers, int K) {
        int answer = 0;
        
        int n=numbers.length;
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
	
		result = Integer.MAX_VALUE;
		perm(numbers, output, visited,0,n,n, K);
		
		if(result==Integer.MAX_VALUE) {
			return -1;
		}
		answer = result;
        return answer;
    }
	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, int K) {
		if(depth ==r) {
			if(checkGap(output,K)) {
				int nSwap = checkSwap(output, arr);
				result= Math.min(result, nSwap);
			}
			return;
		}
	 
	    for(int i=0; i<n; i++) {
	        if(visited[i] != true) {
	            visited[i] = true;
	            output[depth] = arr[i];
	            perm(arr, output, visited, depth + 1, n, r,K);       
	            visited[i] = false;;
	        }
	    }
	}
	static int checkSwap(int[] output, int[] arr) {
		int cnt=0;
		for(int i=0;i<arr.length;i++) {
			if(output[i]!=arr[i]) {
				cnt++;
			}
		}
		return (int)Math.ceil((float)cnt/2);
	}
	
	static boolean checkGap(int[] output, int K) {
		for(int i=1;i<output.length;i++) {
			if(Math.abs(output[i]-output[i-1])>K) {
				return false;
			}
		}
		return true;
	}
}
