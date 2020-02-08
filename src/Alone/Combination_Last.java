package Alone;

import java.util.ArrayList;

public class Combination_Last {
	static ArrayList<Integer> arrList = new ArrayList<>();
	static int arr[] = { 1, 2, 3, 4 };

	public static void main(String[] args) {
		int n = 4;
		int[] arr = { 1, 2, 3, 4 };
		boolean[] visited = new boolean[n];

		// 1
		System.out.println("재귀를 활용한 combiation");
		comb(arr, visited, 0, n, 3);
		System.out.println();
		// 2
		System.out.println("백트래킹을 활용한 combination");
		visited = new boolean[n];
		combination(arr, visited, 0, n, 3);
		System.out.println();

		// 3
		System.out.println("visited 배열의 true 여부와 다른  list에 담은 조합");
		combination(arrList, arr.length, 3, 0);
		System.out.println();

		// 4
		System.out.println("visited 배열의 true 여부와 다른  list에 담은  중복조합");
		arrList = new ArrayList<>();
		combination_repetition(arrList, arr.length, 3, 0);
	}

	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}
		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	// visited 배열을 이용해서 true 인 경우만 print()함수를 이용해서 출력해주는 거니까 판단해 주는거니까
	// 즉 중복 조합을 구하고 싶으면 list에 담을 arr배열의 위치를 가르키는
	// index라는 변수를 arr배열의 위치를 옮겨 담으면 됨

	static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}
		if (depth == n) {
			return;
		}

		visited[depth] = true;
		comb(arr, visited, depth + 1, n, r - 1);
		visited[depth] = false;
		comb(arr, visited, depth + 1, n, r);
	}

	static void print(int[] arr, boolean[] visited, int n) {
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	// 리스트에 담은 조합 함수
	public static void combination(ArrayList<Integer> arrList, int n, int r, int index) {
		if (r == 0) {
			for (int i = 0; i < arrList.size(); i++) {
				System.out.print(arrList.get(i) + " ");
			}
			System.out.println();
			return;
		}
		if (index == n)
			return;
		arrList.add(arr[index]);
		combination(arrList, n, r - 1, index + 1); // 뽑았음-> r-1
		arrList.remove(arrList.size() - 1); // 위에서 뽑은거 롤백
		combination(arrList, n, r, index + 1); // 안뽑았으니 r
	}

	public static void combination_repetition(ArrayList<Integer> arrList, int n, int r, int index) {
		if (r == 0) {
			for (int i = 0; i < arrList.size(); i++) {
				System.out.print(arrList.get(i) + " ");
			}
			System.out.println();
			return;
		}

		if (index == n)
			return;
		arrList.add(arr[index]);
		combination_repetition(arrList, n, r - 1, index); // 뽑았음-> r-1 중복을 허용하니까 index는 고정
		arrList.remove(arrList.size() - 1); // 위에서 뽑은거 롤백
		combination_repetition(arrList, n, r, index + 1); // 안뽑았으니 r, index+1
	}
}
