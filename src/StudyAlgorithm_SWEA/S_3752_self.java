package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S_3752_self {
	static HashSet<Integer> hs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int a = 1; a < T + 1; a++) {

			int N = Integer.valueOf(br.readLine());

			String[] line = br.readLine().split(" ");
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.valueOf(line[i]);
			}
			hs = new HashSet<>();

			for (int i = 1; i < N + 1; i++) {
				int[] result = new int[i];
				perm(arr, result, 0, i);
			}
			System.out.println("#" + a + " " + (hs.size() + 1));
		}

	}

	static void perm(int[] arr, int[] result, int depth, int N) {
		if (depth == N) {
			int sum = 0;
			for (int i : result) {
				sum += i;
			}
			if (!hs.contains(sum)) {
				hs.add(sum);
			} else {
				return;
			}
			return;
		}
		for (int i = depth; i < arr.length; i++) {
			swap(arr, i, depth);
			result[depth] = arr[depth];
			perm(arr, result, depth + 1, N);
			swap(arr, i, depth);
		}
	}

	static void swap(int[] arr, int i, int depth) {
		int tmp = arr[i];
		arr[i] = arr[depth];
		arr[depth] = tmp;
	}

}
