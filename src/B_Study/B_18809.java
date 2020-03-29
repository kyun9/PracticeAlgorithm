package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Land {
	int x;
	int y;

	Land(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B_18809 {
	static int N, M, G, R, result;
	static int[][] map;
	static int[][] copyMap;
	static ArrayList<Land> list;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Land(i, j));
				}
			}
		}

		boolean[] visited = new boolean[list.size()];
		result = 0;
		// 배양액 뿌릴 땅 선택
		selectLand(visited, 0, list.size(), R + G);

		System.out.println(result);
	}

//	static void print(boolean[] visited) {
//		for (int i = 0; i < list.size(); i++) {
//			if (visited[i]) {
//				System.out.print(list.get(i).x + " " + list.get(i).y + " , ");
//			}
//		}
//		System.out.println();
//	}

	static void selectLand(boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
//			print(visited);
			ArrayList<Land> selectList = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (visited[i]) {
					selectList.add(new Land(list.get(i).x, list.get(i).y));
				}
			}
			boolean[] check = new boolean[selectList.size()];
			// 땅 선택 되면 red, grean나누기
			divideLand(selectList, check, 0, selectList.size(), R);
			return;
		}
		if (depth == n) {
			return;
		}
		visited[depth] = true;
		selectLand(visited, depth + 1, n, r - 1);
		visited[depth] = false;
		selectLand(visited, depth + 1, n, r);
	}

	// 땅 선택 되면 red, grean나누기
	static void divideLand(ArrayList<Land> selectList, boolean[] check, int depth, int n, int r) {
		if (r == 0) {
			ArrayList<Land> red = new ArrayList<>();
			ArrayList<Land> green = new ArrayList<>();
			for (int i = 0; i < selectList.size(); i++) {
				if (check[i]) {
					red.add(new Land(selectList.get(i).x, selectList.get(i).y));
				} else {
					green.add(new Land(selectList.get(i).x, selectList.get(i).y));
				}
			}

			copyMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						copyMap[i][j] = 9;
					}
				}
			}
			
			
			//배양액 퍼지기
			spreadFluid(red, green);

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copyMap[i][j] == 3) {
						cnt++;
					}
				}
			}

//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(copyMap[i][j] + " ");
//				}
//				System.out.println();
//			}

			result = Math.max(result, cnt);
			return;
		}
		if (depth == n) {
			return;
		}
		check[depth] = true;
		divideLand(selectList, check, depth + 1, n, r - 1);

		check[depth] = false;
		divideLand(selectList, check, depth + 1, n, r);
	}

	//배양액 퍼지기
	static void spreadFluid(ArrayList<Land> red, ArrayList<Land> green) {
		boolean rflag = false;
		boolean gflag = false;

		copyMap[red.get(0).x][red.get(0).y] = 1;
		copyMap[green.get(0).x][green.get(0).y] = 2;

		ArrayList<Land> temp = new ArrayList<>();
		ArrayList<Land> same = new ArrayList<>();
		//시간 초마다 퍼지는거 리스트에 정리
		while (true) {
			if (rflag && gflag) {
				break;
			}

			if (!rflag) {
				while (!red.isEmpty()) {
					Land r = red.remove(0);
					if (copyMap[r.x][r.y] != 3) {
						for (int i = 0; i < 4; i++) {
							int rx = r.x + dx[i];
							int ry = r.y + dy[i];

							if (0 <= rx && rx < N && 0 <= ry && ry < M) {
								if (copyMap[rx][ry] == 0) {
									copyMap[rx][ry] = 1;
									temp.add(new Land(rx, ry));
									same.add(new Land(rx, ry));
								}
							}
						}
					}
				}
			}

			if (temp.isEmpty()) {
				rflag = true;
			} else {
				red.addAll(temp);
				temp.clear();
			}

			if (!gflag) {
				while (!green.isEmpty()) {
					Land g = green.remove(0);
					if (copyMap[g.x][g.y] != 3) {
						for (int i = 0; i < 4; i++) {
							int gx = g.x + dx[i];
							int gy = g.y + dy[i];
							if (0 <= gx && gx < N && 0 <= gy && gy < M) {
								boolean check = false;
								for (int k = 0; k < same.size(); k++) {
									if (same.get(k).x == gx && same.get(k).y == gy) {
										check = true;
										copyMap[gx][gy] = 3;
										break;
									}
								}
								if (copyMap[gx][gy] == 0 && !check) {
									copyMap[gx][gy] = 2;
									temp.add(new Land(gx, gy));
								}
							}
						}
					}
				}
			}

			if (temp.isEmpty()) {
				gflag = true;
			} else {
				green.addAll(temp);
				temp.clear();
			}

			same.clear();
		}
	}
}
