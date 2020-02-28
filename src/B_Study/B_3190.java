package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair7 {
	int x;
	int y;
	int d;

	Pair7(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

class Move2 {
	int time;
	String d;

	Move2(int time, String d) {
		this.time = time;
		this.d = d;
	}
}

public class B_3190 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static ArrayList<Pair7> snake;
	static int N, time;
	static Queue<Move2> qu;

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

//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		int M = Integer.parseInt(br.readLine().trim());
		qu = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			qu.add(new Move2(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		snake = new ArrayList<>();
		snake.add(new Pair7(0, 0, 1));
		time = 1;
		solve(0, 0, 1);

		System.out.println(time);
	}

	static void solve(int x, int y, int d) {
		int px = x;
		int py = y;
		int dic = d;
		// 반복 실행
		while (true) {
			px = px + dx[dic];
			py = py + dy[dic];
//			System.out.println("px : " + px + " py : " + py + " dic : " + dic + " time " + time);
			// map에서 안벗어 날때
			if (0 <= px && px < N && 0 <= py && py < N) {
				// 뱀 자신의 몸에 부딪쳤을 때
				for (int i = 0; i < snake.size(); i++) {
					if (snake.get(i).x == px && snake.get(i).y == py) {
						return;
					}
				}

				// qu의 시간초와 같을 때 회전
				if (!qu.isEmpty()) {
					if (qu.peek().time == time) {
						// 우회전
						if (qu.peek().d.equals("D")) {
							dic += 1;
							if (dic == 4) {
								dic = 0;
							}
						} else { // 좌회전
							dic -= 1;
							if (dic == -1) {
								dic = 3;
							}
						}
						qu.poll();
					}
				}
				// 사과를 만났을 때
				// 뱀 꼬리 증가
				if (map[px][py] == 1) {
					map[px][py] = 0;
					snake.add(new Pair7(px, py, dic));
				} else { // 사과를 만나지 않았을 때
							// 뱀이동
					snake.add(new Pair7(px, py, dic));
					snake.remove(0);
				}
				time++;
			}
			// map에서 벗어날 때
			else {
				return;
			}
		}

	}
}
