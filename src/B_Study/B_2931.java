package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Gas {
	int x;
	int y;
	int d;

	Gas(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class B_2931 {
	static int R, C;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][] blank;
	static Gas Moscow, Zagreb;
	static char[][] dicArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		blank = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'M') {
					Moscow = new Gas(i, j, 0);
				} else if (map[i][j] == 'Z') {
					Zagreb = new Gas(i, j, 0);
				} else if (map[i][j] == '.') {
					blank[i][j] = true;
				}

			}
		}

		firstCheckDic(Moscow);
		firstCheckDic(Zagreb);

//		System.out.println("first");
//		System.out.println(Moscow.x+" "+Moscow.y+" "+Moscow.d);
//		System.out.println(Zagreb.x+" "+Zagreb.y+" "+Zagreb.d);
		if (Moscow.d != 9) {
			goGas(Moscow);
		}
		if (Zagreb.d != 9) {
			goGas(Zagreb);
		}

//		System.out.println("go");
//		System.out.println(Moscow.x+" "+Moscow.y+" "+Moscow.d);
//		System.out.println(Zagreb.x+" "+Zagreb.y+" "+Zagreb.d);
//		
		char[] c = { '4', '|', '1', '3', '-', '2' };
		int idx = 0;
		dicArr = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = i; j < 3; j++) {
				dicArr[i][j] = c[idx];
				idx++;
			}
		}

		int x = 0, y = 0;
		if (Zagreb.d == 9) {
			x = Moscow.x + 1;
			y = Moscow.y + 1;
		} else if (Moscow.d == 9) {
			x = Zagreb.x + 1;
			y = Zagreb.y + 1;
		} else if(Moscow.d!=9&&Zagreb.d!=9) {
			x = Moscow.x + 1;
			y = Moscow.y + 1;
		}

		char ch = 0;
		if (Moscow.d < Zagreb.d) {
			if (Zagreb.d == 9) {
				if (Moscow.x == Zagreb.x) {
					if (Moscow.y < Zagreb.y) {
						if (Moscow.d == 0) {
							ch = '1';
						} else if (Moscow.d == 1) {
							ch = '-';
						} else if (Moscow.d == 2) {
							ch = '2';
						}
					} else {
						if (Moscow.d == 0) {
							ch = '4';
						} else if (Moscow.d == 2) {
							ch = '3';
						} else if (Moscow.d == 3) {
							ch = '-';
						}
					}
				} else if (Moscow.y == Zagreb.y) {
					if (Moscow.x < Zagreb.x) {
						if (Moscow.d == 1) {
							ch = '4';
						} else if (Moscow.d == 2) {
							ch = '|';
						} else if (Moscow.d == 3) {
							ch = '1';
						}
					} else {
						if (Moscow.d == 0) {
							ch = '|';
						} else if (Moscow.d == 1) {
							ch = '3';
						} else if (Moscow.d == 3) {
							ch = '2';
						}
					}
				}
			} else {
				ch = dicArr[Moscow.d][Zagreb.d - 1];
			}
		} else {
			if (Moscow.d == 9) {
				if (Moscow.x == Zagreb.x) {
					if (Moscow.y > Zagreb.y) {
						if (Zagreb.d == 0) {
							ch = '1';
						} else if (Zagreb.d == 1) {
							ch = '-';
						} else if (Zagreb.d == 2) {
							ch = '2';
						}
					} else {
						if (Zagreb.d == 0) {
							ch = '4';
						} else if (Zagreb.d == 2) {
							ch = '3';
						} else if (Zagreb.d == 3) {
							ch = '-';
						}
					}
				} else if (Moscow.y == Zagreb.y) {
					if (Moscow.x > Zagreb.x) {
						if (Zagreb.d == 1) {
							ch = '4';
						} else if (Zagreb.d == 2) {
							ch = '|';
						} else if (Zagreb.d == 3) {
							ch = '1';
						}
					} else {
						if (Zagreb.d == 0) {
							ch = '|';
						} else if (Zagreb.d == 1) {
							ch = '3';
						} else if (Zagreb.d == 3) {
							ch = '2';
						}
					}
				}
			} else {
				ch = dicArr[Zagreb.d][Moscow.d - 1];
			}
		}

		System.out.println(x + " " + y + " " + ch);
	}

	static void goGas(Gas g) {
		if (blank[g.x][g.y]) {
			return;
		}

		g.x += dx[g.d];
		g.y += dy[g.d];
		checkDic(map[g.x][g.y], g, g.d);
		goGas(g);
	}

	static void checkDic(char c, Gas g, int d) {
		switch (c) {
		case '-':
			g.d = d;
			break;
		case '|':
			g.d = d;
			break;
		case '+':
			g.d = d;
			break;
		case '1':
			if (d == 0) {
				g.d = 1;
			} else if (d == 3) {
				g.d = 2;
			}
			break;
		case '2':
			if (d == 3) {
				g.d = 0;
			} else if (d == 2) {
				g.d = 1;
			}
			break;
		case '3':
			if (d == 1) {
				g.d = 0;
			} else if (d == 2) {
				g.d = 3;
			}
			break;
		case '4':
			if (d == 1) {
				g.d = 2;
			} else if (d == 0) {
				g.d = 3;
			}
			break;
		}
	}

	static void firstCheckDic(Gas g) {
		boolean check = false;
		// 0 북,1 서,2 남,3 동
		for (int i = 0; i < 4; i++) {
			int x = dx[i] + g.x;
			int y = dy[i] + g.y;
			if (0 <= x && x < R && 0 <= y && y < C) {
				if (!blank[x][y]) {
					g.x = x;
					g.y = y;
					checkDic(map[x][y], g, i);
					check = true;
					break;
				}
			}
		}
		if (!check) {
			g.d = 9;
		}
	}

}
