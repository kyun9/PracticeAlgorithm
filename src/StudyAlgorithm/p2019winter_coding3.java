package StudyAlgorithm;

import java.util.*;
import java.util.Map.*;

class aa implements Comparable<aa> {
	int start;
	int end;
	int weight;

	aa(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(aa o) {
		return o.weight >= this.weight ? -1 : 1;
	}

}

public class p2019winter_coding3 {
	static int[] vx = { -1, 0, 0, 1 };
	static int[] vy = { 0, -1, 1, 0 };
	static boolean[][] check;
	static HashMap<Integer, Integer>[] map;
	static PriorityQueue<aa> pq;
	static int[] parent;
	static int result;

	public static void main(String[] args) {
		System.out.println(
				solution(new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 3 } }, 1));
//		System.out.println(
//				solution(new int[][] { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } }, 3));
//		System.out.println(
//				solution(new int[][] { { 10, 11, 10, 11 }, { 2, 21, 20, 10 }, { 1, 20, 21, 11 }, { 2, 1, 2, 1 } }, 1));
	}

	public static int solution(int[][] land, int height) {
		int answer = 0;

		int size = land.length;
		int[][] group = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				group[i][j] = 0;
			}
		}

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (group[i][j] == 0) {
					dfs(group, i, j, ++cnt, size, land, height);
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(group[i][j] + ", ");
			}
			System.out.println();
		}

		map = new HashMap[cnt + 1];
		for (int i = 1; i < map.length; i++) {
			map[i] = new HashMap<>();
		}
		check = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!check[i][j]) {
					checkDFS(group, i, j, size, land);
				}

			}
		}

		for (int i = 1; i < map.length; i++) {
			System.out.println(map[i]);
		}
		
		pq = new PriorityQueue<aa>();
		parent = new int[map.length];
		
		for(int i=1;i<map.length;i++) {
			parent[i]=i;
		}
		
		
		for (int i = 1; i < map.length; i++) {
			for (int mapkey : map[i].keySet()) {
				pq.add(new aa(i, mapkey, map[i].get(mapkey)));
			}
		}
		int pqSize = pq.size();
		for(int i=0;i<pqSize;i++) {
			aa val = pq.poll();
			if(!isSameParent(val.start, val.end)) {
				result+=val.weight;
				union(val.start, val.end);
			}
		}
		
		answer= result;
		return answer;
	}
	
	
	static int find(int n) {
		if(n==parent[n]) return n;
		parent[n]=find(parent[n]);
		return parent[n];
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x!=y) {
			parent[x]=y;
		}
		else {
			return;
		}
	}
	
	static boolean isSameParent(int a, int b) {
		int x= find(a);
		int y = find(b);
		
		if(x==y) {
			return true;
		}
		else {
			return false;
		}
	}

	static void checkDFS(int[][] group, int x, int y, int size, int[][] land) {
		check[x][y] = true;
		for (int i = 0; i < vx.length; i++) {
			int dx = x + vx[i];
			int dy = y + vy[i];
			if (dx >= 0 && dx < size && dy >= 0 && dy < size) {
				if (group[x][y] != group[dx][dy]) {
					if (map[group[x][y]].containsKey(group[dx][dy])) {
						if (Math.abs(land[dx][dy] - land[x][y]) < map[group[x][y]].get(group[dx][dy])) {
							map[group[x][y]].put(group[dx][dy], Math.abs(land[dx][dy] - land[x][y]));
						}
					} else {
						map[group[x][y]].put(group[dx][dy], Math.abs(land[dx][dy] - land[x][y]));
					}
				}
				if (group[x][y] == group[dx][dy] && check[dx][dy] == false) {
					checkDFS(group, dx, dy, size, land);
				}
			}
		}
	}

	static void dfs(int[][] group, int x, int y, int cnt, int size, int[][] land, int height) {
		group[x][y] = cnt;
		for (int i = 0; i < vx.length; i++) {
			int dx = x + vx[i];
			int dy = y + vy[i];

			if (dx >= 0 && dx < size && dy >= 0 && dy < size) {
				if (Math.abs(land[dx][dy] - land[x][y]) <= height && group[dx][dy] == 0) {
					dfs(group, dx, dy, cnt, size, land, height);
				}
			}
		}
	}
}
