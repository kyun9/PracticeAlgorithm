package review_2020_winter;

import java.util.ArrayList;
import java.util.Collections;

public class P_BiggiestNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 10, 2 }));
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
	}

	static String solution(int[] numbers) {
		String answer = "";

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list, (a, b) -> {
			String as = String.valueOf(a), bs = String.valueOf(b);
			return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
		});
		StringBuilder sb = new StringBuilder();
		for (Integer i : list) {
			sb.append(i);
		}
		answer = sb.toString();
		if (answer.charAt(0) == '0') {
			return "0";
		} else {
			return answer;
		}
	}
}
