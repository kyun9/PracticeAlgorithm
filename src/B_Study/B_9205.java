package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Loc {
	int x;
	int y;

	Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B_9205 {
	static int t, n;
	static Loc[] place;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine().trim());

		for (int test = 1; test <= t; test++) {
			flag= false;
			n = Integer.parseInt(br.readLine().trim());

			place = new Loc[n + 2];
			StringTokenizer st;
			for (int i = 0; i < place.length; i++) {
				st = new StringTokenizer(br.readLine());
				place[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			for (int i = 1; i < place.length; i++) {
				visited = new boolean[n + 2];
				visited[0] = true;
				if(flag) {
					break;
				}
				if (!visited[i]) {
					dfs(place[0], i);
				}
			}

			if (flag) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}
	}

	static void dfs(Loc start, int idx) {
		if(flag) {
			return;
		}
		Loc end = place[idx];
		int length = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
		
		if (length <= 1000) {
			if (idx == place.length - 1) {
				flag = true;
				return;
			}
			visited[idx] = true;
			for (int i = 1; i < place.length; i++) {
				if (!visited[i]) {
					dfs(place[idx], i);
				}
			}
		}
	}
}
