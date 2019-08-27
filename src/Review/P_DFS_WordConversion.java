package Review;

import java.util.ArrayList;

public class P_DFS_WordConversion {
	static int find;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;

		ArrayList<String> list = new ArrayList<String>();
		for (String s : words)
			list.add(s);

		if (!list.contains(target))
			answer = 0;

		dfs(begin, target, words, 0);
		answer = find;
		return answer;
	}

	static void dfs(String begin, String target, String[] words, int depth) {

		for (int a = depth; a < words.length; a++) {
			int cnt = 0;
			int tcnt = 0;
			for (int i = 0; i < words[a].length(); i++) {
				if (begin.charAt(i) == words[a].charAt(i)) {
					cnt++;
				}
				if (begin.charAt(i) == target.charAt(i)) {
					tcnt++;
				}
			}
			if (tcnt == 3) {
				find = depth + 1;
				return;
			}
			if (cnt == 2) {
				dfs(words[depth], target, words, depth + 1);
				return;
			}
		}
	}
}