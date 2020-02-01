package review_2020_winter;

import java.util.ArrayList;

public class P_Develope {

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		System.out.println(solution(progresses, speeds));
	}

	static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};

		int size = progresses.length;
		int[] days = new int[size];
		for (int i = 0; i < size; i++) {
			days[i] = (int) Math.ceil((100 - progresses[i]) / (float) speeds[i]);

		}

		boolean[] check = new boolean[size];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < days.length; i++) {
			int cnt = 0;
			for (int j = 0; j < days.length; j++) {
				if (days[i] >= days[j] && !check[j]) {
					check[j] = true;
					cnt++;
				}
				if(days[i]<days[j]) {
					break;
				}
			}
			list.add(cnt);
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i)!=0) {
				result.add(list.get(i));
			}
		}
		answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}
}
