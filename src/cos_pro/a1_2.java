package cos_pro;

public class a1_2 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;

	public static int solution(int n) {
		int answer = 0;

		arr = new int[n][n];
		arr[0][0] = 1;

		solve(0, 0, n);
		
		print(arr);
		
		for(int i=0;i<n;i++) {
			answer += arr[i][i];
		}
		return answer;
	}

	static void solve(int a, int b, int n) {
		for (int i = 0; i < 4; i++) {
			int px = a + dx[i];
			int py = b + dy[i];
			if (0 <= px && px < n && 0 <= py && py < n && arr[px][py] == 0) {
				arr[px][py] = arr[a][b] + 1;
				solve(px, py, n);
			}
		}
	}

	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		int n1 = 3;
		int ret1 = solution(n1);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret1 + " .");

		int n2 = 2;
		int ret2 = solution(n2);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret2 + " .");
	}
}
