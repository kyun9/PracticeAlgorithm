package P_Study;

import java.util.ArrayList;
import java.util.LinkedList;

public class P_DP_IntegerTriangle {

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(solution1(triangle));

	}

	/* DFS �ð� �ʰ� */
//===========================================================================================
	public static int solution(int[][] triangle) {
		int answer = 0;

		answer = dfs(triangle, 0, 0);

		return answer;
	}

	private static int dfs(int[][] triangle, int depth, int su) {
		if (depth == triangle.length) {
			return 0;
		}
		return triangle[depth][su] + Math.max(dfs(triangle, depth + 1, su), dfs(triangle, depth + 1, su + 1));
	}
//===========================================================================================

	
	
//===========================================================================================	
	/* �� Ǯ�� -- LinkedList(�κ� �ð��ʰ�) */
	public static int solution1(int[][] triangle) {
		int answer = 0;

		LinkedList<Integer> list = new LinkedList<>();

		for (int a : triangle[triangle.length - 1])
			list.add(a);

		System.out.println(list);

		for (int i = triangle.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list.get(j) > list.get(j + 1))
					list.set(j, list.get(j) + triangle[i - 1][j]);
				else
					list.set(j, list.get(j + 1) + triangle[i - 1][j]);
			}
			list.removeLast();
		}
		answer = list.get(0);
		return answer;
	}

	/* �� Ǯ�� -- ArrayList(���) */
	public static int solution2(int[][] triangle) {
		int answer = 0;

		ArrayList<Integer> list = new ArrayList<>();

		for (int a : triangle[triangle.length - 1])
			list.add(a);

		System.out.println(list);

		for (int i = triangle.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list.get(j) > list.get(j + 1))
					list.set(j, list.get(j) + triangle[i - 1][j]);
				else
					list.set(j, list.get(j + 1) + triangle[i - 1][j]);
			}
		}
		answer = list.get(0);
		return answer;
	}
//===========================================================================================

//===========================================================================================
	/* �ٸ� ��� Ǯ�� */
	public int solution3(int[][] triangle) {
		// 1. �⺻�� �ʱ�ȭ //
		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
		}

		// 2. ������ȹ�� //
		for (int i = 2; i < triangle.length; i++)
			for (int j = 1; j < i; j++)
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];

		// 3. �ִ밪 ��ȯ //
		int max = 0;
		for (int i = 0; i < dp.length; i++)
			max = Math.max(max, dp[dp.length - 1][i]);

		return max;
	}
//===========================================================================================
}

class Hap {
	int sum;
	int previous;

	Hap(int sum, int previous) {
		this.sum = sum;
		this.previous = previous;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}
}
