package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair6 {
	int x;
	int y;
	int d;

	Pair6(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

class Move {
	int time;
	String d;

	Move(int time, String d) {
		this.time = time;
		this.d = d;
	}
}

public class B_3190_self {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static ArrayList<Pair6> snake;
	static int N, time;
	static Queue<Move> qu;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		int K = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		int M = Integer.parseInt(br.readLine().trim());
		qu = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			qu.add(new Move(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		snake = new ArrayList<>();
		snake.add(new Pair6(0, 0, 1));
		time = 0;
		dfs(0, 0, 1);

		System.out.println(time);
	}

	static void dfs(int x, int y, int d) {
		System.out.println("x: " + x + " y: " + y);
		System.out.println("size" + snake.size());

		int dic = d;
		if (!qu.isEmpty()) {
			if (time == qu.peek().time) {
				if (qu.peek().d.equals("D")) {
					dic += 1;
					if (dic == 4) {
						dic = 0;
					}
				} else {
					dic -= 1;
					if (dic == -1) {
						dic = 3;
					}
				}
				qu.poll();
			}
		}

		int px = x + dx[dic];
		int py = y + dy[dic];
		if ((0 > px || px >= N) || (0 > py || py >= N)) {
			time++;
			return;
		} else {
			for (int i = 0; i < snake.size(); i++) {
				if (snake.get(i).x == px && snake.get(i).y == py) {
					time++;
					return;
				}
			}
			if (map[px][py] == 1) {
				snake.add(new Pair6(px, py, dic));
			} else {
				snake.add(new Pair6(px, py, dic));
				snake.remove(0);
			}
		}
		time++;
		System.out.println("time " + time);
		System.out.println("px: " + px + " py: " + py);
		System.out.println();
		dfs(px, py, dic);
	}
}



