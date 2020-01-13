package review_2020_winter;

import java.util.Stack;

public class P_StackQueue_Iron {

	public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));
	}

	static int solution(String arrangement) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		char[] arr = arrangement.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			}
			else if (arr[i] == ')') {
				stack.pop();
				if(arr[i-1]=='(') {
					answer+=stack.size();
				}
				else {
					answer+=1;
				}
			}
		}
		return answer;
	}
}
