package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_14889 {
	static int N, result;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[N];
		result = Integer.MAX_VALUE;
		comb(N, N / 2, 0, visited);
		System.out.println(result);
	}

	static void comb(int n, int r, int depth, boolean[] visited) {
		if (r == 0) {
			ArrayList<Integer> teamA = new ArrayList<>();
			ArrayList<Integer> teamB = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					teamA.add(i);
				} else {
					teamB.add(i);
				}
			}
			checkGap(teamA, teamB);
			return;
		}
		if (depth == n)
			return;
		visited[depth] = true;
		comb(n, r - 1, depth + 1, visited);
		visited[depth] = false;
		comb(n, r, depth + 1, visited);

	}

	static void checkGap(ArrayList<Integer> teamA, ArrayList<Integer> teamB) {
		int sumA=0;
		for(int i=0;i<teamA.size();i++) {
			for(int j=i+1;j<teamA.size();j++) {
				int x = teamA.get(i);
				int y = teamA.get(j);
				sumA += (map[x][y]+map[y][x]);
			}
		}

		int sumB=0;
		for(int i=0;i<teamB.size();i++) {
			for(int j=i+1;j<teamB.size();j++) {
				int x = teamB.get(i);
				int y = teamB.get(j);
				sumB += (map[x][y]+map[y][x]);
			}
		}
		int gap = Math.abs(sumA-sumB);
		result = Math.min(result, gap);
	}
}
