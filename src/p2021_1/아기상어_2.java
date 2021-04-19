package p2021_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import p2021_1.아기상어.Node2;

public class 아기상어_2 {
	static class Fish2 implements Comparable<Fish2> {
		int x;
		int y;
		int cnt;

		Fish2(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Fish2 f) {
			if (this.x < f.x) {
				return -1;
			} else if (this.x == f.x) {
				if (this.y < f.y) {
					return -1;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}

	static int N;
	static int sharkX, sharkY, sharkSize, eatFish2, reault = 0;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static PriorityQueue<Fish2> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
				}
			}
		}

		map[sharkX][sharkY] = 0;
		sharkSize = 2;
		eatFish2 = 0;

		System.out.println(solve());
	}

	static int solve() {
		int time = 0;
		while (true) {
			searchFish2();

			if (pq.isEmpty()) {
				return time;
			}

			for (Fish2 f : pq) {
				System.out.println(f.x + " " + f.y + " " + f.cnt);
			}
			System.out.println();
			Fish2 fish = pq.poll();
			time += fish.cnt;
			map[sharkX][sharkY] = 0;
			sharkX = fish.x;
			sharkY = fish.y;
			eatFish2 += 1;

			if (eatFish2 == sharkSize) {
				sharkSize += 1;
				eatFish2 = 0;
			}

			pq.clear();
		}
	}

	static void searchFish2() {

		boolean[][] visited = new boolean[N][N];
		visited[sharkX][sharkY] = true;

		Queue<Fish2> q = new LinkedList<>();
		q.offer(new Fish2(sharkX, sharkY, 0));
		
		int dist = Integer.MAX_VALUE;
/* 
 * dist를 매우 큰 값으로 설정한 뒤

최초로 먹을 수 있는 물고기를 찾으면 dist 값을 갱신한다. 이 값은 BFS 탐색을 할 때, 해당 거리(dist) 만큼

벗어나지 않도록 하기 위함이다.
*/
		while (!q.isEmpty()) {
			Fish2 shark = q.poll();

			int cnt = shark.cnt;
			for (int i = 0; i < 4; i++) {
				int px = shark.x + dx[i];
				int py = shark.y + dy[i];

				if (isInside(px, py) && !visited[px][py] && cnt < dist) {
					if (0 < map[px][py] && map[px][py] < sharkSize) {
						dist = Math.min(dist, cnt + 1);								
						pq.offer(new Fish2(px, py, shark.cnt + 1));
						visited[px][py] = true;
					} else if (map[px][py] == sharkSize) {
						q.offer(new Fish2(px, py, shark.cnt + 1));
						visited[px][py] = true;
					} else if (map[px][py] == 0) {
						q.offer(new Fish2(px, py, shark.cnt + 1));
						visited[px][py] = true;
					}
				}
			}
		}
	}

	static boolean isInside(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < N);
	}

	static void print(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
