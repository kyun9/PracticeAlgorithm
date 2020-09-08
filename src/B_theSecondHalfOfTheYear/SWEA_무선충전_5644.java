package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Ap {
	int x;
	int y;
	int cov;
	int p;

	Ap(int x, int y, int cov, int p) {
		this.x = x;
		this.y = y;
		this.cov = cov;
		this.p = p;
	}
}

class People {
	int x;
	int y;

	People(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA_무선충전_5644 {
	static int T, M, N;
	static int[][] map;
	static People A, B;
	static int[] moveA, moveB;
	static ArrayList<Ap> list;
	static ArrayList<Integer> sumList;
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			map = new int[10][10];
			A = new People(0, 0);
			B = new People(9, 9);
			moveA = new int[M];
			moveB = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			list = new ArrayList<>();
			sumList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Ap(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			containAp();
			for (int i = 0; i < M; i++) {
				int dicA = moveA[i];
				int dicB = moveB[i];

				A.x += dx[dicA];
				A.y += dy[dicA];

				B.x += dx[dicB];
				B.y += dy[dicB];

				containAp();
			}

			int result = 0;
			for (int i = 0; i < sumList.size(); i++) {
				result += sumList.get(i);
			}
			System.out.println("#" + test + " " + result);
		}
	}

	static void containAp() {
		boolean[] check1 = new boolean[N];
		boolean[] check2 = new boolean[N];

		int ax = A.x;
		int ay = A.y;

		int bx = B.x;
		int by = B.y;

		for (int i = 0; i < N; i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			int cov = list.get(i).cov;
			int p = list.get(i).p;

			if (Math.abs(x - ax) + Math.abs(y - ay) <= cov) {
				check1[i] = true;
			}
			if (Math.abs(x - bx) + Math.abs(y - by) <= cov) {
				check2[i] = true;
			}
		}

		combSize(check1, check2);

	}

	static void combSize(boolean[] check1, boolean[] check2) {
		int a = 0;
		int b = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			if (check1[i]) {
				a = list.get(i).p;
				for (int j = 0; j < N; j++) {
					if (check2[j]) {
						b = list.get(j).p;
						if (i == j) {
							sum = Math.max(sum, a);
						} else {
							sum = Math.max(sum, a + b);
						}
					} else {
						sum = Math.max(sum, a);
					}
				}
			} else {
				for (int j = 0; j < N; j++) {
					if (check2[j]) {
						b = list.get(j).p;
						sum = Math.max(sum, b);
					}
				}
			}
		}

		sumList.add(sum);
	}
}
