package StudyAlgorithm_SWEA;

import java.util.Scanner;

public class S_1206 {
	static int[] buildings;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test = 1; test <= 10; test++) {
			int T = sc.nextInt();

			buildings = new int[T];
			result = 0;
			for (int i = 0; i < T; i++) {
				buildings[i] = sc.nextInt();
			}

			for (int i = 2; i < T - 2; i++) {
				checkHeight(i);
			}

//		System.out.println(result);
			System.out.println("#" + test + " " + result);
		}
		sc.close();
	}

	static void checkHeight(int n) {
		int left = 0;
		int right = 0;
		boolean checkleft = false;
		boolean checkright = false;
		int val = 0;

//		System.out.println("n : "+n+" buildings[n-2] "+buildings[n-2]+" buildings[n-1] "+buildings[n-1]+" buildings[n] "+buildings[n]+" buildings[n+1] "+buildings[n+1]+" buildings[n+2] "+buildings[n+2]);
		if (buildings[n - 2] < buildings[n] && buildings[n - 1] < buildings[n]) {
			checkleft = true;
			if (buildings[n - 2] > buildings[n - 1]) {
				left = buildings[n] - buildings[n - 2];
			} else {
				left = buildings[n] - buildings[n - 1];
			}
		}
		if (buildings[n + 2] < buildings[n] && buildings[n + 1] < buildings[n]) {
			checkright = true;
			if (buildings[n + 2] > buildings[n + 1]) {
				right = buildings[n] - buildings[n + 2];
			} else {
				right = buildings[n] - buildings[n + 1];
			}
		}
//		System.out.println("left : "+ left+" right : "+right);
		if (checkleft && checkright) {
			if (left > right) {
				val = right;
			} else if (right > left) {
				val = left;
			} else if (right == left) {
				val = right;
			}
		} else {
			val = 0;
		}
		result += val;

	}
}
