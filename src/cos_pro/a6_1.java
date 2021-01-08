package cos_pro;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.LinkedList;
import java.util.Queue;

class Pair44 {
	int x;
	int y;
	int cnt;

	Pair44(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

class a6_1 {

	// 북동남서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static int solution(int n, int[][] garden) {
		int answer = 0;
		int[][] result = new int[n][n];

		if (!check(garden, n)) {
			Queue<Pair44> qu = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (garden[i][j] == 1) {
						qu.add(new Pair44(i, j, 0));
						visited[i][j] = true;
					}
				}
			}

			while (!qu.isEmpty()) {
				Pair44 p = qu.poll();
				for (int i = 0; i < 4; i++) {
					int x = p.x + dx[i];
					int y = p.y + dy[i];

					if (isPossible(x, y, n)) {
						if (!visited[x][y]) {
							visited[x][y] = true;
							result[x][y] = p.cnt + 1;
							qu.add(new Pair44(x, y, p.cnt + 1));
						}
					}
				}
			}
			answer = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					answer = Math.max(answer, result[i][j]);
				}
			}
		}

		print(result, n);
		return answer;
	}

	static void print(int[][] garden, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(garden[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static boolean isPossible(int x, int y, int n) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		} else {
			return false;
		}
	}

	static boolean check(int[][] garden, int n) {
		boolean check = true;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (garden[i][j] == 0) {
					check = false;
					return check;
				} else {
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			check = false;
		}
		return check;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int n1 = 3;
		int[][] garden1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int ret1 = solution(n1, garden1);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		int n2 = 2;
		int[][] garden2 = { { 1, 1 }, { 1, 1 } };
		int ret2 = solution(n2, garden2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

	}
}