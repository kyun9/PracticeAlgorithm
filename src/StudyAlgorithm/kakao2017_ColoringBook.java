package StudyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class kakao2017_ColoringBook {
	static boolean[][] visited;
	static int cnt;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		System.out.println(solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 1 }, { 0, 0, 0, 1 } }));
//		System.out.println(solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
//			{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } }));
	}

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		visited = new boolean[picture.length][picture[0].length];
		for (int i = 0; i < picture.length; i++) {
			cnt=0;
			for (int j = 0; j < picture[i].length; j++) {
				if (picture[i][j] != 0 && visited[i][j] == false) {
					dfs(i, j, m, n,picture[i][j],picture);
					numberOfArea++;
					list.add(cnt);
				}
			}
		}

		Collections.sort(list);
		
		maxSizeOfOneArea=list.get(list.size()-1);
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		for(int i:answer) {
			System.out.println(i);
		}
		return answer;
	}

	static void dfs(int x, int y, int m, int n, int val, int[][] picture) {
		visited[x][y] = true;
		cnt++;
		for (int i = 0; i < dx.length; i++) {
			int vx = x + dx[i];
			int vy = y + dy[i];

			if (vx >= 0 && vx < m && vy >= 0 && vy < n) {
				if(picture[vx][vy]==val&&visited[vx][vy]==false) {
					dfs(vx,vy,m,n,val,picture);
				}
			}
		}

	}

}
