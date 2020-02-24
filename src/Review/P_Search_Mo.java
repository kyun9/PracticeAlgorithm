package Review;

import java.util.ArrayList;
import java.util.Collections;

public class P_Search_Mo {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(solution(new int[] { 1,3,2,4,2}));
	}

	static int[] solution(int[] answers) {
		int[] answer = {};

		int[][] people = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<3;i++) {
			list.add(0);
		}
		
		for (int i = 0; i < answers.length; i++) {
			if (people[0][i % people[0].length] == answers[i]) {
				list.set(0, list.get(0)+1);
			}
			if (people[1][i % people[1].length] == answers[i]) {
				list.set(1, list.get(1)+1);
			}
			if (people[2][i % people[2].length] == answers[i]) {
				list.set(2, list.get(2)+1);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		int max = Collections.max(list);
		
		for(int i=0;i<list.size();i++) {
			if(max == list.get(i)) {
				result.add(i+1);
			}
		}
		
		answer = new int[result.size()];
		for(int i=0;i<result.size();i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

}
