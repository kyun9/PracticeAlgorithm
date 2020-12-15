package cos_pro;

import java.util.Arrays;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class a2_6 {
	// 북동남서 URDL
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static int[] solution(String commands) {
		// 여기에 코드를 작성해주세요.
		int[] answer = {};

		int x = 0;
		int y = 0;
		for (int i = 0; i < commands.length(); i++) {
			char c = commands.charAt(i);

			switch (c) {
			case 'U':
				y += 1;
				break;
			case 'R':
				x += 1;
				break;
			case 'D':
				y -= 1;
				break;
			case 'L':
				x -= 1;
				break;
			}

		}

		answer = new int[2];
		answer[0] = x;
		answer[1] = y;
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String commands = "URDDL";
		int[] ret = solution(commands);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
	}
}
