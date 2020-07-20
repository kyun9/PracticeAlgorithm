package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Num {
	int su;
	boolean check;

	Num(int su, boolean check) {
		this.su = su;
		this.check = check;
	}
}

public class 백준_2048_12100 {
	static int result = 0;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, map);
		System.out.println(result);
	}

	static void solve(int depth, int[][] map) {
		if (depth == 5) {
			int val = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > val) {
						val = map[i][j];
					}
				}
			}
			result = Math.max(result, val);
			return;
		}

		// 인덱스 북동남서 0123
 		for (int i = 0; i < 4; i++) {
			solve(depth + 1, rotate(i, map));
		}
	}

	static int[][] rotate(int idx, int[][] copyMap) {
		Stack<Num> stack = new Stack<>();
		int[][] result = new int[N][N];
		switch (idx) {
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copyMap[j][i] != 0) {
						if (!stack.isEmpty()) {
							if (stack.peek().su == copyMap[j][i] && !stack.peek().check) {
								stack.pop();
								stack.push(new Num(copyMap[j][i] * 2, true));
							} else {
								stack.push(new Num(copyMap[j][i], false));
							}
						} else {
							stack.push(new Num(copyMap[j][i], false));
						}
					}
				}
				if (!stack.isEmpty()) {
					int size = stack.size() - 1;
					for (int s = size; s >= 0; s--) {
						result[s][i] = stack.pop().su;
					}
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (copyMap[i][j] != 0) {
						if (!stack.isEmpty()) {
							if (stack.peek().su == copyMap[i][j] && !stack.peek().check) {
								stack.pop();
								stack.push(new Num(copyMap[i][j] * 2, true));
							} else {
								stack.push(new Num(copyMap[i][j], false));
							}
						} else {
							stack.push(new Num(copyMap[i][j], false));
						}
					}
				}
				if (!stack.isEmpty()) {
					int size = stack.size() - 1;
					for (int s = size; s >= 0; s--) {
						result[i][N - 1 - s] = stack.pop().su;
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (copyMap[j][i] != 0) {
						if (!stack.isEmpty()) {
							if (stack.peek().su == copyMap[j][i] && !stack.peek().check) {
								stack.pop();
								stack.push(new Num(copyMap[j][i] * 2, true));
							} else {
								stack.push(new Num(copyMap[j][i], false));
							}
						} else {
							stack.push(new Num(copyMap[j][i], false));
						}
					}
				}
				if (!stack.isEmpty()) {
					int size = stack.size() - 1;
					for (int s = size; s >= 0; s--) {
						result[N - 1 - s][i] = stack.pop().su;
					}
				}

			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copyMap[i][j] != 0) {
						if (!stack.isEmpty()) {
							if (stack.peek().su == copyMap[i][j] && !stack.peek().check) {
								stack.pop();
								stack.push(new Num(copyMap[i][j] * 2, true));
							} else {
								stack.push(new Num(copyMap[i][j], false));
							}
						} else {
							stack.push(new Num(copyMap[i][j], false));
						}
					}
				}
				if (!stack.isEmpty()) {
					int size = stack.size() - 1;
					for (int s = size; s >= 0; s--) {
						result[i][s] = stack.pop().su;
					}
				}
			}
			break;
		}
		return result;
	}

	// 이차원배열 확인을 위한 함수
//	static void printArr(int[][] arr) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
