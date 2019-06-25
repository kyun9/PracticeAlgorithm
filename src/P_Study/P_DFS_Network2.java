package P_Study;

import java.util.LinkedList;
import java.util.Queue;

public class P_DFS_Network2 {

	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.print(solution(3, computers));
	}
	static boolean[] visited;
	 public static int solution(int n, int[][] computers) {
	        int answer = 0;
	        visited = new boolean[n+1];
	        
	        for(int i = 0; i<n;i++) {
	        	if(!visited[i]) {
	        		bfs(computers, i, n);
	        		answer++;
	        	}
	        }
	        
	        return answer;
	    }
	 public static void bfs(int[][] computers, int vertex, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
	    visited[vertex] = true;
	    n--;
	    while(!q.isEmpty()) {
	        vertex = q.remove();
	        for(int i = 1; i<=n;i++) {
	        		if(computers[vertex][i]==1&&!visited[i]) {
	        			q.add(i);
	        			visited[i] = true;
	        		}
	        	}
		}
	 }
}