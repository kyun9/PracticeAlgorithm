package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14499 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] command;
	// 동서북남
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	// 주사위
	static int[] dice = new int[6];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		command = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

		solve();
	}

	static void solve() {
		// 맵에서의 지도 위치
		int[] diceLoc = new int[2];
		diceLoc[0] = x;
		diceLoc[1] = y;

		// 주사위 위,북,동
		int[] dicDice = new int[3];
		dicDice[0] = 0; // 위
		dicDice[1] = 1; // 북
		dicDice[2] = 2; // 동

		int tmp = 0;
		boolean flag = false;
		for (int i = 0; i < command.length; i++) {
			flag = false;
			int move = command[i];
			switch (move) {
			// 동쪽
			case 1:
				if (0 <= diceLoc[0] + dx[0] && diceLoc[0] + dx[0] < N && 0 <= diceLoc[1] + dy[0]
						&& diceLoc[1] + dy[0] < M) {
					diceLoc[0] += dx[0];
					diceLoc[1] += dy[0];

					tmp = dicDice[0];
					dicDice[0] = 5 - dicDice[2]; // 위
					dicDice[2] = tmp; // 동

					flag = true;
				}

				break;
			// 서쪽
			case 2:
				if (0 <= diceLoc[0] + dx[1] && diceLoc[0] + dx[1] < N && 0 <= diceLoc[1] + dy[1]
						&& diceLoc[1] + dy[1] < M) {
					diceLoc[0] += dx[1];
					diceLoc[1] += dy[1];

					tmp = dicDice[0];
					dicDice[0] = dicDice[2]; // 위
					dicDice[2] = 5 - tmp; // 동

					flag = true;
				}

				break;
			// 북쪽
			case 3:
				if (0 <= diceLoc[0] + dx[2] && diceLoc[0] + dx[2] < N && 0 <= diceLoc[1] + dy[2]
						&& diceLoc[1] + dy[2] < M) {
					diceLoc[0] += dx[2];
					diceLoc[1] += dy[2];

					tmp = dicDice[0];
					dicDice[0] = 5 - dicDice[1]; // 위
					dicDice[1] = tmp; // 북

					flag = true;
				}

				break;
			// 남쪽
			case 4:
				if (0 <= diceLoc[0] + dx[3] && diceLoc[0] + dx[3] < N && 0 <= diceLoc[1] + dy[3]
						&& diceLoc[1] + dy[3] < M) {
					diceLoc[0] += dx[3];
					diceLoc[1] += dy[3];

					tmp = dicDice[0];
					dicDice[0] = dicDice[1]; // 위
					dicDice[1] = 5 - tmp; // 북

					flag = true;
				}

				break;
			}

			if (flag) {
				if (map[diceLoc[0]][diceLoc[1]] == 0) {
					map[diceLoc[0]][diceLoc[1]] = dice[5 - dicDice[0]];
				} else {
					dice[5 - dicDice[0]] = map[diceLoc[0]][diceLoc[1]];
					map[diceLoc[0]][diceLoc[1]] = 0;
				}
				System.out.println(dice[dicDice[0]]);
			}
		}
	}

}
