package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2644 {
	static int N, M, start, end, result;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine().trim());

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		result = 0;
		dfs(start, end, 0);

		if (result == 0) {
			result = -1;
		}
		System.out.println(result);
	}

	static void dfs(int start, int end, int depth) {
		if (start == end) {
			result = depth;
			return;
		}
		visited[start] = true;
		for (int i = 0; i < list[start].size(); i++) {
			if (!visited[list[start].get(i)]) {
				dfs(list[start].get(i), end, depth + 1);
			}
		}
	}
}
