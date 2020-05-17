package coding_2020;

public class kakao_Internship4 {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println(solution(board));
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int N, result;

	static public int solution(int[][] board) {
		int answer = 0;

		N = board.length;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = board[i][j];
			}
		}
		boolean[][] visited = new boolean[N][N];

		result = Integer.MAX_VALUE;
		visited[0][0] = true;
		dfs(visited, 0, 0, 9, 0);

		answer = result;
		return answer;
	}

	static void dfs(boolean[][] visited, int x, int y, int dic, int sum) {
		if (x == N - 1 && y == N - 1) {
			result = Math.min(result, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < N && 0 <= py && py < N) {
				if (!visited[px][py] && map[px][py] == 0) {
					int cost = 0;
					if (dic == i || dic == 9) {
						cost = 100;
					} else {
						cost = 600;
					}
					sum += cost;
					if (sum >= result) {
						sum -= cost;
						continue;
					}
					visited[px][py] = true;
					dfs(visited, px, py, i, sum);
					sum -= cost;
					visited[px][py] = false;
				}
			}
		}
	}
}
