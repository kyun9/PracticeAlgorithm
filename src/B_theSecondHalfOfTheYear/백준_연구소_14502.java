package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair2 {
	int x;
	int y;

	Pair2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 백준_연구소_14502 {
	static int N, M, result = 0;
	static int[][] map;
	static ArrayList<Pair2> emptyList;
	static Queue<Pair2> virusList;
	static boolean[] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		emptyList = new ArrayList<>();
		virusList = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Pair2(i, j));
				} else if (map[i][j] == 0) {
					emptyList.add(new Pair2(i, j));
				}
			}
		}

		visited = new boolean[emptyList.size()];
		selectWall(0, emptyList.size(), 3);

		System.out.println(result);
	}

	//빈공간에서 벽을 조합을 통해 3개 선택
	static void selectWall(int depth, int n, int r) {
		if (r == 0) {
			Queue<Pair2> blockList = new LinkedList<>();
			//선택된 벽 blockList에 담고 확장시킴
			for (int i = 0; i < emptyList.size(); i++) {
				if (visited[i]) {
					blockList.add(new Pair2(emptyList.get(i).x,emptyList.get(i).y));
				}
			}
			//바이러스 확장
			expandVirus(blockList);
			return;
		}
		if (depth == n) {
			return;
		} else {
			visited[depth] = true;
			selectWall(depth + 1, n, r - 1);
			visited[depth] = false;
			selectWall(depth + 1, n, r);
		}

	}

	//바이러스 확장
	static void expandVirus(Queue<Pair2> blockList) {
		int[][] copyMap = new int[N][M];
		Queue<Pair2> qu = new LinkedList<>();
		qu.addAll(virusList);

		//맥 복사 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j]= map[i][j];
			}
		}
		//선택 된 block부분 맵에 추가
		while(!blockList.isEmpty()) {
			Pair2 p = blockList.poll();
			copyMap[p.x][p.y]=1;
		}
		
		//bfs로 바이러스 확장시킴
		while (!qu.isEmpty()) {
			Pair2 p = qu.poll();
			for (int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];

				if (0 <= px && px < N && 0 <= py && py < M) {
					if (copyMap[px][py] == 0) {
						copyMap[px][py] = 2;
						qu.add(new Pair2(px, py));
					}
				}
			}
		}
		
		//안정영역 카운트
		int totalEmpty = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					totalEmpty++;
				}
			}
		}

		result = Math.max(result, totalEmpty);
	}
}
