package StudyAlgorithm_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class S_6855 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test < T + 1; test++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int result = 0;

			int[] houses = new int[N];
			int[] gap = new int[N - 1];
			for (int i = 0; i < N; i++) {
				houses[i] = sc.nextInt();
			}
			if (K >= N) {
				result = 0;
			} else {
				for (int i = 1; i < N; i++) {
					gap[i - 1] = houses[i] - houses[i - 1];
				}

				Arrays.sort(gap);

				for (int i = 0; i < gap.length - K + 1; i++) {
					result += gap[i];
				}

			}

			System.out.println("#" + test + " " + result);
		}
	}

}
