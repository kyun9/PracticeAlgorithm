package B_Study;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class B_Stack_9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		String tmp=null;
		char[] arr=null;
		ArrayList<Boolean> al = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		sc.nextLine();

		while(size-->0) {
			tmp=sc.nextLine();
			arr=tmp.toCharArray();
			for(int j=0;j<arr.length;j++) {
				if(arr[j]=='(')
					stack.push(arr[j]);
				else if(arr[j]==')') {
					if(stack.isEmpty()) {
						stack.push(arr[j]);
					}
					if(stack.peek()=='(')
						stack.pop();
				}
			}
			if(stack.isEmpty())
				al.add(true);
			else al.add(false);
			stack.clear();
		}
		
		for(int i=0;i<al.size();i++) {
			if(al.get(i)==true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}

}
