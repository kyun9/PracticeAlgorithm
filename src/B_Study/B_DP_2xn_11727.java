package B_Study;

import java.util.Scanner;

public class B_DP_2xn_11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] list = new long[n + 1];

		list[0] = 1;
		list[1] = 1;
		for (int i = 2; i < list.length; i++) {
			list[i] = list[i - 2]*2 + list[i - 1];
			list[i] %= 10007;
		}
		System.out.println(list[n]);
	}
}
