package B_Study;

import java.util.LinkedList;
import java.util.Scanner;

public class B_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> resultList = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		
		int count=1;
		while(true) {
			if(list.size()==1) {
				break;
			}
			else if((count%K)==0) {
				resultList.add(list.removeFirst());
				count=1;
			}
			else {
				list.add(list.removeFirst());
				count++;
			}
		}
		
		resultList.add(list.poll());
		System.out.print("<");
		for(int i=0;i<resultList.size();i++) {
			System.out.print(resultList.get(i));
			if(i!=resultList.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}

}
