package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_홈방범서비스_2117 {
	static int T, N, M, result;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine().trim());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solve(i, j);
				}
			}

			System.out.println("#" + test + " " + result);
		}
	}

	static void solve(int x, int y) {
		int K = 1, cost, house, profit;
		boolean[][] check;	//마름모가 확장되서 지도의 모서리를 체크하기 위한 이차원배열
		while (true) {
			check = new boolean[N][N];
			house = 0;
			profit = 0;
			cost = (K * K) + (K - 1) * (K - 1);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(x - i) + Math.abs(y - j) < K) {
						check[i][j] = true;					//마름모 범위내를 체크함
						if (map[i][j] == 1) {
							house++;								//마름모 범위안에 집이 있으면 house증가
						}
					}
				}
			}

			profit = (house * M) - cost;				//이익 계산
			if (profit >= 0) {									// 손해를 보지않을때
				result = Math.max(result, house);	// 집이 더 많은 것으로 갱신
			}

			if (check[0][0] && check[0][N - 1] && check[N - 1][0] && check[N - 1][N - 1]) {		//마름모 확장되어 지도를 전부 덮을때 종료
				break;
			}

			K++;
		}
	}
}
