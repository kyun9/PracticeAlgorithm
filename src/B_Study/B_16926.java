package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16926 {
	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			rotate();
		}
		print();
	}

	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void rotate() {
		int su = Math.min(N, M) / 2;

		for (int s = 0; s < su; s++) {
			int T = s;    //top
			int B = N - 1 - s; //bottom
			int R = M - 1 - s; //right
			int L = s; //left

			int tmp = map[s][s];
			for (int i = L; i < R; i++) map[T][i] = map[T][i + 1];
			for (int i = T; i < B; i++) map[i][R] = map[i + 1][R];
			for (int i = R; i > L; i--) map[B][i] = map[B][i - 1];
			for (int i = B; i > T; i--) map[i][L] = map[i - 1][L];
			map[T + 1][L] = tmp;
		}
	}

}
