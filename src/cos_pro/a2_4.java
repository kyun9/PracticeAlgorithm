package cos_pro;

public class a2_4 {
	public static int solution(int[] arr, int K) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;
		boolean[] visited = new boolean[arr.length];

		comb(arr.length, K, 0, arr, visited);

		answer = result;
		return answer;
	}

	static int result = 0;

	static void comb(int n, int r, int depth, int[] arr, boolean[] visited) {
		if (r == 0) {
			print(arr, visited);
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			if (sum % 3 == 0) {
				result++;
			}
			return;
		}
		if (n == depth) {
			return;
		}
		visited[depth] = true;
		comb(n, r - 1, depth + 1, arr, visited);
		visited[depth] = false;
		comb(n, r, depth + 1, arr, visited);
	}

	static void print(int[] arr, boolean[] visited) {
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				System.out.print(arr[i] + "\t");
			}
		}
		System.out.println();
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int K = 3;
		int ret = solution(arr, K);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}
}
