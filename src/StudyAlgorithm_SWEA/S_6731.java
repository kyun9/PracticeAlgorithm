package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_6731 {
	static char[][] map = new char[1001][1001];
	static int N;
	static int count;
	static int[] garo;
	static int[] sero;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int a = 1; a < T + 1; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			int[][] countBlackMap = new int[N][N];
			garo = new int[N];
			sero = new int[N];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < line.length(); j++) {
					map[i][j] = line.charAt(j);
					if (line.charAt(j) == 'B') {
						garo[i]++;
						sero[j]++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 0;
					if (map[i][j] == 'B') {
						count = garo[i] + sero[j] - 1;
					} else {
						count = garo[i] + sero[j];
					}
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

}
