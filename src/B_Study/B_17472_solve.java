package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge3 implements Comparable<Edge3> {
	int start, end, value;

	public Edge3(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}

	@Override
	public int compareTo(Edge3 o) {
		return this.value - o.value;
	}

	@Override
	public String toString() {
		return "Edge3 [start=" + start + ", end=" + end + ", value=" + value + "]";
	}
}

class Pointer {
	int i;
	int j;
	int lable = 0;

	public Pointer(int i, int j, int lable) {
		this.i = i;
		this.j = j;
		this.lable = lable;
	}

	public Pointer(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "Pointer [i=" + i + ", j=" + j + ", lable=" + lable + "]";
	}
}

public class B_17472_solve {
	static int[][] map;
	static boolean[][] visited;
	static Queue<Pointer> island;
	static int islandNum, N, M;
	static int[] di = { 0, -1, 0, 1 };
	static int[] dj = { 1, 0, -1, 0 };
	static int V;
	static ArrayList<Edge3> mst;
	static int[] arr;
	static PriorityQueue<Edge3> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().trim().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().trim().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		islandNum = 0; // 섬의 갯수 , 섬에 라벨링을 하기 위함
		island = new LinkedList<>(); // 섬의 위치를 구별하기위한 큐

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					islandNum++;
					island.add(new Pointer(i, j, islandNum));
					visited[i][j] = true;
					map[i][j] = islandNum;
					while (!island.isEmpty()) {
						Pointer p = island.poll();
						for (int k = 0; k < 4; k++) {
							int nexti = p.i + di[k];
							int nextj = p.j + dj[k];

							if (nexti >= 0 && nextj >= 0 && nexti < N && nextj < M) {
								if (!visited[nexti][nextj] && map[nexti][nextj] == 1) {
									map[nexti][nextj] = p.lable;
									visited[nexti][nextj] = true;
									island.add(new Pointer(nexti, nextj, p.lable));
								}
							}
						}
					}
				}
			}
		}

//      print();
		// 섬에 라벨링은 끝난상태
		// 이제부터 각 섬들 사이에 최소의 거리를 찾아서 그 정보를 저장해야한다.
		// 필요한 자료 정점의 갯수, 간선의 갯수,대표자 확인을 위한배열,pq,list(최소신장트리결과물을 담음),Edge3 객체
		pq = new PriorityQueue<>();
		V = islandNum; // 정점의 갯수
		mst = new ArrayList<>();
		arr = new int[V + 1];

		for (int i = 1; i <= islandNum; i++) {
			findEdge3(i); // 간선을 찾기위해 돌리는 여정~
		}

		for (int i = 0; i <= V; i++) {
			arr[i] = i;
		}
		// 정점이 없으면 = 다리가 놓을수 없으면 -1리턴한다.
		if (pq.size() == 0) {
			System.out.println("-1");
			return;
		}

//      System.out.println(pq.toString());
		while (mst.size() < (V - 1)) { // V개의 정점을 연결하기 위한 최소간선 갯수는 V-1개인데 아직 그게 안됐으면 계속 하기
			Edge3 Edge3 = pq.poll();
//          System.out.println("111111");
			if (Edge3 == null) {
				System.out.println("-1");
				return;
			}
			if (find(Edge3.start) != find(Edge3.end)) {
//              System.out.println("22222");
				mst.add(Edge3);
				union(Edge3.start, Edge3.end);
			}
		}
//      System.out.println(mst);
		int ans = 0;

		for (int i = 0; i < mst.size(); i++) {
			ans += mst.get(i).value;
		}

		System.out.println(ans);
	}

	// 기준숫자가 들어왔을때 , 기준숫자에서 왼 오 위 아래로 갔을때 닿는애들이 있는지 확인하고 있으면 pq에 넣어줄거다!
	static void findEdge3(int num) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == num) { // 기준숫자에서 좌,우,왼,오로 갔을때 다른 숫자랑 만나게되면 pq에 넣어주고 V 추가해준다
					for (int k = 0; k < 4; k++) {
						int tmpi = i;
						int tmpj = j;
						int cnt = 0;
						while (true) {
							int nexti = tmpi + di[k];
							int nextj = tmpj + dj[k];
							// 범위를 벗어나면 그냥 나가고
							if (nexti < 0 || nextj < 0 || nexti >= N || nextj >= M) {
								break;
							} else if (map[nexti][nextj] == num) { // 바로옆에 나랑 같은 숫자가 있으면 넘어가고
								break;
							} else if (map[nexti][nextj] == 0) {
								cnt++;
								tmpi = nexti;
								tmpj = nextj;
								continue;
							} else { // 0도아니고 나자신도아니고 새로운 숫자가 나오면! 이제 pq에 넣어준다.단, 1이상이어야한다.
								if (cnt > 1) {
//                                  System.out.println("현재 i,j= "+ i+","+j);
//                                  System.out.println("다음 i,j= "+ nexti+","+nextj);
//                                  System.out.println(map[i][j]+"/"+map[nexti][nextj]+"/"+cnt);
									pq.add(new Edge3(map[i][j], map[nexti][nextj], cnt));
								}
								break;
							}
						}
					}
				}
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

	static int find(int n) { // n이속한 집합의 대표를 반환하는 함수
		if (n == arr[n]) {
			return n;
		} else {
			int p = find(arr[n]);
			arr[n] = p; // 너무많은 재귀호출을 피하기 위해서 최종대표를 저장한다.
			return p;
		}
	}

	static void union(int n1, int n2) { // n1이 속한 집합과 n2가 속한 집합을 통합하는 함수(뒤에놈이 대표가 된다)
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 != p2) {
			arr[p1] = p2;
		}
	}
}
