package Review;

import java.util.ArrayList;

public class PNetwork {

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.print(solution(3, computers));
	}

	static boolean[] visited;
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		for(int i=0;i<computers.length;i++) {
			if(!visited[i]) {
				dfs(computers,n,i);
				answer++;
			}
		}
		return answer;
	}

	static void dfs(int[][] computers, int n, int depth) {
		if(visited[depth]) {
			return;
		}
		visited[depth]=true;
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				dfs(computers,n,i);
			}
		}
	}
}
