package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//class Pair{
//	int x;
//	int y;
//	
//	Pair(int x, int y){
//		this.x =x;
//		this.y = y;
//	}
//}

public class B_14502 {
	static int N, M, result;
	static int[][] map;
	static ArrayList<Pair> list;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new Pair(i, j));
				}
			}
		}

		boolean[] visited = new boolean[list.size()];
		result = 0;
		comb(0, list.size(), 3, visited);
		
		System.out.println(result);
	}

	static void comb(int depth, int n, int r, boolean[] visited) {
		if (r == 0) {
			Pair[] pp = new Pair[3];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					pp[cnt] = new Pair(list.get(i).x, list.get(i).y);
					cnt++;
				}
			}
			copyMap(pp);
			return;
		}
		if (depth == n)
			return;
		visited[depth] = true;
		comb(depth + 1, n, r - 1, visited);
		visited[depth] = false;
		comb(depth + 1, n, r, visited);
	}

	static void copyMap(Pair[] pp) {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j]=map[i][j];
			}
		}
		
		for (int i = 0; i < pp.length; i++) {
			temp[pp[i].x][pp[i].y] = 1;
		}
		
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 2) {
					check[i][j]=true;
					dfs(i, j,temp);
				}
			}
		}
		
		int sum=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j]==0) {
					sum+=1;
				}
			}
		}
		
		result = Math.max(result, sum);
		
	}

	static void dfs(int x, int y, int[][] temp) {
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < N && 0 <= py && py < M) {
				if(!check[px][py]&&temp[px][py]==0) {
					temp[px][py]=1;
					check[px][py]=true;
					dfs(px,py,temp);
				}
			}

		}
	}
}
