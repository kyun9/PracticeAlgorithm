package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B_15685 {
	static int N,result;
	static boolean[][] visited = new boolean[101][101];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		StringTokenizer st;
		ArrayList<Integer> list;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			visited[x][y] = true;
			list = new ArrayList<>();
			list.add(d);
			int cnt = 1;
			while (cnt <= g) {
				for (int j = list.size() - 1; j >= 0; j--) {
					int n = list.get(j) + 1;
					if (n == 4) {
						n = 0;
					}
					list.add(n);
				}
				cnt++;
			}
			for (int j = 0; j < list.size(); j++) {
				x += dx[list.get(j)];
				y += dy[list.get(j)];
				visited[x][y] = true;
			}
		}

		result=0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (visited[i][j]) {
					if(visited[i+1][j]&&visited[i][j+1]&&visited[i+1][j+1]) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}

}
