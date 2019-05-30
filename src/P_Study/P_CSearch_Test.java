package P_Study;

import java.util.ArrayList;
import java.util.Collections;

public class P_CSearch_Test {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};

		//���� ���� �������� list
		ArrayList<Integer> list = new ArrayList<>();
		
		//��Ģ�� ���߹迭����
		int[][] people = { { 1, 2, 3, 4, 5 },
				{ 2, 1, 2, 3, 2, 4, 2, 5 },
				{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		
		//list 0���� �ʱ�ȭ
		for(int i=0;i<people.length;i++) {
			list.add(0);
		}

		//list ���� ���� �Է�
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
		//���� ���� ���� �� ����
		int max = Collections.max(list);
		
		//�迭�� ����� �˼� ��� ArrayList��� 
		ArrayList<Integer> result = new ArrayList<>();
		
		// ���� ������ �� �ֳ� Ȯ��
		for(int i=0;i<list.size();i++) {
			if(max==list.get(i)) {
				result.add(i+1);
			}
		}
		
		//return ���� answer�� ������ 
		answer = new int[result.size()];

		//ArrayList���� answer�迭�� �ű�
		for(int i=0;i<result.size();i++) {
			answer[i]=result.get(i);
		}
		
		
		return answer;
	}
}
