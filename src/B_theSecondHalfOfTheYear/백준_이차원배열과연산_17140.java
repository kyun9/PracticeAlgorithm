package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair9 implements Comparable<Pair9> {
	int n;
	int cnt;

	Pair9(int n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}

	// 갯수가 많은순으로 오름차순
	// 갯수가 같으면 수의 오름차순으로 정렬
	@Override
	public int compareTo(Pair9 p) {
		if (this.cnt > p.cnt) {
			return 1;
		} else if (this.cnt == p.cnt) {
			if (this.n >= p.n) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}

public class 백준_이차원배열과연산_17140 {
	static int r, c, k, time = 0;
	static ArrayList<Pair9>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[][] map = new int[4][4];

		for (int i = 1; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(map, 0);
		System.out.println(time);

	}

	static void solve(int[][] map, int sec) {
		// r,c가 map의 범위가 넘어있을 때
		if (map.length > r && map[0].length > c) {
			if (map[r][c] == k) {
				time = sec;
				return;
			}
		}
		// 값 초과
		if (sec > 100) {
			time = -1;
			return;
		}

		// R 연산
		if (map.length >= map[0].length) {
			doSort(map, true);
			solve(initCopyMap(map, true, getSize()), sec + 1);			//재귀
		}
		// C 연산
		else {
			doSort(map, false);
			solve(initCopyMap(map, false, getSize()), sec + 1);			//재귀
		}
	}
	
	
	// copyMap 새로 생성 후 정렬된 리스트 담기
	static int[][] initCopyMap(int[][] map, boolean flag, int size) {
		int[][] copyMap;
		if (flag) {
			copyMap = new int[map.length][size + 1];
			for (int i = 1; i < copyMap.length; i++) {
				int a = 0;
				for (int j = 0; j < list[i].size(); j++) {
					copyMap[i][++a] = list[i].get(j).n;
					copyMap[i][++a] = list[i].get(j).cnt;

				}
			}
		} else {
			copyMap = new int[size + 1][map[0].length];
			for (int i = 1; i < copyMap[0].length; i++) {
				int a = 0;
				for (int j = 0; j < list[i].size(); j++) {
					copyMap[++a][i] = list[i].get(j).n;
					copyMap[++a][i] = list[i].get(j).cnt;

				}
			}
		}
//		print(copyMap);
		return copyMap;
	}

	// 가장 큰 곳의 사이즈 구하기
	static int getSize() {
		int size = 0;
		for (int i = 1; i < list.length; i++) {
			if (list[i].size() > size) {
				size = list[i].size();
			}
		}
		size *= 2;
		if (size < 3) {
			size = 3;
		}
		return size;
	}

	// 리스트에 담고 정렬
	static void doSort(int[][] map, boolean flag) {
		// True면 R, False면 C
		if (flag) { // R
			// list배열 초기화
			list = new ArrayList[map.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map[i].length; j++) {
					if (map[i][j] != 0) {
						if (list[i].isEmpty()) {
							list[i].add(new Pair9(map[i][j], 1));
						} else {
							boolean check = false;
							for (int k = 0; k < list[i].size(); k++) {
								if (list[i].get(k).n == map[i][j]) {
									list[i].get(k).cnt += 1;
									check = true;
									break;
								}
							}
							if (!check) {
								list[i].add(new Pair9(map[i][j], 1));
							}
						}
					}
				}
				Collections.sort(list[i]);
			}
		} else { // C
			// list배열 초기화
			list = new ArrayList[map[0].length];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 1; i < map[0].length; i++) {
				for (int j = 1; j < map.length; j++) {
					if (map[j][i] != 0) {
						if (list[i].isEmpty()) {
							list[i].add(new Pair9(map[j][i], 1));
						} else {
							boolean check = false;
							for (int k = 0; k < list[i].size(); k++) {
								if (list[i].get(k).n == map[j][i]) {
									list[i].get(k).cnt += 1;
									check = true;
									break;
								}
							}
							if (!check) {
								list[i].add(new Pair9(map[j][i], 1));
							}
						}
					}
				}
				Collections.sort(list[i]);
			}
		}
	}

	static void print(int[][] map) {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
