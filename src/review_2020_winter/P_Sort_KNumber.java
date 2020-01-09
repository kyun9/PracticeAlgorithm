package review_2020_winter;

import java.util.ArrayList;
import java.util.Collections;

public class P_Sort_KNumber {

	public static void main(String[] args) {
		System.out.println(
				solution(new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } }));
	}

	static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};

		answer = new int[commands.length];
		ArrayList<Integer> list;
		for (int i = 0; i < commands.length; i++) {
			list = new ArrayList<>();
			for (int k = commands[i][0] - 1; k <= commands[i][1] - 1; k++) {
				list.add(array[k]);
			}
			Collections.sort(list);
			answer[i]=list.get(commands[i][2]-1);
		}
		return answer;
	}
}
