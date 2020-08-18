package B_theSecondHalfOfTheYear;

public class 프로그래머스_조이스틱 {

	public static void main(String[] args) {
		System.out.println(solution("JAZ"));System.out.println();
		System.out.println(solution("BBAAAAAAAAAABB"));
	}

	static int solution(String name) {
		// 1. 위, 아래 최소 이동
		int ans = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				int up = name.charAt(i) - 'A';
				int down = 1 + 'Z' - name.charAt(i);
				ans += (up < down) ? up : down;
			}
		}
		
		// 2. A 아닌 모든 문자를 들릴 수 있는 최소 좌우 이동
		// 모든 위치에서 역으로 돌아가는 경우 최소를 찾는다.
		int minMove = name.length() - 1;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				int next = i + 1;
				while (next < name.length() && name.charAt(next) == 'A') {
					next++;
				}
				int move = 2 * i + name.length() - next;
				minMove = Math.min(move, minMove);
			}
		}

		return ans + minMove;
	}
}
