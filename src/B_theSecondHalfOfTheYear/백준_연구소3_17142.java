package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//바이러스 클래스
class Virus {
	int x;
	int y;
	int time;

	Virus(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class 백준_연구소3_17142 {
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
	static char[][] copyMap;
	static boolean[][] visited;
	static ArrayList<Virus> list;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		copyMap = new char[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Virus(i, j, 0));
				}
			}
		}

		//Combination으로 활성된 바이러스 선택 
		boolean[] check = new boolean[list.size()];
		selectVirus(check, 0, list.size(), M);
		
		//결과에 전부 못확장 시키면 리턴 -1
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	
	//Combination으로 활성된 바이러스 선택 
	static void selectVirus(boolean[] check, int depth, int n, int r) {
		if (r == 0) {
			int val = 0;
			//활성화된 바이러스와 비활성화된 바이러스의 리스트
			ArrayList<Virus> selectList = new ArrayList<>();
			ArrayList<Virus> remainList = new ArrayList<>();
			visited = new boolean[N][N];
			for (int i = 0; i < n; i++) {
				if (check[i]) {
					selectList.add(list.get(i));
				} else {
					remainList.add(list.get(i));
				}
			}
			//정수형 이차웜 배열인 map을 문자형 이차원 배열로 변형하고 비활성화 된 바이러스 *로 표시
			createCopyMap(remainList);
			//바이러스 확장 시작
			spreadVirus(selectList);
			val = checkCount();   //확장 안된 곳 확인
//			print();
			if (val == -1) {   //확장 안된 곳 존재
				return;
			} else {           //확장 되었을 때의 최소 시간 계산
				result = Math.min(result, val);
				return;
			}
		}
		if (depth == n) {
			return;
		}

		check[depth] = true;
		selectVirus(check, depth + 1, n, r - 1);
		check[depth] = false;
		selectVirus(check, depth + 1, n, r);
	}
	
	//지도 확인 메소드
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	//정수형 이차원 배열을 문자형 이차원 배열로 변경 
	static void createCopyMap(ArrayList<Virus> remainList) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					copyMap[i][j] = '-';
				} else {
					copyMap[i][j] = '0';
				}
			}
		}
		for (int i = 0; i < remainList.size(); i++) {
			copyMap[remainList.get(i).x][remainList.get(i).y] = '*';
		}
	}
	
	//바이러스 확장  BFS
	static void spreadVirus(ArrayList<Virus> selectList) {
		for (int i = 0; i < selectList.size(); i++) {
			visited[selectList.get(i).x][selectList.get(i).y] = true;
		}

		while (!selectList.isEmpty()) {
			Virus p = selectList.remove(0);

			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];

				if (0 <= x && x < N && 0 <= y && y < N && !visited[x][y]) {
					if (copyMap[x][y] == '0' || copyMap[x][y] == '*') {
						if (copyMap[x][y] == '*') {
							selectList.add(new Virus(x, y, p.time + 1));
						} else {
							copyMap[x][y] = (char) ((char) (p.time+1)+'0');
							selectList.add(new Virus(x, y, p.time + 1));
						}
						visited[x][y] = true;
					}
				}
			}
		}
	}
	
	
	// 전부 확장 확인
	static int checkCount() {
		int val = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyMap[i][j] - '0' > val) {
					val = copyMap[i][j] - '0';
				}
				if (copyMap[i][j] == '0') {
					cnt++;
				}
			}
		}
		if (cnt > M) {
			return -1;
		} else {
			return val;
		}
	}
}
