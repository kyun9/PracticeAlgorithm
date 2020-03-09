package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class PairA {
	int x;
	int y;
	int val;

	PairA(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

public class B_17142 {
	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static ArrayList<PairA> list;
	static ArrayList<Integer> resultList;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new PairA(i, j,0));
				}
			}
		}

		boolean[] check = new boolean[list.size()];
		resultList=new ArrayList<>();
		comb(check, 0, list.size(), M);
		
		if(resultList.size()==0) {
			System.out.println(-1);
		}else {
			Collections.sort(resultList);
			System.out.println(resultList.get(0));
		}
	}

	static void comb(boolean[] check, int depth, int n, int r) {
		if (r == 0) {
			ArrayList<PairA> tList = new ArrayList<>();
			ArrayList<PairA> fList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				if (check[i]) {
					tList.add(new PairA(list.get(i).x, list.get(i).y,0));
				} else {
					fList.add(new PairA(list.get(i).x, list.get(i).y,0));
				}
			}
			
			findDist(tList, fList);
			
			boolean flag= true;
			int val=0;
			label : for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(copyMap[i][j]==-1) {
						flag = false;
						break label;
					}
					val = Math.max(val, copyMap[i][j]);
				}
			}
			
//			System.out.println("val : "+val);
//			System.out.println();
			if(flag) {
				resultList.add(val);
			}
			return;
		}
		if (depth == n) {
			return;
		}
		check[depth] = true;
		comb(check, depth + 1, n, r - 1);
		check[depth] = false;
		comb(check, depth + 1, n, r);
	}
	
	static void findDist(ArrayList<PairA> tList, ArrayList<PairA> fList) {
		copyMap = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0) {
					copyMap[i][j]=-1;	
				}
			}
		}
			
		
		
		for(int i=0;i<fList.size();i++) {
			copyMap[fList.get(i).x][fList.get(i).y]= -9;
		}
		for(int i=0;i<tList.size();i++) {
			copyMap[tList.get(i).x][tList.get(i).y]= 0;
		}
		
		
		while(!tList.isEmpty()) {
			PairA p = tList.remove(0);
			int val = p.val;
			for(int i=0;i<4;i++) {
				int px = p.x+dx[i];
				int py = p.y+dy[i];
				if(0<=px&&px<N&&0<=py&&py<N&&!visited[px][py]) {
					visited[px][py]=true;
					if(map[px][py]==0||map[px][py]==2) {
						 if(copyMap[px][py]==-1) {
							tList.add(new PairA(px,py,val+1));
							copyMap[px][py]= val+1;
						}
						 if(copyMap[px][py]==-9) {
							 tList.add(new PairA(px,py,val+1));
							 continue;
						 }
					}
				}
			}
		}
		
//		System.out.println("map");
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("copyMap");
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(copyMap[i][j]+" ");
//			}
//			System.out.println();
//		}		
		
	}
}
