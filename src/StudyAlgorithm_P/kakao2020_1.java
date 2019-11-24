package StudyAlgorithm_P;

import java.util.Stack;

public class kakao2020_1 {
	static int pos;

	public static void main(String[] args) {
//		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
//		System.out.println(solution("()))((()"));
	}

	public static String solution(String p) {
		if (p.isEmpty())
			return p;

		boolean correct = isCorrect(p);

		String u = p.substring(0, pos);
		String v = p.substring(pos, p.length());

		if (correct) {
			return u + solution(v);
		}

		String answer = "(" + solution(v) + ")";
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				answer += ")";
			} else
				answer += "(";
		}

		return answer;
	}

	static boolean isCorrect(String str) {
		boolean ret = true;
		int left = 0, right = 0;
		Stack<Character> mystack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
				mystack.push('(');
			} else {
				right++;
				if (mystack.isEmpty())
					ret = false;
				else
					mystack.pop();
			}
			if (left == right) {
				pos = i + 1;
				return ret;
			}
		}
		return true;
	}
}
