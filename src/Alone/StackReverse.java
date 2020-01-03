package Alone;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StackReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 3; i++) {
			stack.push(sc.nextInt());
		}
		System.out.println("Reverse Before");
		System.out.println(stack);

		stack = reverseStack(stack);
		
		System.out.println("Reverse After");
		System.out.println(stack);
		
		reverseOrderStack(stack);

		System.out.println("ReverseOrder After");
		System.out.println(stack);
		
	}

	static void reverseOrderStack(Stack<Integer> stack) {
		stack.sort(Collections.reverseOrder());
	}
	
	static Stack<Integer> reverseStack(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<>();
		while(!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		
		return temp;
	}

}
