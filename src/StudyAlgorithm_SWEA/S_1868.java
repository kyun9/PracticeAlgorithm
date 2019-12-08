package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_1868 {
	static char[][] map;
	static int[][] copy;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int N;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.valueOf(br.readLine());
//		
//		for(int a=1;a<T+1;a++) {
		N = Integer.valueOf(br.readLine());
		
		map = new char[N][N];
		copy= new int[N][N];
		
		for(int i=0;i<N;i++) {
			map[i]= br.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='.') {
					solve(i,j);
				}
			}
		}
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
		
//			System.out.println("#"+a);
//		}
	}
	
	static void solve(int a, int b) {
		
		int count=0;
		
		for(int i=0;i<8;i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			
			if(0<=x&&x<N&&0<=y&&y<N) {
				if(map[x][y]=='*') {
					count++;
				}
			}
		}
		map[a][b]=(char)(count + '0');
	}
}
