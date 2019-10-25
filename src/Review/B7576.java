package Review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair2 {
	int x;
	int y;

	Pair2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B7576 {
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		Queue<Pair2> qu = new LinkedList<>();
		int[][] dist = new int[n][m];
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = -1;
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					qu.add(new Pair2(i, j));
					dist[i][j] = 0;
				}
			}
		}

		while (!qu.isEmpty()) {
			Pair2 p = qu.remove();
			for (int i = 0; i < dx.length; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				if (0 <= px && px < n && 0 <= py && py < m) {
					if (arr[px][py] == 0 && dist[px][py] == -1) {
						qu.add(new Pair2(px, py));
						dist[px][py] = dist[p.x][p.y] + 1;
					}
				}
			}
		}

		int result = 0;
		label: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (result < dist[i][j]) {
					result = dist[i][j];
				}
				if (dist[i][j] == -1 && arr[i][j] == 0) {
					result = -1;
					break label;
				}
			}
		}
		System.out.println(result);
	}

}
