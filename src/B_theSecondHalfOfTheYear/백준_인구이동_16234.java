package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair6 {
	int x;
	int y;

	Pair6(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 백준_인구이동_16234 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		flag = true;
		//인구이동 반복
		while (true) {
			flag = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						//방문하지 않은 나라 확장확인하기
						bfs(i, j);
					}
				}
			}
//			print();
			if (!flag) {		//탈출 조건
				break;
			}
			//인구이동 반복 횟수
			cnt++;
		}

		System.out.println(cnt);

	}

	static void bfs(int x, int y) {
		Queue<Pair6> qu = new LinkedList<>(); 		//bfs를 반복하기 위한 큐
		ArrayList<Pair6> list = new ArrayList<>();	//인구 이동이 가능한 나라들의  큐
		qu.add(new Pair6(x, y));
		list.add(new Pair6(x, y));
		int sum = map[x][y];		//인구 이동 가능한 나라들의 인구를 저장할 변수
		while (!qu.isEmpty()) {
			Pair6 p = qu.poll();
			for (int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];

				if (0 <= px && px < N && 0 <= py && py < N) {
					if (!visited[px][py]) {
						int gap = Math.abs(map[p.x][p.y] - map[px][py]);	
						if (L <= gap && gap <= R) {
							flag = true;					//gab 차이가 나면 전역변수 flag를 true로 바꿔주어 메인함수의 while문 탈출
							qu.add(new Pair6(px, py));
							list.add(new Pair6(px, py));
							sum += map[px][py];
							visited[px][py] = true;
						}
					}
				}
			}
		}
		
		// 인구의 총합을 나라의 수로 나눈 값으로  지도에 초기화시켜줌 
		if (list.size() != 1) {
			int divid = sum / list.size();
			for (int i = 0; i < list.size(); i++) {
				int listX = list.get(i).x;
				int listY = list.get(i).y;

				map[listX][listY] = divid;
			}
		}
	}

	
	// map 출력함수
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
