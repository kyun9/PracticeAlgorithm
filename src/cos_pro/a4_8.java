package cos_pro;

import java.util.ArrayList;
import java.util.Collections;

public class a4_8 {
	static ArrayList<Integer> list = new ArrayList<>();

	public static int solution(int[] card, int n) {
		int answer = 0;
		int size = card.length;
		boolean[] visited = new boolean[size];
		int[] output = new int[size];

		list.clear();
		perm(size, size, 0, card, visited, output);
		Collections.sort(list);
		if (list.contains(n)) {
			answer = list.indexOf(n) + 1;
		} else {
			answer = -1;
		}
		return answer;
	}

	static void perm(int n, int r, int depth, int[] card, boolean[] visited, int[] output) {
		if (depth == r) {
			String s = "";
			for (int i = 0; i < n; i++) {
				s += output[i];
			}
			int val = Integer.parseInt(s);
			if (!list.contains(val)) {
				list.add(val);
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = card[i];
				perm(n, r, depth + 1, card, visited, output);
				visited[i] = false;
			}
		}
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int card1[] = { 1, 2, 1, 3 };
		int n1 = 1312;
		int ret1 = solution(card1, n1);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		int card2[] = { 1, 1, 1, 2 };
		int n2 = 1122;
		int ret2 = solution(card2, n2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
	}
}
