package B_Study;

import java.util.Scanner;

public class B_11048 {
	static int N, M;
	static int[][] map;
	static int[][] copy;
	static int[] dx = { -1, 0, -1 };
	static int[] dy = { 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		copy[0][0] = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int x = i;
				int y = j;
				for (int k = 0; k < 3; k++) {
					int px = x + dx[k];
					int py = y + dy[k];
					if (0 <= px && px < N && 0 <= py && py < M) {
						int tmp = copy[px][py] + map[i][j];
						copy[x][y] = Math.max(copy[x][y], tmp);
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}

		
		System.out.println(copy[N-1][M-1]);
	}

}
