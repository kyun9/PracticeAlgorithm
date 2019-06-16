package B_Study;

import java.util.Scanner;
import java.util.Stack;

public class B_Stack_10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();

		System.out.println(number(arr));
		sc.close();

	}

	public static int number(char[] arr) {
		Stack<Character> stack = new Stack<>();
		int size=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			} else if (arr[i] == ')') {
				stack.pop();
				if (arr[i - 1] == '(') {
					size+=stack.size();
				}
				else {
					size++;
				}

			}
		}
		return size;
	}
}
