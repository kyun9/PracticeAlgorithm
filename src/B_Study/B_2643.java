package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2643 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int dp[][] = new int[1001][1001];
		int arr[][] = new int[1001][1001];
		int maxi = -1;
		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int big = t1 > t2 ? t1 : t2;	
			int small = t1 < t2 ? t1 : t2;
			arr[small][big]++;
			if (big > maxi)
				maxi = big;
		}
		int result = 0;
		for (int i = 1; i <= maxi; i++) {
			for (int j = i; j <= maxi; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
				if (result < dp[i][j])
					result = dp[i][j];
			}
		}
		System.out.println(result);
	}
}
