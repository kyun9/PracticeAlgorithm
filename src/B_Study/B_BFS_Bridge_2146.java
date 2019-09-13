package B_Study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair3 {
	int x;
	int y;

	Pair3(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B_BFS_Bridge_2146 {

	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		int[][] arr = new int[size][size];
		int[][] group = new int[size][size];
		int[][] dist = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 1 && group[i][j] == 0) {
					Queue<Pair3> q = new LinkedList<>();
					group[i][j] = ++cnt;
					q.add(new Pair3(i, j));
					while (!q.isEmpty()) {
						Pair3 p = q.remove();
						for (int k = 0; k < 4; k++) {
							int x = p.x + dx[k];
							int y = p.y + dy[k];
							if (0 <= x && x < size && y >= 0 && y < size) {
								if (arr[x][y] == 1 && group[x][y] == 0) {
									q.add(new Pair3(x, y));
									group[x][y] = cnt;
								}
							}
						}
					}
				}
			}
		}

		Queue<Pair3> q = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				dist[i][j] = -1;
				if (arr[i][j] == 1) {
					q.add(new Pair3(i, j));
					dist[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			Pair3 p = q.remove();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (0 <= x && x < size && y >= 0 && y < size) {
					if (dist[x][y] == -1) {
						dist[x][y] = dist[p.x][p.y] + 1;
						group[x][y] = group[p.x][p.y];
						q.add(new Pair3(x, y));
					}
				}
			}
		}

		// 다른 확장시키다 경계부분의 distance 거리의 합을 구하면
		// 만들어야할 다리의 길이 값을 얻을 수 있다.
		int result = -1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (0 <= x && x < size && y >= 0 && y < size) {
						if (group[x][y] != group[i][j]) {
							if (result == -1 || result > dist[i][j] + dist[x][y]) {
								result = dist[i][j] + dist[x][y];
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);

	}

}
