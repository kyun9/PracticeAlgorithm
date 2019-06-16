package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_Stack_1406 {

	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		Stack<Character> stmp = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size = Integer.parseInt(br.readLine());
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		String[] str = null;
		while (size-- > 0) {
			str = br.readLine().split(" ");
			char what = str[0].charAt(0);
			
			if (what == 'P') {
				stack.push(str[1].charAt(0));
			} else if (what == 'L') {
				if (!stack.isEmpty())
					stmp.push(stack.pop());
			} else if (what == 'D') {
				if (!stmp.isEmpty())
					stack.push(stmp.pop());
			} else if (what == 'P') {
				if (!stack.isEmpty())
					stack.pop();
			}
		}

		while (!stmp.isEmpty()) {
			stack.push(stmp.pop());
		}

		String answer = "";
		for (char a : stack) {
			answer += a;
		}
		System.out.println(answer);
	}
}
