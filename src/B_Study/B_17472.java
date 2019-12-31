package B_Study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//다시 풀어보기
//크루스칼 알고리즘으로 풀어보기
class Pair5 {
	int x;
	int y;

	Pair5(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Rel {
	int x;
	int y;
	int dic;

	Rel(int x, int y, int dic) {
		this.x = x;
		this.y = y;
		this.dic = dic;
	}
}

class Node {
	int start;
	int end;
	int weight;

	Node(int start, int end,int weight) {
		this.start = start;
		this.end= end;
		this.weight = weight;
	}
}

public class B_17472 {
	static int N, M;
	static int[][] map;
	static int[][] group;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static ArrayList<Pair5>[] list;
	static ArrayList<Rel>[] relate;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		group = new int[N][M];
		list = new ArrayList[7];
		relate = new ArrayList[7];
		pq = new PriorityQueue<>();

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			relate[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		Queue<Pair5> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && group[i][j] == 0) {
					cnt += 1;
					q.add(new Pair5(i, j));
					group[i][j] = cnt;
					list[cnt].add(new Pair5(i, j));
					while (!q.isEmpty()) {
						Pair5 p = q.remove();
						for (int a = 0; a < 4; a++) {
							int x = p.x + dx[a];
							int y = p.y + dy[a];
							if (0 <= x && x < N && 0 <= y && y < M) {
								if (map[x][y] == 1 && group[x][y] == 0) {
									group[x][y] = cnt;
									q.add(new Pair5(x, y));
									list[cnt].add(new Pair5(x, y));
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				findDic(i, j);
			}
		}

		for (int i = 0; i < relate.length; i++) {
			for (int j = 0; j < relate[i].size(); j++) {
				cofirmEdge(i, j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(group[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("relate");
		for (int i = 0; i < relate.length; i++) {
			for (int j = 0; j < relate[i].size(); j++) {
				System.out.print(relate[i].get(j).x + " " + relate[i].get(j).y + "  " + relate[i].get(j).dic);
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("node");
		for (int i = 0; i < pq.size(); i++) {
				System.out.print(pq);
				System.out.println();
			}
			System.out.println();
		}

	

	static void findDic(int a, int b) {
		for (int i = 0; i < 4; i++) {
			int x = list[a].get(b).x + dx[i];
			int y = list[a].get(b).y + dy[i];
			if (0 <= x && x < N && 0 <= y && y < M) {
				if (map[x][y] == 0) {
					relate[a].add(new Rel(list[a].get(b).x, list[a].get(b).y, i));
				}
			}
		}
	}

	static void cofirmEdge(int a, int b) {
		Rel r = relate[a].get(b);
		System.out.println("a " + a + " b " + b + " relate[a].get(b).dic " + relate[a].get(b).dic);
		int tmp = 0;
		if (r.dic == 0) {
			for (int i = r.x - 1; i >= 0; i--) {
				if (group[i][r.y] != 0) {
					if (tmp <= 1) {
						break;
					}
//					if(!containNode(group[r.x][r.y], i, r.y, tmp)) {
					pq.add(new Node(group[r.x][r.y],group[i][r.y], tmp));
					break;
//					}
				}
				tmp++;
			}
		} else if (r.dic == 1) {
			for (int i = r.y - 1; i >= 0; i--) {
				if (group[r.x][i] != 0) {
					if (tmp <= 1) {
						break;
					}
//					if(!containNode(group[r.x][r.y], r.x,i,tmp)) {
						pq.add(new Node(group[r.x][r.y],group[r.x][i], tmp));
					break;
//					}
				}
				tmp++;
			}
		} else if (r.dic == 2) {
			for (int i = r.y + 1; i < M; i++) {
				if (group[r.x][i] != 0) {
					if (tmp <= 1) {
						break;
					}
//					if(!containNode(group[r.x][r.y],r.x,i,tmp)) {
						pq.add(new Node(group[r.x][r.y],group[r.x][i], tmp));
					break;
//					}
				}
				tmp++;
			}
		} else {
			for (int i = r.x + 1; i < N; i++) {
				if (group[i][r.y] != 0) {
					if (tmp <= 1) {
						break;
					}
//					if(!containNode(group[r.x][r.y], i,r.y,tmp)) {
						pq.add(new Node(group[r.x][r.y],group[i][r.y], tmp));
						break;
//					}
				}
				tmp++;
			}
		}
	}
//	static boolean containNode(int start, int x, int y, int weight) {
//
//		for(int i=0;i<pq.size();i++) {
//			if(pq.==group[x][y]) {
//				if(node[start].get(i).weight==weight) {
//					return true;
//				}
//			}
//		}
//		return false;
//		
//	}

}
