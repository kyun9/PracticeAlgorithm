package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_사다리조작_15684 {
	private static int n, m, h, answer;
	private static int[][] map;
	private static boolean finish = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		// 인덱스를 맞추기위해서 (값이 1부터 시작함으로) 이차원 배열 +1를 해줌
		map = new int[h + 1][n + 1];
		int x, y;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[x][y + 1] = 2;
		}
//		print();
		// 추가 갯수
		for (int i = 0; i <= 3; i++) {
			// answer은 최종 깊이를 의미
			answer = i;
			// 탐색 시작
			dfs(1, 0);
			// 제일 작은 값 리턴이니까 바로 break;
			if (finish)
				break;
		}
		System.out.println((finish) ? answer : -1);
	}

//	static void print() {
//		for (int i = 0; i < h + 1; i++) {
//			for (int j = 0; j < n + 1; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	private static void dfs(int x, int count) {
		// 만일 하나를 추가했을때 맞았다면 전부 종료
		if (finish)
			return;
		// 깊이까지 전부 탐색하였을 때
		if (answer == count) {
			// check 이게 원하는 값까지 들어갔는 지 확인
			if (check())
				// finish를 true로 바꿔 주며 dfs 종료
				finish = true;
			return;
		}

		// 전체 맵 탐색하는데 j는 n+1를 계산하기위해 범위는 -1 적은 n 까지의 범위로 이중for문
		for (int i = x; i < h + 1; i++) {
			for (int j = 1; j < n; j++) {
				// 양 옆이 0일때 선 긋기
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = 2;
					// 재귀
					dfs(i, count + 1);
					// 재귀후 다시 원래 값으로 초기화
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		}
	}

	// 선 연결후 동일한 세로값인지 확인
	private static boolean check() {
		for (int i = 1; i <= n; i++) {
			int x = 1, y = i;
			for (int j = 0; j < h; j++) {
				// 1이면 오르쪽으로
				if (map[x][y] == 1)
					y++;
				// 2이면 왼쪽으로
				else if (map[x][y] == 2)
					y--;
				// 아래로
				x++;
			}
			// 같지 않다면 false 졸료
			if (y != i)
				return false;
		}
		return true;
	}

}
