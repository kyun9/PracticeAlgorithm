package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair88 implements Comparable<Pair88> {
	int x;
	int y;
	int d;

	Pair88(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public int compareTo(Pair88 o) {
		if (this.d != o.d) {
			return this.d - o.d;	//d가 큰경우
		} else {
			if (this.x != o.x) {
				return this.x - o.x;	//행이 큰경우
			} else {
				return this.y - o.y;	//열이 큰경우
			}
		}
	}

	@Override
	public String toString() {
		return "Pair88 [x=" + x + ", y=" + y + ", d=" + d + "]";
	}

}

class Passenger {
	int x;
	int y;
	int destinationX;
	int destinationY;

	Passenger(int x, int y, int destinationX, int destinationY) {
		this.x = x;
		this.y = y;
		this.destinationX = destinationX;
		this.destinationY = destinationY;
	}

	@Override
	public String toString() {
		return "Passenger [x=" + x + ", y=" + y + ", destinationX=" + destinationX + ", destinationY=" + destinationY
				+ "]";
	}

}

public class 백준_스타트택시_19238 {
	static int N, M, K;
	static int[][] map;
	static Pair88 taxi;
	static ArrayList<Passenger> list = new ArrayList<>();
	static PriorityQueue<Pair88> pq = new PriorityQueue<>();
	static boolean[] isPossible;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		taxi = new Pair88(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int desX = Integer.parseInt(st.nextToken());
			int desY = Integer.parseInt(st.nextToken());

			list.add(new Passenger(x, y, desX, desY));
		}
		isPossible = new boolean[list.size()];
		Arrays.fill(isPossible, true);

		start();
		System.out.println(K);
	}

	static void start() {
		int[][] copyMap;
		while (true) {
			if (list.size() == 0) {	//손님 전부 다 나르면 종료
				break;
			}
			copyMap = searchLength(taxi.x, taxi.y);	//경로거리 구하기 BFS
			pq.clear();
			for (int i = 0; i < list.size(); i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				int d = copyMap[x][y];
				if (d == -9) {	//막혀있으면 종료
					K=-1;
					return;
				}
				pq.offer(new Pair88(x, y, d));
			}
			Pair88 p = pq.poll();			// 조건에 맞는 것 가져오기
			int idx = 0;
			for (int i = 0; i < list.size(); i++) {	//리스트의 idx 추출
				if (p.x == list.get(i).x && p.y == list.get(i).y && p.d == copyMap[list.get(i).x][list.get(i).y]) {
					idx = i;
					break;
				}
			}
			K -= p.d;	
			if (K < 0) {		//연료 부족시 while문 종료
				K = -1;
				break;
			}

			copyMap = searchLength(p.x, p.y);	//경로거리 구하기 BFS
			int val = copyMap[list.get(idx).destinationX][list.get(idx).destinationY]; //idx로 목적지 거리 val
			K -= val;	
			if (K < 0) {	//연료 부족시 while문 종료
				K = -1;
				break;
			}
			K += val * 2;	//연료 충전
			taxi.x = list.get(idx).destinationX;//택시 위치 초기화
			taxi.y = list.get(idx).destinationY;

			list.remove(idx);	// 이용한 손님제거
		}
	}

	static int[][] searchLength(int x, int y) {
		boolean[][] visited = new boolean[N + 1][N + 1];	//방문여부판단
		int[][] copyMap = new int[N + 1][N + 1];	// 복사 이차원배열
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] == 1) {
					copyMap[i][j] = -1;
				}
			}
		}

		Queue<Pair88> qu = new LinkedList<>();	//BFS
		qu.offer(new Pair88(x, y, 0));
		visited[x][y] = true;
		while (!qu.isEmpty()) {
			Pair88 p = qu.poll();

			for (int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];

				if (1 <= px && px < N + 1 && 1 <= py && py < N + 1) {
					if (!visited[px][py] && copyMap[px][py] != -1) {
						visited[px][py] = true;
						copyMap[px][py] = copyMap[p.x][p.y] + 1; // taxi 위치에서 거리 증가
						qu.offer(new Pair88(px, py, p.d + 1));
					}
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (copyMap[i][j] == 0 && i != x && j != y) {
					copyMap[i][j] = -9;	//막혀있는 부분 -9로 초기화
				}
			}
		}
//		print(copyMap);
		return copyMap;
	}

	static void print(int[][] arr) {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
