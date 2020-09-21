package B_theSecondHalfOfTheYear;

import java.util.Stack;

public class 프로그래머스_올바른괄호 {

	public static void main(String[] args) {
		String s = "()()";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			} else {
				if (stack.isEmpty()) {
					answer = false;
					break;
				} else {
					if (stack.peek() == '(') {
						stack.pop();
					}
				}
			}
		}

		if (!stack.isEmpty()) {
			answer = false;
		}

		return answer;
	}
}
