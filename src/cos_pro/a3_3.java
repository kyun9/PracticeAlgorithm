package cos_pro;

public class a3_3 {

	public static int solution(String[] bishops) {
		int answer = 0;
		boolean[][] map = new boolean[8][8];

		for (int i = 0; i < bishops.length; i++) {
			int row = 8 - (bishops[i].charAt(1) - '0');
			int col = bishops[i].charAt(0) - 'A';
			
			map[row][col] = true;
			print(map);
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					if ((j - k) == (row - col)) {
						map[j][k] = true;
					}
					if ((j + k) == (row + col)) {
						map[j][k] = true;
					}
				}
			}
		}

		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(!map[i][j]) {
					answer++;
				}
			}
		}
		print(map);
		return answer;
	}

	static void print(boolean[][] map) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j]) {
					System.out.print(1 + "\t");
				} else {
					System.out.print(0 + "\t");
				}
			}
			System.out.println();
		}
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String[] bishops1 = { new String("D5") };
		int ret1 = solution(bishops1);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		String[] bishops2 = { new String("D5"), new String("E8"), new String("G2") };
		int ret2 = solution(bishops2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
	}
}
