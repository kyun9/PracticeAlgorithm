package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_DP_9465_self {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(bf.readLine());
		while (t-- > 0) {
			int n = Integer.valueOf(bf.readLine());
			long[][] arr = new long[n + 1][2];

			String[] s = bf.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				arr[i][0] = Long.valueOf(s[i - 1]);
			}

			s = bf.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				arr[i][1] = Long.valueOf(s[i - 1]);
			}

			long[][] temp = new long[n + 1][3];
			for (int i = 1; i <= n; i++) {
				temp[i][0] = Math.max(temp[i-1][0], Math.max(temp[i-1][1], temp[i-1][2]));
				temp[i][1] = Math.max(temp[i-1][0], temp[i-1][2]) + arr[i][0];
				temp[i][2] = Math.max(temp[i-1][0], temp[i-1][1]) + arr[i][1];
			}

			long result = Math.max(temp[n][0], Math.max(temp[n][1], temp[n][2]));
			System.out.println(result);
		}
	}

}
