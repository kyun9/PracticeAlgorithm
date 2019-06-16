package B_Study;

import java.util.Scanner;
import java.util.Stack;

public class B_Stack_1406 {
	
	public static void main(String[] args) {
		Stack<Character> stack= new Stack<>();
		Stack<Character> stmp= new Stack<>();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int size = sc.nextInt();
		
		char[] c =s.toCharArray();
		for(char i : c) {
			stack.push(i);
		}
		
		String[] str=null;
		while(size-- >= 0) {
			str=sc.nextLine().split(" ");
			
			
			if(str[0].equals("P")) {
				stack.push(str[1].charAt(0));
			}
			else if(str[0].equals("L")){
				if(!stack.isEmpty())
					stmp.push(stack.pop());
			}
			else if(str[0].equals("D")){
				if(!stmp.isEmpty())
					stack.push(stmp.pop());
			}
			else if(str[0].equals("B")){
				if(!stack.isEmpty())
					stack.pop();
			}
		}
		sc.close();
		
		
		if(!stmp.isEmpty()) {
			while(!stmp.isEmpty()) {
				stack.push(stmp.pop());
			}
		}
		
		String answer="";
		for(char a : stack) {
			answer+=a;
		}
		System.out.println(answer);
	}
}
