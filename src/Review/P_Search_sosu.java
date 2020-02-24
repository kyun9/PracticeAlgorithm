package Review;

import java.util.HashSet;

public class P_Search_sosu {

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

	static int result = 0;
	static HashSet<Integer> set;
	public static int solution(String numbers) {
		int answer = 0;

		char[] c = numbers.toCharArray();

		int size = c.length;
		result = 0;
		boolean[] visited = new boolean[size];
		int[] output ;
		set = new HashSet<>();
		for (int i = 1; i <= size; i++) {
			 output  = new int[i];
			perm(c, visited, 0, size, i, output);
		}
		answer = result;
		return answer;
	}

	static void perm(char[] c, boolean[] visited, int depth, int n, int r, int[] output) {
		if (depth == r) {
			String s ="";
			for(int i: output) {
				s+=i;
			}
			int num = Integer.parseInt(s);
			if(!set.contains(num)) {
				set.add(num);
				findPrime(num);
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth]=c[i]-'0';
				perm(c, visited, depth + 1, n, r, output);
				visited[i] = false;
			}
		}
	}

	static void findPrime(int num) {
		if (num == 0 || num == 1)
			return;
		else if (num == 2 || num == 3) {
			result++;
			return;
		}
		int v = (int) (Math.sqrt(num));
		for (int i = 2; i <= v; i++) {
			if (num % i == 0)
				return;
		}
		result++;
	}
}
