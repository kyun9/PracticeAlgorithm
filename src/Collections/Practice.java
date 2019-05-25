package Collections;

import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("1");
		s.push("2");
		s.pop();
		
		System.out.println(s.size());
	}

}
