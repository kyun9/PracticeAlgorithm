package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_14500_self {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Pair111> output;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				output = new ArrayList<>();
				output.add(new Pair111(i, j, map[i][j]));
				visited = new boolean[N][M];
				visited[i][j] = true;
				dfs(i, j, 1);
			}
		}

		System.out.println(result);

	}

	static void dfs(int x, int y, int depth) {
		if (depth == 3) {
			moreDFS();
			return;
		}
		for (int j = 0; j < 4; j++) {
			int px = x + dx[j];
			int py = y + dy[j];
			if (0 <= px && px < N && 0 <= py && py < M) {
				if (!visited[px][py]) {
					visited[px][py] = true;
					output.add(new Pair111(px, py, map[px][py]));
					dfs(px, py, depth + 1);
					output.remove(output.size() - 1);
					visited[px][py] = false;
				}
			}
		}
	}

	static void moreDFS() {
		for (int i = 0; i < output.size(); i++) {
			for (int j = 0; j < 4; j++) {
				int px = output.get(i).x + dx[j];
				int py = output.get(i).y + dy[j];
				if (0 <= px && px < N && 0 <= py && py < M) {
					if (!visited[px][py]) {
						output.add(new Pair111(px, py, map[px][py]));
						checkSUM();
						output.remove(output.size() - 1);
					}
				}
			}
		}
	}

	static void checkSUM() {
		int sum = 0;
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i).val + " ");
			sum += output.get(i).val;
		}
		System.out.println();
		result = Math.max(result, sum);
	}
}
