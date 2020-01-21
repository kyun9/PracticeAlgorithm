package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B_11559 {
	static char[][] map;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static boolean[][] visited;
	static int count, result;
	static ArrayList<Point> list;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		check= true;
		while (check) {
			check = false;
			visited = new boolean[12][6];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != '.' && !visited[i][j]) {
						list = new ArrayList<>();
						count = 1;
						list.add(new Point(i, j));
						dfs(i, j);
						if (count >= 4) {
							check = true;
							changePoint();
						}
					}
				}
			}
			removePoint2();
			if(!check) {
				break;
			}
			else {
				result+=1;
			}
		}
		System.out.println(result);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			if (0 <= px && px < 12 && 0 <= py && py < 6) {
				if (!visited[px][py] && map[x][y] == map[px][py]) {
					list.add(new Point(px, py));
					count++;
					dfs(px, py);
				}
			}
		}
	}

	static void changePoint() {
		for(int i=0;i<list.size();i++) {
			map[list.get(i).x][list.get(i).y]='.';
		}
	}
	static void removePoint2() {
		 for (int i = 0; i < 6; i++) {
	            for (int j = 11; j >= 0; j--) {
	                if (map[j][i] == '.') {
	                    for (int k = j - 1; k >= 0; k--) {
	                        if (map[k][i] != '.') {
	                            map[j][i] = map[k][i];
	                            map[k][i] = '.';
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	}
}
