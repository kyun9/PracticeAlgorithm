package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_새로운게임2_17837 {
	static int N, K;
	static int[][] color;
	static int[][] horse;
	static LinkedList<Integer>[][] map;
	// 동북서남
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		color = new int[N][N];
		horse = new int[K][3];
		map = new LinkedList[N][N];			//말위치를 나태내주는 LinkedList 이차원배열

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x, y, d;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			d = Integer.parseInt(st.nextToken());

			if (d == 1)
				d = 0;
			else if (d == 4)
				d = 1;

			horse[i][0] = x;
			horse[i][1] = y;
			horse[i][2] = d;

			map[x][y].add(i);
		}

		game();
	}

	static void game() {
		for (int t = 1; t <= 1000; t++) {
			for (int k = 0; k < K; k++) {
				int x = horse[k][0];
				int y = horse[k][1];
				int d = horse[k][2];
				int num = searchOrder(k, x, y);

				int nx = x + dx[d];
				int ny = y + dy[d];
				
				
				//파란색 칸이거나 체스판에서 벗어낫을때
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || color[nx][ny] == 2) {
					horse[k][2] = d= (d + 2) % 4;
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || color[nx][ny] == 2) { //반대편에 파란칸이나 벽이 있을 경우
						continue;
					}
				}
				
				//이동가능하거나 빨간색 칸일 때
				if (move(x, y, nx, ny, num, color[nx][ny])) {
					System.out.println(t);
					return;
				}
			}
		}
		System.out.println("-1");
	}
	
	static boolean move(int x, int y, int nx, int ny, int num, int order) {
		while (map[x][y].size() > num) {	//사이즈가 num이랑 같아질때까지 반복 (칸의 총 높이(size)가 해당 말이 있는 위치(num)보다 클 동안 반복)
			int temp = -1;
			if (order == 0)			// 그냥 이동
				temp = map[x][y].remove(num);
			else					// 뒤집어서 이동 --빨간색
				temp = map[x][y].removeLast();

			horse[temp][0] = nx;
			horse[temp][1] = ny;
			map[nx][ny].add(temp);
		}

		if (map[nx][ny].size() >= 4) {	//말이 4개이상 쌓여있을때 종료
			return true;
		}
		return false;
	}

	// 말이 있는 칸에서 몇번째 높이(num)에 해당 말이 있는지 반환해준다.
	// 말이 이동할때, searchOrder에서 반환받은 높이인 num을 기준으로 말을 옮겨준다.	
	static int searchOrder(int n, int x, int y) {
		for (int i = 0; i < map[x][y].size(); i++) {
			if (map[x][y].get(i) == n) {
				return i;
			}
		}
		return -1;
	}

}
