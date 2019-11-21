package StudyAlgorithm;

import java.util.*;

public class kakao2020_1 {
	static String result;

	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
//		System.out.println(solution(")("));
//		System.out.println(solution("()))((()"));
	}

	public static String solution(String p) {
		String answer = "";

		char[] arr = p.toCharArray();
		ArrayList<Character> list = new ArrayList<>();
		for (char c : arr) {
			list.add(c);
		}
		int a = 0;
		while (true) {
			if (list.get(0) == '(') {
				list.remove(0);
				a++;
			} else if (list.get(0) == ')') {
				list.remove(0);
				a--;
			}
			if (a == 0) {
				break;
			}
		}
		for(char c :list) {
			answer+=c;
		}
		return answer;
	}
}
