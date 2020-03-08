package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//시간초과
class Fish {
	int x;
	int y;
	int size;
	int eat;

	Fish(int x, int y, int size, int eat) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.eat = eat;
	}
}
class Pqueue implements Comparable<Pqueue>{
	int x;
	int y;
	int val;
	
	Pqueue(int x, int y, int val){
		this.x =x;
		this.y = y;
		this.val=val;
	}

	@Override
	public int compareTo(Pqueue p1) {
		if(this.val<p1.val) {
			return -1;
		}else if(this.val ==p1.val) {
			if(this.x<p1.x) {
				return -1;
			}else if(this.x==p1.x) {
				if(this.y<p1.y) {
					return -1;
				}
			}
		}
		return 1;
	}
}
public class B_16236_self {
	static int N, result;
	static int[][] map;
	static int[][] copyMap;
	static boolean[][] visited;
	static int dfsDist;
	static Fish shark;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Fish> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j]=0;
					shark = new Fish(i, j, 2, 0);
				}
			}
		}

		solve();
		System.out.println(result);
		
	}
	static void go(int x, int y, int depth,int size) {
		for(int i=0;i<4;i++) {
			int px = x+dx[i];
			int py = y + dy[i];
			if(0<=px&&px<N&&0<=py&&py<N&&map[px][py]<=size) {
				if(!visited[px][py]) {
					visited[px][py]=true;
					if(copyMap[px][py]!=0&&copyMap[px][py]>depth) {
						copyMap[px][py]=depth;
					}
					go(px,py,depth+1,size);
					visited[px][py]=false;
				}
			}
		}
	}
	static void solve() {
		while (true) {
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (shark.size > map[i][j] && map[i][j] != 0) {
						list.add(new Fish(i, j, map[i][j], 0));
					}
				}
			}

			if (!list.isEmpty()) {
				PriorityQueue<Pqueue> pq = new PriorityQueue<>();
					
				visited = new boolean[N][N];
				copyMap = new int[N][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						copyMap[i][j]=Integer.MAX_VALUE;
					}
				}
				visited[shark.x][shark.y]=true;
				copyMap[shark.x][shark.y]=0;
				go(shark.x, shark.y,1,shark.size);
				
				
				for (int i = 0; i < list.size(); i++) {
					pq.add(new Pqueue(list.get(i).x,list.get(i).y, copyMap[list.get(i).x][list.get(i).y]));
				}

				
				if(pq.isEmpty()) {
					break;
				}
				
				Pqueue p = pq.peek();

				map[p.x][p.y] = 0;
				shark.x = p.x;
				shark.y = p.y;
				shark.eat += 1;
				if (shark.eat == shark.size) {
					shark.eat = 0;
					shark.size += 1;
				}
				result += p.val;
			} else {
				break;
			}
		}
	}
}


/*
package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Fish {
	int x;
	int y;
	int size;
	int eat;

	Fish(int x, int y, int size, int eat) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.eat = eat;
	}
}

public class B_16236 {
	static int N, result;
	static int[][] map;
	static boolean[][] visited;
	static int dfsDist;
	static Fish shark;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Fish> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j]=0;
					shark = new Fish(i, j, 2, 0);
				}
			}
		}

		solve();
		System.out.println(result);
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

	static void solve() {
		while (true) {
//			System.out.println("result : "+ result);
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (shark.size > map[i][j] && map[i][j] != 0) {
						list.add(new Fish(i, j, map[i][j], 0));
					}
				}
			}

			if (!list.isEmpty()) {
				int[] distance = new int[list.size()];
				for (int i = 0; i < list.size(); i++) {
					dfsDist = Integer.MAX_VALUE;
					visited = new boolean[N][N];
					visited[shark.x][shark.y] = true;
					dfs(shark.x, shark.y, 0, list.get(i).x, list.get(i).y);
					distance[i] = dfsDist;
				}

//				for (int i = 0; i < list.size(); i++) {
//					System.out.println(
//							"list.x : " + list.get(i).x + " list.y : " + list.get(i).y + " distance : " + distance[i]);
//				}
//				System.out.println();

				boolean check = false;
				for (int i = 0; i < distance.length; i++) {
					if (distance[i] != 0) {
						check = true;
					}
				}

				if (!check) {
					break;
				}

				int tmp = 0;
				boolean flag = false;
				for (int i = 0; i < distance.length; i++) {
					if (distance[i] != 0) {
						if (!flag) {
							tmp = i;
							flag = true;
						} else {
							if (distance[tmp] > distance[i]) {
								tmp = i;
							} else if (distance[tmp] == distance[i]) {
								if (list.get(tmp).x > list.get(i).x) {
									tmp = i;
								} else if (list.get(tmp).x == list.get(i).x) {
									if (list.get(tmp).y > list.get(i).y) {
										tmp = i;
									}
								}
							}
						}
					}
				}

				map[list.get(tmp).x][list.get(tmp).y] = 0;
				shark.x = list.get(tmp).x;
				shark.y = list.get(tmp).y;
				shark.eat += 1;
				if (shark.eat == shark.size) {
					shark.eat = 0;
					shark.size += 1;
				}
				result += distance[tmp];
			} else {
				break;
			}
		}
	}

	static void dfs(int x, int y, int distance, int fx, int fy) {

		if (x == fx && y == fy) {
			dfsDist = Math.min(dfsDist, distance);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (0 <= px && px < N && 0 <= py && py < N) {
				if (!visited[px][py] && map[px][py] <= shark.size) {
					visited[px][py] = true;
					dfs(px, py, distance + 1, fx, fy);
					visited[px][py]=false;
				}
			}
		}

	}
}



 */
