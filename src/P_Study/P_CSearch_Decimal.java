package P_Study;

import java.util.HashSet;

public class P_CSearch_Decimal {
	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

	public static int solution(String numbers) {
		int answer = 0;
		int[] num = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++)
			num[i] = Integer.valueOf(String.valueOf(numbers.charAt(i)));

		HashSet<Integer> hash = new HashSet<>();
		int[] result;
		for (int i = 1; i < num.length + 1; i++) {
			result = new int[i];
			perm(num, i, 0, result, hash);
		}
		return answer;
	}

	static void perm(int[] num, int r, int depth, int[] result, HashSet<Integer> hash) {
		if (depth == r) {
			print(result, hash);
			findDecimal(hash);
			return;
		}
		for (int i = depth; i < num.length; i++) {
			swap(num, i, depth);
			result[depth] = num[depth];
			perm(num, r, depth + 1, result, hash);
			swap(num, depth, i);
		}
	}

	static void swap(int[] num, int i, int depth) {
		int temp = num[i];
		num[i] = num[depth];
		num[depth] = temp;
	}

	static void print(int[] result, HashSet<Integer> hash) {
		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i);
		}
		hash.add(Integer.valueOf(sb.toString()));
	}

	static void findDecimal(HashSet<Integer> hash) {
		System.out.println(hash);
		for (int i : hash) {
			int size = (int) (Math.sqrt(i));
			if (size == 1) {
				hash.remove(i);
			} else {
				for (int a = 2; a <= size; a++) {
					if(i%a==0) {
						hash.remove(i);
					}
				}
			}
		}
	}

}