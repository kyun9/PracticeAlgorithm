package review_2020_winter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S_1249 {
	static int T, N;
	static int[][] map;
	static int[][] distance;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				Arrays.fill(distance[i], Integer.MAX_VALUE);
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);
				}
			});
			
			pq.offer(new int[] {0,0,0});
			while(!pq.isEmpty()) {
				int[] temp = pq.poll();
				
				for(int i=0;i<4;i++) {
					int x = temp[0]+dx[i];
					int y = temp[1]+dy[i];
					
					if(0<=x&&x<N&&0<=y&&y<N) {
						int weight = temp[2]+map[x][y];
						if(weight<distance[x][y]) {
							distance[x][y]=weight;
							pq.offer(new int[] {x,y,distance[x][y]});
						}
					}
				}
			}

			System.out.println("#" + test + " " + distance[N - 1][N - 1]);
		}
	}

}
