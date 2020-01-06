package B_Study;

import java.util.Scanner;

public class B_1547 {
    static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		
		boolean[] cups = new boolean[4];
		cups[1]=true;
		
		for(int i=0;i<M;i++) {
			int n= sc.nextInt();
			int m = sc.nextInt();
			if(cups[n]) {
				cups[n]=false;
				cups[m]=true;
			}
			else if(cups[m]) {
				cups[m]=false;
				cups[n]=true;
			}
		}
		
		for(int i=1;i<4;i++) {
			if(cups[i]) {
				System.out.println(i);
			}
		}
	}

}
