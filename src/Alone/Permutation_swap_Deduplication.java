package Alone;

import java.util.Arrays;



//ArrayList�� �ƴ� swap�̶�� �޼ҵ带 �̿��Ͽ� 
// ����ϸ� ���� �����ش�.



class Permutation_4 {

	private int n; // nPr�� n
	private int r; // nPr�� r
	private int[] res;

	// �ʱ�ȭ
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

		// depth�� 0���� �������� ��� depth == r���� ����
		if (depth == r) {
			System.out.println(Arrays.toString(res));
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i); // ����
			res[depth] = arr[depth]; // ���õ� ���� ����
			perm(arr, depth + 1); // ���ȣ��
			swap(arr, depth, i); // ����
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
