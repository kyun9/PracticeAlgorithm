package StudyAlgorithm_P;

import java.util.ArrayList;

public class p2018kakao_프렌즈4블록 {

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		System.out.println(solution(m, n, board));
	}

	// 어짜피 전체 다 확인하기때문 한쪽으로만 4개 인거 확인해주면 돼. 왼쪽위
	static int[] dx = { -1, -1, 0 };
	static int[] dy = { -1, 0, -1 };
	
	static boolean FLAG;
	static char[][] map;
	static boolean[][] checked;

	static public int solution(int m, int n, String[] board) {
		int answer = 0;

		map = new char[m][n];

		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}

		//	지워지는 4개 부분을 채우기 위한 list
		ArrayList<Character> list = new ArrayList<>();

		//4개를 찾지 못할때까지 반복
		while (true) {
			FLAG = false;
			checked = new boolean[m][n];

			// 뭉쳐있는 4개인 부분 찾기
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != ' ') {
						findFOUR(i, j);
					}
				}
			}
			// 4개인 부분 ' '로 삭제해주고 제거된 개수 카운트
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (checked[i][j]) {
						FLAG = true;
						map[i][j] = ' ';
						answer++;
					}
				}
			}

			// 4개인 부분 없으면 종료
			if (!FLAG) {
				break;
			}

			// 빈칸 한칸씩 내리기
			for (int i = 0; i < n; i++) {
				list.clear();
				for (int j = m - 1; j >= 0; j--) {
					if (map[j][i] != ' ') {
						list.add(map[j][i]);
					}
				}
				for (int j = m - 1; j >= 0; j--) {
					if (!list.isEmpty()) {
						map[j][i] = list.remove(0);
					} else {
						map[j][i] = ' ';
					}
				}
			}
		}

		return answer;
	}

	static void findFOUR(int x, int y) {
		int cnt = 0;
		// 받아온 값 중심으로 
		for (int i = 0; i < 3; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < map.length && 0 <= py && py < map[0].length) {
				if (map[x][y] == map[px][py]) {
					cnt++;
				}
			}
		}
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) {
				int px = x + dx[i];
				int py = y + dy[i];

				checked[px][py] = true;
			}
			checked[x][y] = true;
		}

	}

	//출력 확인
	static void print() {
		for (int i = 0; i < checked.length; i++) {
			for (int j = 0; j < checked[i].length; j++) {
				System.out.print(checked[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
