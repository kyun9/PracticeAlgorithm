package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Pair3 {
	int x;
	int y;
	int type;

	Pair3(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class 백준_감시_15683 {
	static int N, M, result=Integer.MAX_VALUE;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		List<Pair3> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new Pair3(i, j, map[i][j]));      //감시카메라 담기
				}
			}
		}

		solve(list, map);
		System.out.println(result);
	}

	static void solve(List<Pair3> list, int[][] map) {
		//감시카메라 큐가 비어있을 때
		if(list.isEmpty()) {
			int cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0) {
						cnt++;
					}
				}
			}	
			
			result = Math.min(result, cnt);
			return;
		}
		//qu에서 첫번째 감시카메라 꺼내기
		Pair3 p = list.remove(0);
		//감시카메라 타입에 따라 다르게 확인
		switch (p.type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				int[][] copyMap = copy(map);
				solve(list, goCheck(i, p.x, p.y, copyMap));
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				int[][] copyMap = copy(map);
				solve(list,  goCheck(i, p.x, p.y, goCheck(i + 2, p.x, p.y, copyMap)));
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				int[][] copyMap = copy(map);
				int a =i;
				int b = i+1;
				if(b==4) {
					b=0;
				}
				solve(list,  goCheck(a, p.x, p.y, goCheck(b, p.x, p.y, copyMap)));
			}
			break;
		case 4:
			for(int i=0;i<4;i++) {
				
				int[][] copyMap = copy(map);
				solve(list,  goCheck(i, p.x, p.y, goCheck((i+1)%4, p.x, p.y, goCheck((i+2)%4, p.x, p.y, copyMap))));
			}
			break;
		case 5:
			solve(list,  goCheck(0, p.x, p.y, goCheck(1, p.x, p.y, goCheck(2, p.x, p.y, goCheck(3, p.x, p.y, map)))));
			break;
		}
		//다 끝나고 감시카메라 다시 넣기
		list.add(0, p);
	}

	
	
	// 한쪽 바향 체크하기
	static int[][] goCheck(int idx, int x, int y, int[][] copyMap) {
		int valX = x;
		int valY = y;
		switch (idx) {
		//북
		case 0:
			while (true) {
				valX--;
				if (valX >= 0) {
					//벽을 만났을 때
					if (copyMap[valX][y] == 6) {
						break;
					} else if (copyMap[valX][y] != 6 && copyMap[valX][y] != 0) {  //다른 cctv만났을때
						continue;
					} else {        //감시범위 9로 체크
						copyMap[valX][y] = 9;
					}
				} else
					break;
			}
			break;
		//동
		case 1:
			while (true) {
				valY++;
				if (valY < M) {
					if (copyMap[x][valY] == 6) {
						break;
					} else if (copyMap[x][valY] != 6 && copyMap[x][valY] != 0) {
						continue;
					} else {
						copyMap[x][valY] = 9;
					}
				} else
					break;
			}
			break;
		//남
		case 2:
			while (true) {
				valX++;
				if (valX < N) {
					if (copyMap[valX][y] == 6) {
						break;
					} else if (copyMap[valX][y] != 6 && copyMap[valX][y] != 0) {
						continue;
					} else {
						copyMap[valX][y] = 9;
					}
				} else
					break;
			}
			break;
		//서
		case 3:
			while (true) {
				valY--;
				if (valY >= 0) {
					if (copyMap[x][valY] == 6) {
						break;
					} else if (copyMap[x][valY] != 6 && copyMap[x][valY] != 0) {
						continue;
					} else {
						copyMap[x][valY] = 9;
					}
				} else
					break;
			}
			break;
		}
		return copyMap;
	}
	
	
	//이차원 배열 복사
	static int[][] copy(int[][] arr) {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j]= arr[i][j];
			}
		}
		return temp;
	}
}
