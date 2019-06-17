package B_Study;

import java.util.LinkedList;
import java.util.Scanner;

public class B_Queue_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int find = sc.nextInt();
		sc.close();
		
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> answer = new LinkedList<>();
		for(int i=0;i<size;i++) {
			list.add(i+1);
		}
		int count=1;
		while(true) {
			if(list.size()==1)
				break;
			else if((count%find)==0) {
				answer.add(list.removeFirst());
				count=1;
			}
			
			list.add(list.removeFirst());
			
			count++;
		}
		
		answer.add(list.removeFirst());
		
		System.out.print("<");
		for(int i=0;i<answer.size();i++) {
			System.out.print(answer.get(i));
			if(i!=answer.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
}
