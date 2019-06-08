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
		} //리스트에 거꿀로 대입
		answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			for (int j = i + 1; j < al.size(); j++) {
				if (al.get(i) < al.get(j)) {
					answer[i] = j;
					break;//전 인덱스 대입
				} else {
					answer[i] = 0;
				}
			}
		}//나머지0

		for (int i = 0; i < answer.length; i++) {
			if (answer[i] > 0) {
				answer[i] = answer.length - answer[i];
			}
		}//다시 길이에서 뺴주기
		int tmp = 0;
		for (int i = 0; i < answer.length/2; i++) {
			tmp = answer[i];
			answer[i]= answer[answer.length-1-i];
			answer[answer.length-1-i]= tmp;
		}//다시 거꿀로
		
		for(int a : answer) {
			System.out.println(a);
		}
		return answer;
	}
}
//정답 풀이 너무 간단하자나
//class Solution {
//    public int[] solution(int[] heights) {
//        int[] answer = new int[heights.length];
//
//        for (int i=0; i<heights.length; i++){
//            for (int j=i+1; j<heights.length; j++){
//                if (heights[i] > heights[j]){
//                    answer[j]=i+1;
//                }
//            }
//        }
//
//
//        return answer;
//    }
//}
