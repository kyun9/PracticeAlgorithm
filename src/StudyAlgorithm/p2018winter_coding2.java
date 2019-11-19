package StudyAlgorithm;

import java.util.*;

public class p2018winter_coding2 {

	public static void main(String[] args) {
//		System.out.println(solution(new int[] { 1, 1, 2, 3 }));
//		System.out.println(solution(new int[] { 2,2,3,3,6}));
//		System.out.println(solution(new int[] { 2,8,10}));
		System.out.println(solution(new int[] { 1,1,1,1}));
//		System.out.println(solution(new int[] { 1, 2, 4, 5 }));
	}

	
	
	
	
// 내가 푼 오답  ==> dp로 접근해야 됬음
//	public static int solution(int[] cookie) {
//		int answer = -1;
//
//		ArrayList<Integer> list = new ArrayList<Integer>();
//
//		int sum = 0;
//		for (int i : cookie) {
//			list.add(i);
//			sum+=i;
//		}
//
//		boolean flag =false;
//		while (!list.isEmpty()) {
//
//			if (sum % 2 == 0) {
//				int value = sum / 2;
//				if (list.contains(value)) {
//					flag=true;
//					answer = value;
//					break;
//				} else {
//					int temp = list.remove(0);
//					sum -= temp;
//				}
//			}
//			else {
//				int temp = list.remove(0);
//				sum -= temp;
//			}
//		}
//		
//		if(!flag) {
//			answer =0;
//		}
//		
//		return answer;
//	}
	public static int solution(int[] cookie) {
		int answer = -1;
		int max = 0;
		
		if(cookie.length<2) return 0;
		if(cookie.length==2) {
			if(cookie[0]==cookie[1]) {
				return cookie[0];
			}
			else return 0;
		}

		for (int i = 0; i < cookie.length - 1; i++) {
			int frontSum = cookie[i];
			int indexOfFrontSum = i;

			int backSum = cookie[i + 1];
			int indexOfBackSum = i + 1;

			while (true) {
				if (frontSum == backSum) {
					max = Math.max(frontSum, max);
				}
				if (indexOfFrontSum > 0 && frontSum <= backSum) {
					indexOfFrontSum--;
					frontSum += cookie[indexOfFrontSum];
				} else if (indexOfBackSum < cookie.length - 1 && frontSum >= backSum) {
					indexOfBackSum++;
					backSum += cookie[indexOfBackSum];
				} else
					break;
			}
		}
		answer = max;
		return answer;
	}
}
