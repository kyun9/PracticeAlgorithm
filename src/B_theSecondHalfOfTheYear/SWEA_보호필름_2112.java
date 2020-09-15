package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_보호필름_2112 {
	static int T, D, W, K, result ;
	static int[][] films;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			films = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					films[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (K == 1) {
				result = 0;
			} else {
				result = Integer.MAX_VALUE;
				Injection(0, 0);
			}
			System.out.println("#" + test + " " + result);
		}
	}

	static void Injection(int idx, int inject) {
		if (inject >= result)
			return;

		if (idx >= D) {
			if (goCheck()) {
				result = Math.min(result, inject);
			}
			return;
		}

		Injection(idx + 1, inject);

		int[] tArr = new int[W];
		for (int i = 0; i < W; i++)
			tArr[i] = films[idx][i];

		for (int i = 0; i < W; i++)
			films[idx][i] = 0;
		Injection(idx + 1, inject + 1);

		for (int i = 0; i < W; i++)
			films[idx][i] = 1;
		Injection(idx + 1, inject + 1);

		for (int i = 0; i < W; i++)
			films[idx][i] = tArr[i];
	}

	static boolean goCheck() {
		for (int i = 0; i < W; i++) {
			int val = films[0][i];
			int cnt = 1;
			boolean check = false;
			for (int j = 1; j < D; j++) {
				if (films[j][i] == val) {
					cnt++;
					if (cnt == K) {
						check = true;
						break;
					}
				} else {
					val = films[j][i];
					cnt = 1;
				}
			}

			if (!check) {
				return false;
			}
		}

		return true;
	}

}
