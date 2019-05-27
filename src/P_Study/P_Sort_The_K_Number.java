package P_Study;

import java.util.ArrayList;
import java.util.Collections;

public class P_Sort_The_K_Number {

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] b = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		Solution_1 s = new Solution_1();
		s.solution(a, b);
	}
}

class Solution_1 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		ArrayList<Integer> al = new ArrayList<>();
		int n = 0, i = 0;
		int size = commands.length;
		answer = new int[size];
		while (size > i) {
			if (commands[i][0] == commands[i][1]) {
				answer[n] = array[commands[i][0] - 1];
			} else {
				for (int k = commands[i][0] - 1; k < commands[i][1]; k++) {
					al.add(array[k]);
				}
				Collections.sort(al);
				answer[n] = al.get(commands[i][2] - 1);
			}
			n++;
			i++;
			al.clear();
		}
		for (int a : answer) {
			System.out.println(a);
		}

		return answer;
	}
}
//����� ��
//array					commands							return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
//����� �� ����
//[1, 5, 2, 6, 3, 7, 4]�� 2��°���� 5��°���� �ڸ� �� �����մϴ�. [2, 3, 5, 6]�� �� ��° ���ڴ� 5�Դϴ�.
//[1, 5, 2, 6, 3, 7, 4]�� 4��°���� 4��°���� �ڸ� �� �����մϴ�. [6]�� ù ��° ���ڴ� 6�Դϴ�.
//[1, 5, 2, 6, 3, 7, 4]�� 1��°���� 7��°���� �ڸ��ϴ�. [1, 2, 3, 4, 5, 6, 7]�� �� ��° ���ڴ� 3�Դϴ�.



//import java.util.Arrays;
//class Solution {
//    public int[] solution(int[] array, int[][] commands) {
//        int[] answer = new int[commands.length];
//
//        for(int i=0; i<commands.length; i++){
//            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//            Arrays.sort(temp);
//            answer[i] = temp[commands[i][2]-1];
//        }
//
//        return answer;
//    }
//}