package Collections;

import java.util.*;

public class B_10828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			String[] st1 = (sc.nextLine().split(" "));
			if (st1[0].equals("pop")) {
				if(s.empty()) {
					System.out.println("-1");
				}
				else
					System.out.println(s.pop());
			}
			else if (st1[0].equals("push")) {
				s.push(Integer.parseInt(st1[1]));
			}
			else if (st1[0].equals("top")) {
				if(s.empty()) {
					System.out.println("-1");
				}
				else
					System.out.println(s.peek());
			}
			else if (st1[0].equals("size")) {
				System.out.println(s.size());
			}
			else if (st1[0].equals("empty")) {
				if(s.empty()) {
					System.out.println("1");
				}
				else
					System.out.println("0");
				
			}
		}
		sc.close();
	}

}
