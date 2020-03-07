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
public class B_15686 {
	static int N, M, result;
	static int[][] map;
	static ArrayList<Pair> chickenList;
	static ArrayList<Pair> houseList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chickenList = new ArrayList<>();
		houseList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chickenList.add(new Pair(i,j));
				}else if(map[i][j]==1) {
					houseList.add(new Pair(i,j));
				}
			}
		}

		boolean[] visited = new boolean[chickenList.size()];
		result = Integer.MAX_VALUE;
		comb(chickenList.size(),M,0,visited);
		System.out.println(result);
	}
	static void comb(int n, int r, int depth, boolean[] visited) {
		if(r==0) {
			int[] arr = new int[M];
			int cnt=0;
			for(int i=0;i<n;i++) {
				if(visited[i]) {
					arr[cnt]= i;
					cnt++;
				}
			}
			checkDistance(arr);
			return;
		}
		if(depth==n) {
			return;
		}
		visited[depth]=true;
		comb(n,r-1,depth+1,visited);
		visited[depth]=false;
		comb(n,r,depth+1,visited);
	}
	
	static void checkDistance(int[] arr) {
		int[] temp =  new int[houseList.size()];
		int distance;
		for(int i=0;i<houseList.size();i++) {
			int x = houseList.get(i).x;
			int y = houseList.get(i).y;
			distance = Integer.MAX_VALUE;
			
			for(int j=0;j<arr.length;j++) {
				int cx = chickenList.get(arr[j]).x;
				int cy = chickenList.get(arr[j]).y;
				distance = Math.min(distance, Math.abs(cx-x)+Math.abs(cy-y));
			}
			temp[i]= distance;
		}
		
		int sum =0;
		for(int i : temp) {
			sum+=i;
		}
		result = Math.min(result, sum);
	}
}
