package review_2020_winter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class S_3752 {
	static HashSet<Integer> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int size = sc.nextInt();
			int[] arr = new int[size];

			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}

			set = new HashSet<>();
			set.add(0);
			for (int i = 0; i < size; i++) {
				addHash(arr[i]);
			}


			System.out.println("#" + test + " " + set.size());
		}
	}

	static void addHash(int val) {
		HashSet<Integer> tmp = new HashSet<>();
		tmp.addAll(set);
		Iterator<Integer> it = tmp.iterator();
		while (it.hasNext()) {
			set.add(it.next() + val);
		}
	}
}
