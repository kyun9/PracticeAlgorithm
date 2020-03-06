package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair_ {
	int x;
	int y;
	int val;

	Pair_(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

}

public class B_15683 {
	static int N, M,result;
	static int[][] map;
	static ArrayList<Pair_> list;
	//북동남서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

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
				if (map[i][j] != 0) {
					if (map[i][j] != 6) {
						list.add(new Pair_(i, j, map[i][j]));
					}
				}
			}
		}
		result = Integer.MAX_VALUE;
		solve(0,map);
		System.out.println(result);
	}
	static void solve(int depth, int[][] map) {
		if(depth==list.size()) {
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
//					System.out.print(map[i][j]+" ");
					if(map[i][j]==0) {
						cnt++;
					}
				}
//				System.out.println();
			}
//			System.out.println();
			result = Math.min(result, cnt);
			return;
		}
		
		Pair_ p = list.get(depth);
		int val =p.val;
		int x = p.x;
		int y = p.y;
		
		switch(val) {
		case 1:
			for(int i=0;i<4;i++) {
				int[][] arr = copy(map);
				checkPoint(x,y,i,arr);
				solve(depth+1,arr);
			}
			break;
		case 2:
			for(int i=0;i<2;i++) {
				int[][] arr = copy(map);
				checkPoint(x,y,i,arr);
				checkPoint(x,y,i+2,arr);
				solve(depth+1,arr);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				int[][] arr = copy(map);
				checkPoint(x,y,i,arr);
				checkPoint(x,y,(i+1)%4,arr);
				solve(depth+1,arr);
            }
            break;
		case 4:
			for(int i=0;i<4;i++) {
				int[][] arr = copy(map);
				checkPoint(x,y,i,arr);
				checkPoint(x,y,(i+1)%4,arr);
				checkPoint(x,y,(i+2)%4,arr);
				solve(depth+1,arr);
			}
			break;
		case 5:
			int[][] arr = copy(map);
			checkPoint(x,y,0,arr);
			checkPoint(x,y,1,arr);
			checkPoint(x,y,2,arr);
			checkPoint(x,y,3,arr);
			solve(depth+1,arr);
			break;
		}
	}
	static void checkPoint(int x,int y,int d, int[][] arr) {
		switch(d) {
		case 0:
			for(int i = x-1;i>=0;i--) {
				if(map[i][y]==6) {
					break;
				}
				arr[i][y]=7;
			}
			break;
		case 1:
			for(int i=y+1;i<M;i++) {
				if(map[x][i]==6) {
					break;
				}
				arr[x][i]=7;
			}
			break;
		case 2:
			for(int i=x+1;i<N;i++) {
				if(map[i][y]==6) {
					break;
				}
				arr[i][y]=7;
			}
			break;
		case 3:
			for(int i=y-1;i>=0;i--) {
				if(map[x][i]==6) {
					break;
				}
				arr[x][i]=7;
			}
			break;
		}
		
	}
	static int[][] copy(int[][] map) {
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;
	}
}
