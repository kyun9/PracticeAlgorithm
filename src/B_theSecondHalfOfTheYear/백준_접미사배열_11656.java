package B_theSecondHalfOfTheYear;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_접미사배열_11656 {
	static String[] str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		
		str = new String[n];
		
		for (int i = 0; i < n; i++) {
			str[i] = s.substring(i);
		}

		Arrays.sort(str);
		for (int i = 0; i < n; i++) {
			System.out.println(str[i]);
		}
	}

}
