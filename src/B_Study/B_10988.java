package B_Study;

import java.util.Scanner;

public class B_10988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		boolean check= false;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==s.charAt(s.length()-1-i)) {
				if(i>s.length()-1-i) {
					break;
				}
				check =true;
			}else {
				check= false;
				break;
			}
		}
		
		if(check) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
