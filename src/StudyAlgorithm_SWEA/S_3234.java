package StudyAlgorithm_SWEA;

import java.util.Scanner;

public class S_3234 {
	static int count;
	static int[] chu;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test = 1; test < T + 1; test++) {
			int N = sc.nextInt();
			chu = new int[N];
			for (int i = 0; i < N; i++) {
				chu[i] = sc.nextInt();
			}

			count = 0;
			perm(0, 0, 0);
			System.out.println("#" + test + " " + count);
		}

	}

	static void perm(int depth, int left, int right) {
		if (chu.length == depth) {
			count++;
			return;
		}
		for (int i = depth; i < chu.length; i++) {
			swap(depth, i);
			perm(depth + 1, left + chu[depth], right);
			//탐색
			if (left >= right + chu[depth]) {
				perm(depth + 1, left, right + chu[depth]);
			}
			swap(depth, i);
		}
	}

	static void swap(int depth, int i) {
		int temp = chu[depth];
		chu[depth] = chu[i];
		chu[i] = temp;
	}
}
