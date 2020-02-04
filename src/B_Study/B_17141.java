package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17141 {
	static int N, M,cnt,count;
	static int[][] map;
	static int[][] map2;
	static int[][] dist;
	static boolean[][] visited;
	static ArrayList<Point11> list;
	static boolean[] check;
	static ArrayList<Point11>[] chooseList;
	static int[] dx= {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		map2 = new int[N][N];
		dist = new int[N][N];
		visited = new boolean[N][N];
		
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Point11(i, j));
				}
			}
		}
		int a=1;
		for(int i=list.size();i>list.size()-M;i--) {
			a*=i;
		}
		int b=1;
		for(int i=M;i>0;i--) {
			b*=i;
		}
		int size = a/b;
		
		chooseList= new ArrayList[size];
		for(int i=0;i<chooseList.length;i++) {
			chooseList[i]= new ArrayList<>();
		}
		
		check = new boolean[list.size()];
		cnt=0;
		choosePoint(0, M);
		count=0;
		Queue<Point11> qu = new LinkedList<>();
		ArrayList<Integer> resultList =new ArrayList<>();
		for(int i=0;i<chooseList.length;i++) {
			for (int g = 0; g < N; g++) {
				for (int h = 0; h < N; h++) {
					dist[g][h]=-1;
				}
			}
			
			for(int j=0;j<chooseList[i].size();j++) {
				dist[chooseList[i].get(j).x][chooseList[i].get(j).y]=0;
				qu.add(new Point11(chooseList[i].get(j).x,chooseList[i].get(j).y));
			}
			while(!qu.isEmpty()) {
				Point11 p = qu.poll();
				for(int k=0;k<4;k++) {
					int px = p.x+dx[k];
					int py = p.y+dy[k];
					if(0<=px&&px<N&&0<=py&&py<N) {
						if(map[px][py]!=1&&dist[px][py]==-1) {
							qu.add(new Point11(px,py));
							dist[px][py]=dist[p.x][p.y]+1;
						}
					}
				}
			}
			
			int result=0;
			label : for (int g = 0; g < N; g++) {
				for (int h = 0; h < N; h++) {
					if(result<dist[g][h]) {
						result=dist[g][h];
					}
					if(map[g][h]==0&&dist[g][h]==-1) {
						result= -1;
						break label;
					}
				}
			}
			if(result != -1) {
				resultList.add(result);
			}else {
				count++;
			}
			if(count==chooseList.length) {
				resultList.add(-1);
			}
			
			qu.clear();
		}
		
		Collections.sort(resultList);
		System.out.println(resultList.get(0));
		
	}
	static void choosePoint(int depth, int r) {
		if (r == 0) {
			for (int i = 0; i < list.size(); i++) {
				if (check[i]) {
					chooseList[cnt].add(list.get(i));
				}
			}
			cnt++;
			return;
		}
		if(depth==list.size()) {
			return;
		}
		check[depth] = true;
		choosePoint(depth + 1, r - 1);
		check[depth] = false;
		choosePoint(depth + 1, r);
	}
}

class Point11 {
	int x;
	int y;

	Point11(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
