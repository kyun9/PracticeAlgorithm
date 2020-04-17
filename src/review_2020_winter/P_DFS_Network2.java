package review_2020_winter;

public class P_DFS_Network2 {

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int n = 3;
		System.out.println(solution(n, computers));
	}
	static boolean[] visited;
	static public int solution(int n, int[][] computers) {
	     int answer = 0;
	     
	     visited= new boolean[n];
	     
	     for(int i=0;i<computers.length;i++) {
	    	 for(int j=0;j<computers[i].length;j++) {
	    		 if(!visited[i]) {
	    			 dfs(i,computers);
	    			 answer++;
	    		 }
	    	 }
	     }
	     return answer;
	}
	
	static void dfs(int idx, int[][] computers) {
		visited[idx]=true;
		
		for(int i=0;i<computers[idx].length;i++) {
			if(!visited[i]&&computers[idx][i]==1) {
				dfs(i,computers);
			}
		}
	}
}
