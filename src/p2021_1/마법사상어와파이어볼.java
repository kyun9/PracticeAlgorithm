package p2021_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼 {

	static class FireBall {
		int m;
		int s;
		int d;

		FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int N, M, K;
	static ArrayList<FireBall>[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[r][c].add(new FireBall(m, s, d));
		}

		for (int i = 0; i < K; i++)
			move();

		System.out.println(sum());
	}

	static void move() {
		ArrayList<FireBall>[][] temp = new ArrayList[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				temp[i][j] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() >= 1) {
					for (FireBall ball : map[i][j]) {
						int distance = ball.s % N;

						int x = i + dx[ball.d] * distance;
						int y = j + dy[ball.d] * distance;

						if (x >= N)
							x -= N;
						else if (x < 0)
							x += N;
						if (y >= N)
							y -= N;
						else if (y < 0)
							y += N;

						temp[x][y].add(new FireBall(ball.m, ball.s, ball.d));
					}
				}
			}
		}

		map = temp;
		split();
	}

	static void split() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() >= 2) {
					int mSum = 0, sSum = 0;
					boolean even = true, odd = true;

					for (FireBall ball : map[i][j]) {
						mSum += ball.m;
						sSum += ball.s;

						if (ball.d % 2 == 0)
							odd = false;
						else
							even = false;
					}

					int m = mSum / 5;
					int s = sSum / map[i][j].size();
					map[i][j].clear();

					if (m > 0) {
						if (odd || even) {
							map[i][j].add(new FireBall(m,  s, 0));
							map[i][j].add(new FireBall(m,  s, 2));
							map[i][j].add(new FireBall(m, s, 4));
							map[i][j].add(new FireBall(m, s, 6));
						} else {
							map[i][j].add(new FireBall(m, s, 1));
							map[i][j].add(new FireBall(m, s, 3));
							map[i][j].add(new FireBall(m, s, 5));
							map[i][j].add(new FireBall(m, s, 7));
						}
					}
				}
			}
		}
	}

	static long sum() {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (FireBall ball : map[i][j]) {
					sum += ball.m;
				}
			}
		}
		return sum;
	}

}
