package B_Study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//다시 풀어보기
//크루스칼 알고리즘으로 풀어보기
public class B_17472 {
	static int N, M, result;
	static int[][] map;
	static int[][] group;
	static boolean[] visited;
	static ArrayList<Pair3>[] list;
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		group = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && group[i][j] == 0) {
					Queue<Pair3> qu = new LinkedList<>();
					group[i][j] = ++cnt;
					qu.add(new Pair3(i, j));
					while (!qu.isEmpty()) {
						Pair3 p = qu.remove();
						for (int k = 0; k < 4; k++) {
							int x = p.x + dx[k];
							int y = p.y + dy[k];
							if (0 <= x && x < N && 0 <= y && y < M) {
								if (map[x][y] == 1 && group[x][y] == 0) {
									qu.add(new Pair3(x, y));
									group[x][y] = cnt;
								}
							}
						}
					}
				}
			}
		}

		visited = new boolean[cnt + 1];
		list = new ArrayList[cnt + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		System.out.println(cnt);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (group[i][j] != 0) {
					list[group[i][j]].add(new Pair3(i, j));
					Queue<Pair3> qu = new LinkedList<>();
					qu.add(new Pair3(i, j));
					bfs(qu);
				}
			}
		}

		dfs(1,0);
		
		System.out.println(result);
	}

	static void bfs(Queue<Pair3> qu) {
		while (!qu.isEmpty()) {
			Pair3 p = qu.remove();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (0 <= x && x < N && 0 <= y && y < M) {
					if (group[x][y] == group[p.x][p.y]) {
						list[group[x][y]].add(new Pair3(x, y));
						qu.add(new Pair3(x, y));
					}
				}
			}
		}
	}

	static void dfs(int start, int depth) {
		if(depth==list.length) {
			return;
		}
		visited[start]= true;
		for (int k = 0; k < list[start].size(); k++) {
			Pair3 p = list[start].get(k);
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (0 <= x && x < N && 0 <= y && y < M) {
					if (group[x][y] == 0) {
						int[] val = goLine(x, y, i);
						if (val[2] >= 2) {
							if(!visited[group[val[0]][val[1]]]) {
								result+=val[2];
								dfs(group[val[0]][val[1]], depth+1);
							}
						}
					}
				}
			}
		}
	}

	static int[] goLine(int x, int y, int dic) {
		int[] arr = new int[3];
		int a=0;
		int b=0;
		int cnt = 0;
		if (dic == 0) {
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == 1) {
					cnt = y-i-1;
					a=x;
					b=i;
					break;
				}
			}
		} else if (dic == 1) {
			for (int i = y; i < M; i++) {
				if (map[x][i] == 1) {
					cnt =i-y-1;
					a=x;
					b=i;
					break;
				}
			}
		} else if (dic == 2) {
			for (int i = x; i < N; i++) {
				if (map[i][y] == 1) {
					cnt= i-x-1;
					a=i;
					b=y;
					break;
				}
			}
		} else if (dic == 3) {
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == 1) {
					cnt =x-i-1;
					a=i;
					b=y;
					break;
				}
			}
		}
		
		arr[0] =a;
		arr[1]=b;
		arr[2]= cnt;
		return arr;
	}
}
