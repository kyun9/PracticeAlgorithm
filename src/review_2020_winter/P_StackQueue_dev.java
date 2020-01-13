package review_2020_winter;

import java.util.ArrayList;

public class P_StackQueue_dev {

	public static void main(String[] args) {
//		System.out.println(solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 }));
//		System.out.println(solution(new int[] { 40, 93, 30, 55, 60, 65 }, new int[] { 60, 1, 30, 5 , 10, 7 }));
		System.out.println(solution(new int[] {93, 30, 55, 60, 40, 65}, new int[] { 1, 30, 5 , 10, 60, 7 }));
	}

	static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};

		int size = progresses.length;
		int[] days = new int[size];
		for (int i = 0; i < size; i++) {
			int day = (int) Math.ceil((100 - progresses[i]) / (float)speeds[i]);
			days[i] = day;
		}

		
		for(int i : days) {
			System.out.println(i);
		}
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] check = new boolean[size];
		for (int i = 0; i < days.length; i++) {
			int tmp = days[i];
			int cnt = 0;
			for (int j = 0; j < days.length; j++) {
				if (tmp >= days[j] && !check[j]) {
					check[j] = true;
					cnt++;
				}
				if(tmp<days[j]) {
					break;
				}
			}
			list.add(cnt);
		}
		System.out.println("list " + list);
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != 0) {
				result.add(list.get(i));
			}
		}
		System.out.println("result "+ result);
		answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}
