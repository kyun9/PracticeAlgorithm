package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//먼지 클래스
class Dust {
	int x;
	int y;
	int amount;

	Dust(int x, int y, int amount) {
		this.x = x;
		this.y = y;
		this.amount = amount;
	}
}

public class 백준_미세먼지안녕_17144 {

	static int R, C, T;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Integer> machine;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		machine = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					machine.add(i);
				}
			}
		}

		while (T > 0) {
			spreadDust();	//먼지 확산
			rotateAir();	//공기 회전
			T--;
		}
		System.out.println(resultDusts());
	}
	//마지막 총 먼지 수 구하기
	static int resultDusts() {
		int sum=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1) {
					sum +=map[i][j];
				}
			}
		}
		return sum;
	}
	//현재 있는 먼지찾아서 리스트에 넣기
	static ArrayList<Dust> checkDust() {
		ArrayList<Dust> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0  && map[i][j] != -1) {
					list.add(new Dust(i, j, map[i][j]));
				}
			}
		}
		return list;
	}

	static void spreadDust() {
		//checkDust() : 현재 있는 먼지 찾아서 리스트에 넣기
		ArrayList<Dust> Dusts = checkDust();
		int[][] copyMap = new int[R][C]; 
		
		for (int i = 0; i < Dusts.size(); i++) {
			if (Dusts.get(i).amount / 5 > 0) {
				int spread = Dusts.get(i).amount / 5;
				int cnt = 0;
				for (int j = 0; j < 4; j++) {
					int px = Dusts.get(i).x + dx[j];
					int py = Dusts.get(i).y + dy[j];

					if (0 <= px && px < R && 0 <= py && py < C && map[px][py] != -1) {
						cnt++;
						copyMap[px][py] += spread;
					}
				}
				copyMap[Dusts.get(i).x][Dusts.get(i).y] += (Dusts.get(i).amount - (spread * cnt));
			} else {
				copyMap[Dusts.get(i).x][Dusts.get(i).y] += Dusts.get(i).amount;
			}
		}
		
		// copyMap 이차원 배열을 map으로 복사
		copyMapFun(copyMap);
		Dusts.clear();
	}

	// 공기청정기 작동 공기회전
	static void rotateAir() {
		// machine 위
		int swap = 0;
		int x = machine.get(0);
		int temp = map[0][0];
		for (int i = 0; i < x; i++) {
			swap = temp;
			temp = map[i + 1][0];
			map[i + 1][0] = swap;
		}
		for (int i = 0; i < C - 1; i++) {
			swap = temp;
			temp = map[x][i + 1];
			map[x][i + 1] = swap;
		}
		for (int i = x; i > 0; i--) {
			swap = temp;
			temp = map[i - 1][C - 1];
			map[i - 1][C - 1] = swap;
		}
		for (int i = C - 1; i > 0; i--) {
			swap = temp;
			temp = map[0][i - 1];
			map[0][i - 1] = swap;
		}
		//공기 청정기 부분 
		map[x][0] = -1;
		map[x][1] = 0;

		// machine 아래
		swap = 0;
		x = machine.get(1);
		temp = map[x][0];
		for (int i = 0; i < C - 1; i++) {
			swap = temp;
			temp = map[x][i + 1];
			map[x][i + 1] = swap;
		}
		for (int i = x; i < R - 1; i++) {
			swap = temp;
			temp = map[i + 1][C - 1];
			map[i + 1][C - 1] = swap;
		}
		for (int i = C - 1; i > 0; i--) {
			swap = temp;
			temp = map[R - 1][i - 1];
			map[R - 1][i - 1] = swap;
		}
		for (int i = R - 1; i > x; i--) {
			swap = temp;
			temp = map[i - 1][0];
			map[i - 1][0] = swap;
		}
		//공기청정기 부분
		map[x][0] = -1;
		map[x][1] = 0;
	}
	
	//복사메소드
	static void copyMapFun(int[][] copyMap) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
		map[machine.get(0)][0] = -1;
		map[machine.get(1)][0] = -1;
	}
}
