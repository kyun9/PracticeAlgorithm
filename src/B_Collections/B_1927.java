package B_Collections;

import java.util.PriorityQueue;
import java.util.Scanner;
public class B_1927 {

	public static void main(String[] args) {
		PriorityQueue<Integer> qu = new PriorityQueue<>();
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int num=0;
		
		while(size -- >0) {
			num = sc.nextInt();
			if(num ==0) {
				if(qu.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(qu.poll());
				}
			}
			else
				qu.offer(num);
		}
		
		sc.close();
		
		
	}

}
