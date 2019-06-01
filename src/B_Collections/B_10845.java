package B_Collections;

import java.util.LinkedList;
import java.util.Scanner;

public class B_10845 {

	public static void main(String[] args) {
		LinkedList<Integer> qu = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String[] s=null;
		sc.nextLine();
		
		
		while(size>0) {
			s=sc.nextLine().split(" ");
			if(s[0].equals("push")) {
				qu.add(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("pop")) {
				if(qu.isEmpty())
					System.out.println("-1");
				else
					System.out.println(qu.poll());
			}
			else if(s[0].equals("size")) {
				System.out.println(qu.size());
			}
			else if(s[0].equals("empty")) {
				if(qu.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			}
			else if(s[0].equals("front")) {
				if(qu.isEmpty())
					System.out.println("-1");
				else
					System.out.println(qu.peek());
			}
			else if(s[0].equals("back")) {
				if(qu.isEmpty())
					System.out.println("-1");
				else
				System.out.println(qu.get(qu.size()-1));
			}
			size--;
		}
		sc.close();
	}

}
