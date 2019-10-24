package Review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B2178 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m= sc.nextInt();
		
		sc.nextLine();
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			for(int j=0;j<m;j++) {
				arr[i][j]= s.charAt(j)-'0';
			}
		}
		
		boolean[][] visited = new boolean[n][m];
		int[][] dist = new int[n][m];
		
		
		Queue<Pair> qu = new LinkedList<>();
		qu.add(new Pair(0,0));
		visited[0][0]=true;
		dist[0][0]=1;
		while(!qu.isEmpty()) {
			Pair p = qu.remove();
			for(int i=0;i<dx.length;i++) {
				int px = p.x+dx[i];
				int py = p.y+dy[i];
				if(0<=px&&px<n&&0<=py&&py<m) {
					if(visited[n][m]==false&&arr[px][py]==1) {
						qu.add(new Pair(px,py));
						visited[px][py]=true;
						dist[px][py]=dist[p.x][p.y]+1;
					}
				}
			}
		}
		System.out.println(dist[n-1][m-1]);
	}

}
