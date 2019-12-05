package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




//4차원 배열 이용 생각도 못함 ('?' 일때 랜덤한 방향으로 처리해주기위해서 사용함)
// 4차원 배열이 아니고는 뻔한 dfs의 가기치기랑 똑같은 문제

public class S_1824 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int T;
	static int r, c;
	static char[][] map;
	static boolean[][][][] visited;
	static boolean find;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.valueOf(br.readLine());

		for (int a = 1; a < T + 1; a++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.valueOf(st.nextToken());
			c = Integer.valueOf(st.nextToken());

			map = new char[r][c];
			visited = new boolean[r][c][4][16];  
			//[행][열][방향][메모리]
			//방향 0,1,2,3는  dx, dy의 배열 순서대로 북서동남 의미
			//메모리 16은 문제에서 0~15까지의 정수 메모리를 의미
			
			find = false;
			boolean hasEnd = false;

			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					if (map[i][j] == '@') {
						//문제에 '@' 프로그램 정지가 있을때만 dfs를 돈다.
						hasEnd = true;
					}
				}
			}

			if (hasEnd) {
				solve(0, 0, 2, 0);
				//시작 (0,0) 행렬에서 시작해서 방향은 오른쪽(동) 2부터 시작
			}
			
			String s = find ? "YES" : "NO";  //find가 true일 때의 삼항 연산자 처리
			System.out.println("#" + a + " " + s);
		}
	}

	static void solve(int x, int y, int d, int mem) {
		//'@' 프로그램 정지에 도달했을 떄 find를 true로 변환해주고 return;
		if (map[x][y] == '@') {
			find = true;
			return;
		}
		
		//들렸던 노드일때 리턴 시킴
		if (visited[x][y][d][mem])
			return;
		
		visited[x][y][d][mem] = true;
		int nd = d; //동서남북 방향 의미
		int nm = mem; //메모리 변화 의미

		switch (map[x][y]) {
		case '<': nd = 1; break;
		case '>': nd = 2; break;
		case '^': nd = 0; break;
		case 'v': nd = 3; break;
		case '_': nd = (mem == 0 ? 2 : 1); break;
		case '|': nd = (mem == 0 ? 3 : 0); break;
		case '+': nm = (mem == 15 ? 0 : mem + 1); break;
		case '-': nm = (mem == 0 ? 15 : mem - 1); break;
		case '0': case '1': case '2': case '3': case '4':
		case '5': case '6': case '7': case '8': case '9':
			nm = map[x][y] - '0'; //character형으로 받기 때문에 -'0'으로 정수형변환
			break;
		}

		
		
		// '?'를 만나고 랜덤하게 이동을 의미 (for루프로 방향 이동 재귀)
		if (map[x][y] == '?') {
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] < 0) {
					solve(r - 1, y + dy[i], i, nm);
				} else if (x + dx[i] >= r) {
					solve(0, y + dy[i], i, nm);
				} else if (y + dy[i] < 0) {
					solve(x + dx[i], c - 1, i, nm);
				} else if (y + dy[i] >= c) {
					solve(x + dx[i], 0, i, nm);
				} else {
					solve(x + dx[i], y + dy[i], i, nm);
				}
			}
		} 
		//'?' 만나지 않았을 떄의 처리
		else {
			if (x + dx[nd] < 0) {
				solve(r - 1, y + dy[nd], nd, nm);
			} else if (x + dx[nd] >= r) {
				solve(0, y + dy[nd], nd, nm);
			} else if (y + dy[nd] < 0) {
				solve(x + dx[nd], c - 1, nd, nm);
			} else if (y + dy[nd] >= c) {
				solve(x + dx[nd], 0, nd, nm);
			} else {
				solve(x + dx[nd], y + dy[nd], nd, nm);
			}
		}
	}

}
