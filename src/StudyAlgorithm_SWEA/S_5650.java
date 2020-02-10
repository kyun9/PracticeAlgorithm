package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_5650 {
	static int T, N, result, sum;
	static int[][] map;
	static ArrayList<Pair33> list;
	static ArrayList<Pair33> wormList;
	static boolean flag, check;
	static Pair33 firstPair;
	// 북 동 남 서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		T = Integer.parseInt(br.readLine().trim());
//		for (int test = 1; test <= T; test++) {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		StringTokenizer st;
		list = new ArrayList<>();
		wormList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new Pair33(i, j, 0));
				} else if (5 < map[i][j] && map[i][j] <= 10) {
					wormList.add(new Pair33(i, j, 0));
				}
			}
		}

		result = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 4; j++) {
				sum = 0;
				flag = false;
				check=false;
				Pair33 p = list.get(i);
				p.d = j;
				
				firstPair = new Pair33(p.x, p.y, p.d);
				System.out.println("x : " + p.x + " y : " + p.y + " j :  " + p.d);
				movePin(p);
			}
		}
		System.out.println("@@@@@@@@@@@@@@@" + result);
//			System.out.println("#"+test+" "+);
//		}

	}

	static void movePin(Pair33 pair) {
//		System.out.println("pair.x : "+pair.x+" pair.y : "+ pair.y+" pair.d : "+ pair.d);
		if (flag) {
			System.out.println("sum : " + sum);
			result = Math.max(result, sum);
			return;
		}
		// 북 동 남 서
		if (pair.d == 0) {
			pair.x += dx[0];
			pair.y += dy[0];
			if (firstPair.x == pair.x && firstPair.y == pair.y&&check) {
				System.out.println(pair.x + " "+ pair.y);
				System.out.println("sum1 : " + sum);
				result = Math.max(result, sum);
				return;
			}
			if (!checkLine(pair.x, pair.y)) {
				sum++;
				pair.x -= dx[0];
				pair.y -= dy[0];
				pair.d = 2;
				check = false;
				movePin(pair);
			} else {
				if (map[pair.x][pair.y] == 0) {
					check = true;
					movePin(pair);
				} else if (1 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 5) {
					System.out.println(222222222);
					sum++;
					int tmp = confirmBlock(map[pair.x][pair.y], pair.d);
					pair.d = tmp;
					if(!check) {
						System.out.println("sum : " + sum);
						result = Math.max(result, sum);
						return;
					}
					movePin(pair);
				} else if (6 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 10) {
					int[] arr = checkWorm(pair.x, pair.y);
					pair.x = arr[0];
					pair.y = arr[1];
					movePin(pair);
				} else if (map[pair.x][pair.y] == -1) {
					flag = true;
					movePin(pair);
				}
			}
		} else if (pair.d == 1) {
			pair.x += dx[1];
			pair.y += dy[1];
			if (firstPair.x == pair.x && firstPair.y == pair.y) {
				System.out.println("sum : " + sum);
				result = Math.max(result, sum);
				return;
			}
			if (!checkLine(pair.x, pair.y)) {
				sum++;
				pair.x -= dx[0];
				pair.y -= dy[0];
				pair.d = 3;
				check = false;
				movePin(pair);
			} else {
				if (map[pair.x][pair.y] == 0) {
					check = true;
					movePin(pair);
				} else if (1 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 5) {
					int tmp = confirmBlock(map[pair.x][pair.y], pair.d);
					pair.d = tmp;
					if(!check) {
						System.out.println("sum : " + sum);
						result = Math.max(result, sum);
						return;
					}
					movePin(pair);
				} else if (6 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 10) {
					int[] arr = checkWorm(pair.x, pair.y);
					pair.x = arr[0];
					pair.y = arr[1];
					movePin(pair);
				} else if (map[pair.x][pair.y] == -1) {
					flag = true;
					movePin(pair);
				}
			}
		} else if (pair.d == 2) {
			pair.x += dx[2];
			pair.y += dy[2];
			if (firstPair.x == pair.x && firstPair.y == pair.y) {
				System.out.println("sum : " + sum);
				result = Math.max(result, sum);
				return;
			}
			if (!checkLine(pair.x, pair.y)) {
				sum++;
				pair.x -= dx[0];
				pair.y -= dy[0];
				pair.d = 0;
				check = false;
				movePin(pair);
			} else {
				if (map[pair.x][pair.y] == 0) {
					check = true;
					movePin(pair);
				} else if (1 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 5) {
					int tmp = confirmBlock(map[pair.x][pair.y], pair.d);
					pair.d = tmp;
					if(!check) {
						System.out.println("sum : " + sum);
						result = Math.max(result, sum);
						return;
					}
					movePin(pair);
				} else if (6 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 10) {
					int[] arr = checkWorm(pair.x, pair.y);
					pair.x = arr[0];
					pair.y = arr[1];
					movePin(pair);
				} else if (map[pair.x][pair.y] == -1) {
					flag = true;
					movePin(pair);
				}
			}
		} else if (pair.d == 3) {
			pair.x += dx[3];
			pair.y += dy[3];
			if (firstPair.x == pair.x && firstPair.y == pair.y) {
				System.out.println("sum : " + sum);
				result = Math.max(result, sum);
				return;
			}
			if (!checkLine(pair.x, pair.y)) {
				sum++;
				pair.x -= dx[0];
				pair.y -= dy[0];
				pair.d = 1;
				check = false;
				movePin(pair);
			} else {
				if (map[pair.x][pair.y] == 0) {
					check = true;
					movePin(pair);
				} else if (1 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 5) {
					int tmp = confirmBlock(map[pair.x][pair.y], pair.d);
					pair.d = tmp;
					if(!check) {
						System.out.println("sum : " + sum);
						result = Math.max(result, sum);
						return;
					}
					movePin(pair);
				} else if (6 <= map[pair.x][pair.y] && map[pair.x][pair.y] <= 10) {
					int[] arr = checkWorm(pair.x, pair.y);
					pair.x = arr[0];
					pair.y = arr[1];
					movePin(pair);
				} else if (map[pair.x][pair.y] == -1) {
					flag = true;
					movePin(pair);
				}
			}
		}

	}

	static int[] checkWorm(int x, int y) {
		int[] temp = new int[2];
		for (int i = 0; i < wormList.size(); i++) {
			int wx = wormList.get(i).x;
			int wy = wormList.get(i).y;
			if (map[wx][wy] == map[x][y]) {
				if (wx == x && wy == y) {
				} else {
					temp[0] = wx;
					temp[1] = wy;
					break;
				}
			}
		}
		return temp;
	}

	static boolean checkLine(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		} else {
			return false;
		}
	}

	static int confirmBlock(int num, int d) {
		int dic = 0;
		switch (num) {
		case 1:
			if (d == 0) {
				dic = 2;
			} else if (d == 1) {
				dic = 3;
			} else if (d == 2) {
				dic = 1;
			} else if (d == 3) {
				dic = 0;
			}
			break;
		case 2:
			if (d == 0) {
				dic = 1;
			} else if (d == 1) {
				dic = 3;
			} else if (d == 2) {
				dic = 0;
			} else if (d == 3) {
				dic = 2;
			}
			break;
		case 3:
			if (d == 0) {
				dic = 3;
			} else if (d == 1) {
				dic = 2;
			} else if (d == 2) {
				dic = 0;
			} else if (d == 3) {
				dic = 1;
			}
			break;
		case 4:
			if (d == 0) {
				dic = 2;
			} else if (d == 1) {
				dic = 0;
			} else if (d == 2) {
				dic = 3;
			} else if (d == 3) {
				dic = 1;
			}
			break;
		case 5:
			if (d == 0) {
				dic = 2;
			} else if (d == 1) {
				dic = 3;
			} else if (d == 2) {
				dic = 0;
			} else if (d == 3) {
				dic = 1;
			}
			break;
		}
		return dic;
	}
}

class Pair33 {
	int x;
	int y;
	int d;

	Pair33(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}