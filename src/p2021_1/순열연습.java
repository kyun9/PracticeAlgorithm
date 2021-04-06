package p2021_1;

public class 순열연습 {

	public static void main(String[] args) {
		int n = 3; // 3가지 숫자 중
		int r = 2; // 2개를 뽑을 경우
		int[] input = { 1, 2, 3 }; // 주어진 3가지 숫자
		int[] answer = new int[r]; // 정답을 담을 배열
		boolean[] check = new boolean[n]; // 해당 숫자를 방문했는지 체크

		// 순열
		permutation(n, r, input, check, answer, 0);
		// 중복순열
		permutationDup(n, r, input, answer, 0);
	}

	public static void permutation(int n, int r, int[] input, boolean[] check, int[] answer, int depth) {
		if (depth == r) {
			print(answer);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true; // 중복 체크
				answer[depth] = input[i];
				permutation(n, r, input, check, answer, depth + 1);
				check[i] = false;
			}
		}
	}

	public static void permutationDup(int n, int r, int[] input, int[] answer, int depth) {
		if (depth == r) {
			print(answer);
			return;
		}

		for (int i = 0; i < n; i++) {
			answer[depth] = input[i];
			permutationDup(n, r, input, answer, depth + 1);
		}
	}

	public static void print(int[] answer) {
		for (Integer ans : answer) {
			System.out.print(ans + " ");
		}
		System.out.println();
	}
}
