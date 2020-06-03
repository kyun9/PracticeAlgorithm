package coding_2020;

import java.util.HashSet;

public class s_summercoding1 {

	public static void main(String[] args) {
		System.out.println(solution(1987));
		System.out.println(solution(2015));
	}

	static public int solution(int p) {
		int answer = 0;

		char[] parr;
		HashSet<Character> set = new HashSet<>();
		while (true) {
			p++;
			parr = Integer.toString(p).toCharArray();
			set.clear();
			for (int i = 0; i < parr.length; i++) {
				set.add(parr[i]);
			}
			if (set.size() == parr.length) {
				break;
			}
		}

		answer = p;
		return answer;
	}
}
