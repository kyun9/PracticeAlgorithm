package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 2/10 실패 
// 그냥 겹치는 부분에서 count 올려줘 버림
// 시간은 체크하지 못함.

class Move {
	int start;
	int end;

	Move(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class S_4408 {
	static int[][] map = new int[3][200];
	static boolean[] visited;
	static boolean check;
	static ArrayList<Move> list;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int a = 1; a < T + 1; a++) {
			int num = 1;
			for (int i = 0; i < 200; i++) {
				for (int j = 0; j < 3; j++) {
					if (j == 1)
						continue;
					map[j][i] = num++;
				}
			}

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			visited = new boolean[200];
			count = 1;
			for (int b = 0; b < N; b++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Move(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			while (!list.isEmpty()) {
				Move mv = list.remove(0);
				check= false;
				int startY = 0;
				int endY = 0;
				if (mv.start % 2 == 0) {
					startY = (mv.start - 2) / 2;
				} else {
					startY = (mv.start - 1) / 2;
				}
				if (mv.end % 2 == 0) {
					endY = (mv.end - 2) / 2;
				} else {
					endY = (mv.end - 1) / 2;
				}
				System.out.println("startY "+startY+" endY "+endY);
				if (startY < endY) {
					for (int i = startY; i < endY; i++) {
						if (visited[i]) {
							check=true;
						}
						visited[i] = true;
					}
				} else {
					for (int i = endY; i < startY; i++) {
						if (visited[i]) {
							check=true;
						}
						visited[i] = true;
					}
				}
				if(check) {
					count++;
				}
			}

			System.out.println("#" + a + " " + count);
		}
	}

}
