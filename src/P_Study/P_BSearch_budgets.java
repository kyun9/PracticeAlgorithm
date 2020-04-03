package P_Study;

import java.util.Arrays;

public class P_BSearch_budgets {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 120, 110, 140, 150 }, 485));
		System.out.println(solution(new int[] { 5, 6, 7, 8 }, 10));
	}

	//이분 탐색
	static public int solution(int[] budgets, int M) {
		int answer = 0;

		Arrays.sort(budgets);
		long sum = 0;
		for (int i = 0; i < budgets.length; i++) {
			sum += budgets[i];
		}
		//다 합쳐도 예산을 넘지 않았을 때
		if (sum <= M) {
			return budgets[budgets.length - 1];
		}

		int min = M / budgets.length;
		int max = budgets[budgets.length - 1];
		int mid = 0;
		int cmp = 0;
		
		while (true) {
			sum = 0;
			mid = (max + min) / 2;
			for (int budget : budgets) {
				sum += budget > mid ? mid : budget;
			}
			if (mid == cmp) {
				answer = mid;
				break;
			}
			if (sum > M) {
				max = mid;
			} else {
				min = mid;
			}
			cmp = mid;
		}
		return answer;
	}

}
