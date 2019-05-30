package P_Study;

import java.util.ArrayList;
import java.util.Collections;

public class P_CSearch_Test {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};

		//정답 맞춘 갯수저장 list
		ArrayList<Integer> list = new ArrayList<>();
		
		//규칙을 이중배열생성
		int[][] people = { { 1, 2, 3, 4, 5 },
				{ 2, 1, 2, 3, 2, 4, 2, 5 },
				{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		
		//list 0으로 초기화
		for(int i=0;i<people.length;i++) {
			list.add(0);
		}

		//list 정답 갯수 입력
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == people[0][i%people[0].length]) {
				list.set(0, list.get(0)+1);
			}
			if (answers[i] == people[1][i%people[1].length]) {
				list.set(1, list.get(1)+1);
			}
			if (answers[i] == people[2][i%people[2].length]) {
				list.set(2, list.get(2)+1);
			}
		}
		//가장 많이 맞춘 값 저장
		int max = Collections.max(list);
		
		//배열의 사이즈를 알수 없어서 ArrayList사용 
		ArrayList<Integer> result = new ArrayList<>();
		
		// 많이 맞춘사람 또 있나 확인
		for(int i=0;i<list.size();i++) {
			if(max==list.get(i)) {
				result.add(i+1);
			}
		}
		
		//return 해줄 answer에 사이즈 
		answer = new int[result.size()];

		//ArrayList값을 answer배열로 옮김
		for(int i=0;i<result.size();i++) {
			answer[i]=result.get(i);
		}
		
		
		return answer;
	}
}
