package B_Study;

import java.util.Scanner;

public class B_1254 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		char[] S = s.toCharArray();
		char[] R = new StringBuilder(s).reverse().toString().toCharArray();

		int length = S.length;

		int result = 1001;
		int cnt = 0;
		boolean flag = true;
		for (int i = 0; i < length; i++) {
			cnt = 0;
			flag = true;

			for (int j = 0; j < length - i; j++) {
				if (S[i + j] == R[j]) {
					cnt++;
				} else {
					flag = false;
					break;
				}
			}
			if (cnt > 0 && flag) {
				cnt = length - cnt;
				result = Math.min(result, cnt);
			}
		}

		result += length;
		System.out.println(result);
		sc.close();
	}

}
