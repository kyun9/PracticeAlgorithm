package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_퇴사_14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());

		// N+10 을 해준 이유는 마지막날 + 5일일 때 배열 에러가 날 수 있으므로 넉넉히 잡아준다.
		int[] T = new int[N + 10];
		int[] P = new int[N + 10];
		int[] dp = new int[N + 10];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		// ------------입력부------------//

		for (int i = 1; i <= N + 1; i++) {
			// 이전까지의 최대 수입을 비교해서 최대 수입을 현재에도 저장해준다.
			// 이전에 최대수입이 났을 수 있으므로
			// ex) 3,7,(5 예상) 이라고 하면 5의 값은 7로 바꿔주는게 최대수입을 얻는데 맞다.
			dp[i] = Math.max(dp[i], max);
			// 이전에 저장된 최대수익 vs 이번 움직임으로 생긴 최대 수익
			dp[T[i] + i] = Math.max(dp[T[i] + i], P[i] + dp[i]);
			// 출력될 최대 수입
			max = Math.max(max, dp[i]);
			System.out.println(" i : "+ i + " dp[i] : "+  dp[i] + " [T[i]+i] : "+(T[i]+i)+ " dp[T[i]+i] : " + dp[T[i]+i] + " P[i]+dp[i] : "+ (P[i]+dp[i]));
			System.out.println();
		}
		
		for(int i=1; i<N+1;i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
		System.out.println(max);
	}
}
