package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bead {
	int rx;
	int ry;
	int bx;
	int by;
	int cnt;

	Bead() {

	}

	Bead(int rx, int ry, int bx, int by, int cnt) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

public class 백준_구슬탈출2_13460 {
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	// 북동남서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		Bead bead = new Bead();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					bead.rx = i;
					bead.ry = j;
				} else if (map[i][j] == 'B') {
					bead.bx = i;
					bead.by = j;
				}
			}
		}

		bead.cnt = 0;

		bfs(bead);

	}

	static void bfs(Bead ball) {
		Queue<Bead> q = new LinkedList<>();
		q.offer(ball);

		while (!q.isEmpty()) {
			Bead bead = q.poll();
			visited[bead.rx][bead.ry][bead.bx][bead.by] = true;

			if (bead.cnt >= 10) {
				System.out.println(-1);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int rx = bead.rx;
				int ry = bead.ry;

				while (map[rx + dx[i]][ry + dy[i]] != '#') {
					rx += dx[i];
					ry += dy[i];
					if (map[rx][ry] == 'O') {
						break;
					}
				}

				int bx = bead.bx;
				int by = bead.by;

				while (map[bx + dx[i]][by + dy[i]] != '#') {
					bx += dx[i];
					by += dy[i];
					if (map[bx][by] == 'O') {
						break;
					}
				}

				if (map[bx][by] == 'O') {
					continue;
				}
				if (map[rx][ry] == 'O') {
					System.out.println(bead.cnt + 1);
					return;
				}

				if (rx == bx && ry == by) {
					switch (i) {
					case 0:
						if (bead.rx < bead.bx) {
							bx += 1;
						} else {
							rx += 1;
						}
						break;
					case 1:
						if (bead.ry < bead.by) {
							ry -= 1;
						} else {
							by -= 1;
						}
						break;
					case 2:
						if (bead.rx < bead.bx) {
							rx -= 1;
						} else {
							bx -= 1;
						}
						break;
					case 3:
						if (bead.ry < bead.by) {
							by += 1;
						} else {
							ry += 1;
						}
						break;
					}
				}
				
				if(!visited[rx][ry][bx][by]) {
					q.offer(new Bead(rx,ry,bx,by,bead.cnt+1));
				}
			}

		}
		System.out.println(-1);
	}
}
