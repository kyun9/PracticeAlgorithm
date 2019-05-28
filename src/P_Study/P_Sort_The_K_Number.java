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
		int i = 0;
		int size = commands.length;
		answer = new int[size];
		while (size > i) {
			for (int k = commands[i][0] - 1; k < commands[i][1]; k++) {
				al.add(array[k]);
			}
			Collections.sort(al);
			answer[i] = al.get(commands[i][2] - 1);
			i++;
			al.clear();
		}
		for (int a : answer) {
			System.out.println(a);
		}

		return answer;
	}
}
//입출력 예
//array					commands							return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
//입출력 예 설명
//[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
//[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
//[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.



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
