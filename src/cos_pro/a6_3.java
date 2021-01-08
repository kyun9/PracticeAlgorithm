package cos_pro;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.ArrayList;
import java.util.Collections;

class a6_3 {
	public static int solution(int[] arr, int K) {
		int answer = 0;

		boolean[] visited = new boolean[arr.length];

		comb(arr.length, K, 0, arr, visited);

		answer = result;
		return answer;
	}

	static int result = Integer.MAX_VALUE;

	static void comb(int n, int r, int depth, int[] arr, boolean[] visited) {
		if (r == 0) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					list.add(arr[i]);
				}
			}
			Collections.sort(list);
			int gap = list.get(list.size() - 1) - list.get(0);
			result = Math.min(result, gap);
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

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int[] arr = { 9, 11, 9, 6, 4, 19 };
		int K = 4;
		int ret = solution(arr, K);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + "입니다.");
	}
}