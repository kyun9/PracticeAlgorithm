package coding_2020;

import java.util.Stack;

public class a_line {

	public static void main(String[] args) {
		System.out.println(solution("Hello, world!"));
		System.out.println(solution("line [plus]"));
		System.out.println(solution("if (Count of eggs is 4.) {Buy milk.}"));
		System.out.println(solution(">_<"));
	}

	static public int solution(String inputString) {
		int answer = -1;

		Stack<Character> stack = new Stack<>();

		char[] ch = inputString.toCharArray();
		int result = 0;
		for (char c : ch) {
			if (c == '[') {
				stack.push(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == '<') {
				stack.push(c);
			} else if (c == '{') {
				stack.push(c);

			}

			else if (c == ']') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '[') {
						result++;
					}
				} else {
					result = -1;
					break;
				}
			} else if (c == ')') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '(') {
						result++;
					}
				} else {
					result = -1;
					break;
				}
			} else if (c == '>') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '<') {
						result++;
					}
				} else {
					result = -1;
					break;
				}
			} else if (c == '}') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '{') {
						result++;
					}
				} else {
					result = -1;
					break;
				}
			}
		}

		answer = result;
		return answer;
	}
}
