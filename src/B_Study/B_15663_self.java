package B_Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class B_15663_self {
	static int[] nums = new int[8];
	static boolean[] check = new boolean[8];
	static HashSet<String> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		String s = "";
		set = new HashSet<>();
		dfs(0, N, M, arr, s);

		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);

		for (String st : list) {
			System.out.println(st);
		}
	}

	static void dfs(int depth, int n, int m, int[] arr, String s) {
		if (depth == m) {
			set.add(s);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (check[i])
				continue;
			check[i] = true;
			nums[depth] = arr[i];
			dfs(depth + 1, n, m, arr, s + nums[depth]+" ");
			check[i] = false;
		}
	}
}
