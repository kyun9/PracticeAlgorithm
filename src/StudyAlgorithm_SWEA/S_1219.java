package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_1219 {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean find;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int a = 1; a < 11; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			list = new ArrayList[100];
			visited = new boolean[100];
			find = false;
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			dfs(0);
			System.out.println("#" + N + " " + (find ? 1 : 0));
		}
	}

	static void dfs(int start) {
		if (visited[start] || find) {
			return;
		}
		visited[start] = true;
		for (int val : list[start]) {
			if (val == 99) {
				find = true;
				return;
			}
			if (!visited[val]) {
				dfs(val);
			}
		}
	}
}
