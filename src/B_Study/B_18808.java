package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_18808 {
	static int N, M, r, c, result;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int K = Integer.parseInt(st.nextToken());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[r][c];
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//스티커 붙이기
			attach(sticker, k);
		}
		System.out.println(result);
	}

	//붙일수 있나 확인
	static boolean check(int x, int y, int[][] sticker) {
		boolean flag = true;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				// 스티커의 부분과 노트북에서의 부분에서 겹쳐지면 false :  못붙임 종료
				if (sticker[i][j] == 1 && map[x + i][y + j] == 1) {
					return false;
				}
			}
		}
		if (flag) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (sticker[i][j] == 1) {
						//카운트 올림
						result++;
						//스티커의 부분을 노트북에 옮김
						map[x + i][y + j] = 1;
					}
				}
			}
		}
		return flag;
	}
	
	
	//스티커 회전시키기
	static int[][] rotate(int[][] sticker) {
		int[][] temp = new int[c][r];

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++)
				//90도 회전
				temp[i][j] = sticker[r - 1 - j][i];
		}

		//회전하고 행과 열도 바꾸어주기
		int swap = r;
		r = c;
		c = swap;
		return temp;
	}

	
	//스티커 붙이기
	static void attach(int[][] sticker, int k) {
		for (int a = 0; a < 4; a++) {
			//스티커를 노트북에 붙일 수 있는 범위
			for (int i = 0; i <= N - r; i++) {
				for (int j = 0; j <= M - c; j++) {
					//붙일수 있나 확인해보기
					if (check(i, j, sticker)) {
						return;
					}
				}
			}
			//못붙이면 스티커 회전시키기
			sticker = rotate(sticker);
		}
		//못붙이고 종료
		return;
	}

}