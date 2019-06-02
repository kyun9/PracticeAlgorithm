package B_Collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class B_1927 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int num=0;
		LinkedList<Integer> list = new LinkedList<>();
		
		while(size>0) {
			num =sc.nextInt();
			
			if(num ==0) {
				Collections.sort(list);
				System.out.println(list.poll());
			}
			else {
				list.add(num);
			}
			
			
			size--;
		}
		sc.close();
	}

}
