package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4991 {
	static int w, h, result;
	static char[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static ArrayList<Point33> list;
	static ArrayList<Point331>[] rel;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			map = new char[h][w];
			distance = new int[h][w];

			list = new ArrayList<>();
			ArrayList<Point33> tmp = new ArrayList<>();
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);
				}
			});

			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				Arrays.fill(distance[i], Integer.MAX_VALUE);
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'o') {
						list.add(new Point33(i, j));
					} else if (map[i][j] == '*') {
						list.add(new Point33(i, j));
						tmp.add(new Point33(i, j));
					}
				}
			}
//			for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).x + " " + list.get(i).y);
//		}
//		System.out.println();
			rel = new ArrayList[list.size()];
			for (int i = 0; i < rel.length; i++) {
				rel[i] = new ArrayList<>();
			}

			for (int i = 0; i < list.size(); i++) {
				pq.offer(new int[] { list.get(i).x, list.get(i).y, 0 });
				for (int j = 0; j < h; j++) {
					Arrays.fill(distance[j], Integer.MAX_VALUE);
				}
				distance[list.get(i).x][list.get(i).y] = 0;
				visited = new boolean[h][w];
				while (!pq.isEmpty()) {
					int[] temp = pq.poll();
					for (int k = 0; k < 4; k++) {
						int x = temp[0] + dx[k];
						int y = temp[1] + dy[k];
						if (0 <= x && x < h && 0 <= y && y < w && map[x][y] != 'x') {
							if (!visited[x][y]) {
								int weight = temp[2] + 1;
								if (weight < distance[x][y]) {
									distance[x][y] = weight;
									pq.offer(new int[] { x, y, distance[x][y] });
								}
							}
						}
					}
				}
//				System.out.println(i);
//				for (int a = 0; a < distance.length; a++) {
//					for (int b = 0; b < distance[a].length; b++) {
//						System.out.print(distance[a][b] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();

				if (map[list.get(i).x][list.get(i).y] == 'o') {
					for (int a = 0; a < tmp.size(); a++) {
						rel[0].add(new Point331(a + 1, distance[tmp.get(a).x][tmp.get(a).y]));
						rel[a + 1].add(new Point331(0, distance[tmp.get(a).x][tmp.get(a).y]));
					}
				} else if (map[list.get(i).x][list.get(i).y] == '*') {
					for (int a = 0; a < tmp.size(); a++) {
						if (list.get(i).x == tmp.get(a).x && list.get(i).y == tmp.get(a).y) {
							for (int b = a + 1; b < tmp.size(); b++) {
								rel[a + 1].add(new Point331(b + 1, distance[tmp.get(b).x][tmp.get(b).y]));
								rel[b + 1].add(new Point331(a + 1, distance[tmp.get(b).x][tmp.get(b).y]));
							}
						}
					}
				}
			}

//			for (int i = 0; i < rel.length; i++) {
//			for (int j = 0; j < rel[i].size(); j++) {
//				System.out.print(rel[i].get(j).end + " " + rel[i].get(j).weight + "        ");
//			}
//			System.out.println();
//		}

			result = Integer.MAX_VALUE;
			check = new boolean[list.size()];
			check[0] = true;
			dfs(0, 0, 0);
			if (result == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(result);
			}
		}
	}

	static void dfs(int depth, int start, int sum) {
		if (depth == rel.length - 1) {
			if (result > sum) {
				result = sum;
			}
			return;
		}
		for (int i = 0; i < rel[start].size(); i++) {
			if (!check[rel[start].get(i).end]) {
				check[rel[start].get(i).end] = true;
				dfs(depth + 1, rel[start].get(i).end, sum + rel[start].get(i).weight);
				check[rel[start].get(i).end] = false;
			}
		}
	}

}

class Point331 {
	int end;
	int weight;

	Point331(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}

class Point33 {
	int x;
	int y;

	Point33(int x, int y) {
		this.x = x;
		this.y = y;
	}
}