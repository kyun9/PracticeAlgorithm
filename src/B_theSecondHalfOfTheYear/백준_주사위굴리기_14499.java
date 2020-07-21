package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dice {
	int x, y;
	int top;
	int up;
	int rigth;

	Dice(int x, int y, int top, int up, int right) {
		this.x = x;
		this.y = y;
		this.top = top;
		this.up = up;
		this.rigth = right;
	}
}

public class 백준_주사위굴리기_14499 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] diceArr = new int[7];
	static Queue<Integer> qu;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		qu = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			qu.add(Integer.parseInt(st.nextToken()));
		}

		Dice dice = new Dice(x, y, 1, 2, 3);

		while (!qu.isEmpty()) {
			int n = qu.poll();
			int temp;
			switch (n) {
			case 1: // 동
				if (0 <= dice.y + 1 && dice.y + 1 < M) {
					dice.y += 1;
				}else {
					continue;
				}
				temp = dice.top;
				dice.top = 7 - dice.rigth;
				dice.rigth = temp;
				break;
			case 2: // 서
				if (0 <= dice.y - 1 && dice.y - 1 < M) {
					dice.y -= 1;
				}else {
					continue;
				}
				temp = dice.top;
				dice.top = dice.rigth;
				dice.rigth = 7 - temp;
				break;
			case 3: // 북
				if (0 <= dice.x - 1 && dice.x - 1 < N) {
					dice.x -= 1;
				}else {
					continue;
				}
				temp = dice.up;
				dice.up = dice.top;
				dice.top = 7 - temp;
				break;
			case 4: // 남
				if (0 <= dice.x + 1 && dice.x + 1 < N) {
					dice.x += 1;
				}else {
					continue;
				}
				temp = dice.top;
				dice.top = dice.up;
				dice.up = 7 - temp;
				break;
			}

			if(map[dice.x][dice.y]!=0) {
				diceArr[7-dice.top]=map[dice.x][dice.y];
				map[dice.x][dice.y]=0;
			}else {
				map[dice.x][dice.y]=diceArr[7-dice.top];
			}
			
			System.out.println(diceArr[dice.top]);
		}

	}

}
