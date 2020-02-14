package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Op {
	int r;
	int c;
	int s;

	Op(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class B_17406 {
	static int N, M, K;
	static int[][] A;
	static ArrayList<Op> op;
	static int minRow,result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		op = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			op.add(new Op(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		boolean[] visited = new boolean[K];
		int[] order = new int[K];
		result= Integer.MAX_VALUE;
		perm(order, visited, 0, K, K);
		System.out.println(result);
	}

	static void perm(int[] order, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			minRow=Integer.MAX_VALUE;
			goRotation(order);
			result=Math.min(result, minRow);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				perm(order, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	static void goRotation(int[] order) {
		int[][] temp = new int[N][M];
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = A[i][j];
				copy[i][j] = A[i][j];
			}
		}

		for (int i = 0; i < order.length; i++) {
			if(i!=0) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						copy[j][k] = temp[j][k];
					}
				}
			}

			int start = order[i];

			Op select = op.get(start);

			int x1 = select.r - select.s - 1;
			int y1 = select.c - select.s - 1;

			int x2 = select.r + select.s - 1;
			int y2 = select.c + select.s - 1;

			int a = x1, b = y1;
			boolean flag = true;
			boolean check = true;
			while (flag) {
				if (!check) {
					x1 += 1;y1 += 1;
					x2 -= 1;y2 -= 1;

					a = x1;b = y1;
					if (x1 >= x2 && y1 >= y2) {
						flag = false;
					} else {
						check = true;
					}
				} else {
					if (a == x1 && b + 1 <= y2) {
						temp[a][b + 1] = copy[a][b];
						b++;
					} else if (b == y2 && a + 1 <= x2) {
						temp[a + 1][b] = copy[a][b];
						a++;
					} else if (a == x2 && b - 1 >= y1) {
						temp[a][b - 1] = copy[a][b];
						b--;
					} else if (b == y1 && a - 1 >= x1) {
						temp[a - 1][b] = copy[a][b];
						a--;
						if (a == x1) {
							check = false;
						}
					}
				}
			}
		}
		int sum=0;
		for (int i = 0; i < N; i++) {
			sum=0;
			for (int j = 0; j < M; j++) {
				sum+=temp[i][j];
			}
			minRow = Math.min(minRow, sum);
		}
	}
}
