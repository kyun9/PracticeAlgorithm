package B_Study;

import java.util.Scanner;

//dfs로 풀면 시간초과 DP로 접근하기
public class B_11048_self {
	static int N, M, val,result;
	static int[][] map;
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		result=0;
		val+=map[0][0];
		dfs(0, 0);
		System.out.println(result);
		sc.close();
	}

	static void dfs(int x,int y) {
		if(x==N-1&&y==M-1) {
			result=Math.max(result, val);
			return;
		}
		for(int i=0;i<3;i++) {
			int px = x+dx[i];
			int py = y+dy[i];
			
			if(0<=px&&px<N&&0<=py&&py<M) {
					val+=map[px][py];
					dfs(px,py);
					val-=map[px][py];
			}
		}
	}
}
