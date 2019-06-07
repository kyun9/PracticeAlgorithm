package Alone;

import java.util.Arrays;



//ArrayList가 아닌 swap이라는 메소드를 이용하여 
// 재귀하면 값을 구해준다.



class Permutation_4 {

	private int n; // nPr의 n
	private int r; // nPr의 r
	private int[] res;

	// 초기화
	public Permutation_4(int n, int r) {
		this.n = n;
		this.r = r;
		res = new int[r];
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void perm(int[] arr, int depth) {

		// depth가 0부터 시작했을 경우 depth == r에서 리턴
		if (depth == r) {
			System.out.println(Arrays.toString(res));
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i); // 스왑
			res[depth] = arr[depth]; // 선택된 원소 저장
			perm(arr, depth + 1); // 재귀호출
			swap(arr, depth, i); // 복원
		}
	}

}

public class Permutation_swap_Deduplication {

	public static void main(String[] args) {
		int r = 3;
		int[] arr = { 1, 2, 3};

		Permutation_4 main = new Permutation_4(arr.length, r);
		main.perm(arr, 0);

	}

}
