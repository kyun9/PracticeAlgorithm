package P_Study;

import java.util.ArrayList;

public class P_Queue_Top {

	public static void main(String[] args) {
		int[] arr = {3,9,9,3,5,7,2};
		System.out.println(solution(arr));
	}

	public static int[] solution(int[] heights) {
		int[] answer = {};
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < heights.length; i++) {
			al.add(heights[heights.length - i - 1]);
		}
		answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			for (int j = i + 1; j < al.size(); j++) {
				if (al.get(i) < al.get(j)) {
					answer[i] = j;
					break;
				} else {
					answer[i] = 0;
				}
			}
		}

		for (int i = 0; i < answer.length; i++) {
			if (answer[i] > 0) {
				answer[i] = answer.length - answer[i];
			}
		}
		int tmp = 0;
		for (int i = 0; i < answer.length/2; i++) {
			tmp = answer[i];
			answer[i]= answer[answer.length-1-i];
			answer[answer.length-1-i]= tmp;
		}
		
		for(int a : answer) {
			System.out.println(a);
		}
		return answer;
	}
}
