package B_Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_String_11656 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			list.add(s.substring(i));
		}
		Collections.sort(list);
		for(String a :list)
			System.out.println(a);
	}
	
}
