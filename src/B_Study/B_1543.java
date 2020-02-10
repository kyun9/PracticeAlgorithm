package B_Study;

import java.util.Scanner;

public class B_1543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String cmp = sc.nextLine();
		int result=0;
		
		while(true) {
			int idx = s.indexOf(cmp);
			if(idx>-1) {
				result++;
				s= s.substring(s.indexOf(cmp)+cmp.length(), s.length());
			}
			else {
				break;
			}
		}
		System.out.println(result);
		sc.close();
	}

}
