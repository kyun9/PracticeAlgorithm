package Review;

import java.util.ArrayList;

public class PNetwork {

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.print(solution(3, computers));
	}

	static boolean[] visited;
	static boolean flag;
	static int count;
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			flag = false;
			dfs(computers, i);
			if(flag) {
				count++;
			}
		}
		answer= count;
		return answer;
	}

	static void dfs(int[][] computers, int n) {
		if (visited[n]) {
			return;
		}
		visited[n] = true;
		flag= true;
		for (int i=0;i<computers[n].length;i++) {
			if(visited[i]==false&&computers[n][i]!=0) {
				dfs(computers,i);
			}
		}
	}
}
