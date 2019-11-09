package StudyAlgorithm;

import java.util.Stack;

public class a1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
				{ 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		int size = board.length + 1;
		int[][] arr = new int[size][size];

		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				arr[i][j] = board[i - 1][j - 1];
			}
		}
		
		for (int i = 0; i < moves.length; i++) {
			for (int j = 1; j < size; j++) {
				if (arr[j][moves[i]] != 0) {
					if (!stack.isEmpty()) {
						if (stack.peek() == arr[j][moves[i]]) {
							stack.pop();
							answer+=2;
						}
						else {
							stack.push(arr[j][moves[i]]);
						}
						arr[j][moves[i]] = 0;
						break;
					} else {
						stack.push(arr[j][moves[i]]);
						arr[j][moves[i]] = 0;
						break;
					}
				}
			}
		}
		return answer;
	}
}
