package P_Study;

import java.util.Arrays;

public class P_Greedy_Island {

	public static void main(String[] args) {
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		int n = 4;
		System.out.println(solution(n, costs));
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int price = 0;
		int complete = 0;
		Arrays.sort(costs, (a, b) -> a[2] - b[2]);  //정렬 람다식 사용 Comparator

		boolean[] check = new boolean[costs.length];
		boolean[] ok = new boolean[n];
		ok[costs[0][0]] = true;
		ok[costs[0][1]] = true;
		check[0] = true;
		price = costs[0][2];
		complete = 2;


		while (complete < n) {
			for (int i = 1; i < check.length; i++) {
				if (!check[i] && ((ok[costs[i][0]] && !ok[costs[i][1]]) || (ok[costs[i][1]] && !ok[costs[i][0]]))) {
					check[i] = true;
					ok[costs[i][0]] = true;
					ok[costs[i][1]] = true;
					complete++;
					price += costs[i][2];
					break;
				}
			}
		}

		answer = price;
		return answer;
	}
}
