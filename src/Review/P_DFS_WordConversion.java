package Review;


public class P_DFS_WordConversion {
	static boolean[] check;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		check = new boolean[words.length + 1];
		for (int i = 0; i < words.length; i++) {
			if (target.equals(words[i])) {
				return dfs(begin, target, words);
			}
		}
		return 0;
	}

	static int dfs(String begin, String target, String[] words) {
		int answer = 0;
		for (int i = 0; i < words.length; i++) {
			if (check[i])
				continue;

			int cnt = 0;
			int tcnt = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) != target.charAt(j)) {
					tcnt++;
				}
				if (begin.charAt(j) != words[i].charAt(j)) {
					cnt++;
				}
			}
			if (tcnt == 1) {
				return 1;
			}
			if (cnt == 1) {
				check[i]=true;
				answer = 1;
				answer += dfs(words[i], target, words);
			}

		}
		return answer;
	}
}