package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//class Pair{
//	int x;
//	int y;
//	Pair(int x, int y){
//		this.x=x;
//		this.y=y;
//	}
//}
public class B_16234 {
	static int N, L, R, sum, result,c;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Pair> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 0;
		while (true) {
			result++;
			int cnt = 1;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						list = new ArrayList<>();
						sum = 0;
						c=1;
						solve(i, j, cnt);
						cnt++;
						
						if(c>1) {
							for(int t=0;t<list.size();t++) {
								map[list.get(t).x][list.get(t).y]=sum/c;
							}
						}
					}
				}
			}
			if (--cnt == N * N) {
				result--;
				break;
			}

		}
		System.out.println(result);
	}

	static void solve(int x, int y, int cnt) {
		list.add(new Pair(x,y));
		sum += map[x][y];
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < N && 0 <= py && py < N) {
				if (!visited[px][py]) {
					int gap = Math.abs(map[x][y] - map[px][py]);
					if (L <= gap && gap <= R) {
						c++;
						solve(px, py, cnt);
					}
				}
			}
		}
	}
}
