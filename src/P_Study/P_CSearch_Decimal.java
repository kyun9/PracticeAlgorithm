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
		answer=hash.size();
		return answer;
	}

	static void perm(int[] num, int r, int depth, int[] result, HashSet<Integer> hash) {
		if (depth == r) {
			print(result, hash);
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
		int value=Integer.valueOf(sb.toString());
		findDecimal(value,hash);
	}

	static void findDecimal(int value,HashSet<Integer> hash) {
			int v = (int) (Math.sqrt(value));
			if (v == 1) {
				return;
			} else {
				for (int i = 2; i <= v; i++) 
					if(value%i==0) return;
				hash.add(value);
			}
	}

}