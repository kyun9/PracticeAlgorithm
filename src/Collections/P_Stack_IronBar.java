package Collections;

import java.util.Stack;

class Solution {
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Character> stack = new Stack<Character>();
		char[] arr = arrangement.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			} 
			else if (arr[i] == ')') {
				stack.pop();
				if (arr[i - 1] == '(') {
					answer += stack.size();
				} else {
					answer += 1;
				}
			}
		}

		return answer;
	}
}

public class P_Stack_IronBar {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("()(((()())(())()))(())"));
	}

}
