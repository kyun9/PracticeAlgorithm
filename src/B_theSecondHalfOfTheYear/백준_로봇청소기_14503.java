package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
	int x;
	int y;
	int d;

	Robot(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class 백준_로봇청소기_14503 {
	static int N, M, count = 0;
	static int[][] map;
	static Robot robot;
	// 북 동 남 서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//청소시작
		clean();
		System.out.println(count);
	}

	static void clean() {
		
		//청소는 2로 바꿈
		//처음 로봇이 위치한 곳 청소
		map[robot.x][robot.y] = 2;
		
		//반복시작
		while (true) {
			// 왼쪽 회전
			int dic = robot.d - 1;
			if (dic == -1) {
				dic = 3;
			}
			// 왼쪽 확인
			int px = robot.x + dx[dic];
			int py = robot.y + dy[dic];
			if (map[px][py] == 0) {
				//왼쪽 청소해야되면 이동후 청소
				robot.x = px;
				robot.y = py;
				robot.d = dic;
				map[px][py] = 2;
				continue;
			} else if (map[px][py] == 1 || map[px][py] == 2) {    //왼쪽이 벽이거나 청소해야될 경우
				
				//4방향 확인을 위한 check변수
				boolean check = false;
				for (int i = 0; i < 4; i++) {
					int x = robot.x + dx[i];
					int y = robot.y + dy[i];
					
					//4방향 벽이거나 청소해야될 경우 true
					if (map[x][y] != 0) {
						check = true;
					} else {      // 한방향이라도 청소해야될 경우 false
						check = false;
						break;
					}
				}
				
				//4방향이 벽이거나 청소해야 될경우
				if (check) {
					
					//방향에서 뒤로 한칸 이동할 때의 좌표
					int x = robot.x - dx[robot.d];
					int y = robot.y - dy[robot.d];

					//뒤로 이동하는 곳이 벽일때 반복종료
					if (map[x][y] == 1) {
						break;
					} else {  // 뒤로 한칸 이동 가능할 때 이동
						robot.x = x;
						robot.y = y;
						continue;
					}
				} else {    //한방향이라도 청소가능할 때, 방향만 변경
					robot.d = dic;
					continue;
				}

			}
		}
		
		//지도에서 청소한곳 찾기 (2일때)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					count++;
				}
			}
		}
	}
}
