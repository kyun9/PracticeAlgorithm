package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1799 {
	static int size;
	static int[][] map;
	static boolean[][] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		
		map= new int[size][size];
		check = new boolean[size][size];
		StringTokenizer st;
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		int result=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(map[i][j]==1&&!check[i][j]) {
					check[i][j]=true;
					solve(i,j);
					System.out.println("i:"+i+" j: "+j);
					result++;
				}
			}
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(check[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(result);
	}
	static void solve(int x, int y) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if((x-y)==(i-j)) {
					check[i][j]=true;
				}
				if((x+y)==(i+j)) {
					check[i][j]=true;
				}
			}
		}
	}
}
