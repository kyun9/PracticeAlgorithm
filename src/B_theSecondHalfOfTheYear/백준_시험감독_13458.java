package B_theSecondHalfOfTheYear;

import java.util.Scanner;

public class 백준_시험감독_13458 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int B = sc.nextInt();
		int C = sc.nextInt();

		long people = 0;
		for (int i = 0; i < N; i++) {
			int remain = arr[i] - B;
			people += 1;
			if (remain > 0) {
				people += Math.ceil((float) remain / C);
			}

		}

		System.out.println(people);
	}

}
