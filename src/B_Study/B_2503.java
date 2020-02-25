package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2503 {

	static int[][] baseball;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		baseball = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				baseball[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] arr = new int[9];
		boolean[] visited = new boolean[9];
		int[] output = new int[3];
		for (int i = 1; i < 10; i++) {
			arr[i - 1] = i;
		}

		perm(arr, visited, output, 0, 9, 3);
		
		System.out.println(result);
	}

	static void perm(int[] arr, boolean[] visited, int[] output, int depth, int n, int r) {
		if (depth == r) {
			String s = "";
			for (int i : output) {
				s += i;
			}
			if(checkNum(s)) {
				result++;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, visited, output, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	static boolean checkNum(String s) {
		String[] ss = s.split("");
		for (int i = 0; i < baseball.length; i++) {
			String tmp = String.valueOf(baseball[i][0]);
			String[] sbase = tmp.split("");

			int strike = 0;
			for (int j = 0; j < 3; j++) {
				if (ss[j].equals(sbase[j])) {
					strike++;
				}
			}

			if (strike != baseball[i][1]) {
				return false;
			}

			int ball = 0;
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == k)
						continue;
					else if (ss[j].equals(sbase[k])) {
						ball++;
					}
				}
			}
			
			if(ball != baseball[i][2]) {
				return false;
			}
		}
		return true;
	}
}
