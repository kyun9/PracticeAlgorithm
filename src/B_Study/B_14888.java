package B_Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_14888 {
	static int N;
	static int[] nums ;
	static int[] op= new int[4];
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}

		list = new ArrayList<>();
		dfs(1, nums[0]);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}

	static void dfs(int depth, int sum) {
		if(depth==N) {
			list.add(sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i] -= 1;

				switch (i) {
				case 0:
					dfs(depth+1,sum+nums[depth]);
					break;
				case 1:
					dfs(depth+1,sum-nums[depth]);
					break;
				case 2:
					dfs(depth+1,sum*nums[depth]);
					break;
				case 3:
					dfs(depth+1,sum/nums[depth]);
					break;

				}
				op[i]+=1;
			}
		}
		
	}
}
