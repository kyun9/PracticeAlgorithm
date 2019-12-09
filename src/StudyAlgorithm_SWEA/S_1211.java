package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class b implements Comparable<b> {
	int x;
	int count;

	b(int x, int count) {
		this.x = x;
		this.count = count;
	}

	@Override
	public int compareTo(b o) {
		return o.count >= this.count ? -1 : 1;
	}

}

public class S_1211 {
	static int size = 100;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<b> list;
	// 왼쪽 오른쪽 아래
	static int[] dx = { 0, 0, 1 };
	static int[] dy = { -1, 1, 0 };
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int a = 1; a < 11; a++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[size][size];
			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.valueOf(line[j]);
				}
			}

			list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				visited = new boolean[size][size];
				count = 0;
				if (map[0][i] == 1) {
					dfs(0, i);
					list.add(new b(i, count));
				}
			}

			Collections.sort(list);
			System.out.println("#" + N + " " + list.get(0).x);
		}
	}

	static void dfs(int a, int b) {
		if (visited[a][b]) {
			return;
		}

		visited[a][b] = true;
		for (int i = 0; i < 3; i++) {
			int x = a + dx[i];
			int y = b + dy[i];

			if (0 <= x && x < size && 0 <= y && y < size) {
				if (map[x][y] == 1 && !visited[x][y]) {
					count++;
					dfs(x, y);
					return;
				}
			}
		}

	}

}
