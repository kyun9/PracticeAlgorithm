package StudyAlgorithm_P;

import java.util.ArrayList;
import java.util.Stack;

public class P2018kakao_다트게임 {

	public static void main(String[] args) {
		String dartResult1 = "1S2D*3T";
		String dartResult2 = "1D2S#10S";
		String dartResult3 = "1D2S0T";
		String dartResult4 = "1S*2T*3S";
		String dartResult5 = "1D#2S*3S";
		String dartResult6 = "1T2D3D#";
		String dartResult7 = "1D2S3T*";
		System.out.println(solution(dartResult1));
		System.out.println(solution(dartResult2));
		System.out.println(solution(dartResult3));
		System.out.println(solution(dartResult4));
		System.out.println(solution(dartResult5));
		System.out.println(solution(dartResult6));
		System.out.println(solution(dartResult7));
	}

	static public int solution(String dartResult) {
		int answer = 0;

		ArrayList<Character> list = new ArrayList<>();

		for (int i = 0; i < dartResult.length(); i++) {
			list.add(dartResult.charAt(i));
		}

		int num = 0;
		Stack<Integer> stack = new Stack<>();
		boolean flag = false;
		boolean check = false;
		
		while (!list.isEmpty()) {
			char c = list.remove(0);
			switch (c) {
			case 'S':
				num = (int) Math.pow(num, 1);
				flag = true;
				break;
			case 'D':
				num = (int) Math.pow(num, 2);
				flag = true;
				break;
			case 'T':
				num = (int) Math.pow(num, 3);
				flag = true;
				break;
			case '*':
				if (!stack.isEmpty()) {
					int temp = stack.pop();
					stack.push(temp * 2);
				}
				num *= 2;
				break;
			case '#':
				num *= -1;
				break;
			default:
				if (flag) {
					flag = false;
					check = false;
					stack.push(num);
				}
				if (check) {
					num = 10;
				} else {
					num = c - '0';
					check = true;
				}
				break;
			}
		}

		if (flag) {
			stack.push(num);
		}
		for (int n : stack) {
			answer += n;
		}
		return answer;
	}
}
