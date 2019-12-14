package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//시간초과
public class S_6731_self {
	static char[][] map= new char[1001][1001];
	static int N;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int a = 1; a < T + 1; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			int[][] countBlackMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 0;
					countBlack(i, j);
					countBlackMap[i][j] = count % 2;
				}
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (countBlackMap[i][j] == 1) {
						result++;
					}
				}
			}

			System.out.println("#" + a + " " + result);
		}
		br.close();
	}

	static void countBlack(int x, int y) {
		if (map[x][y] == 'B') {
			count++;
		}
		for (int i = 0; i < N; i++) {
			if (i != y && map[x][i] == 'B') {
			}
			if (i != x && map[i][y] == 'B') {
				count++;
			}
		}
	}

}
