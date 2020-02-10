package B_Study;

import java.util.Scanner;
import java.util.Stack;

public class B_2810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = new char[N];
		Stack<Character> stack = new Stack<>();
		int cnt = 0;

		sc.nextLine();
		arr = sc.nextLine().toCharArray();

		
		if(N==1) {
			if(arr[0]=='S') {
				System.out.println(2);
				return;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				cnt++;
				if (arr[i] == 'L') {
					stack.push('L');
				}
			} else if (0 < i && i < N - 1) {
				if (arr[i] == 'S') {
					cnt++;
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						cnt++;
						stack.push('L');
					}
				}
			} else {
				if (arr[i] == 'S') {
					cnt += 2;
				} else {
					cnt++;
				}
			}
		}
		if(cnt>N) {
			System.out.println(N);
			return;
		}
		System.out.println(cnt);
	}

}
