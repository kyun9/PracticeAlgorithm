package review_2020_winter;


public class P_DFS_Network {

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int n = 3;
		System.out.println(solution(n, computers));
	}

	static boolean[] visited ;
	static int solution(int n, int[][] computers) {
		int answer = 0;

		visited = new boolean[n];
		for(int i=0;i<computers.length;i++) {
			for(int j=0;j<computers[i].length;j++) {
				if(computers[i][j]==1) {
					if(!visited[i]) {
						dfs(computers,i);
						answer++;
					}
				}
			}
		}
		return answer;
	}
	
	static void dfs(int[][] computers,int i) {
		if(visited[i]) {
			return;
		}
		visited[i]=true;
		for(int a=0; a<computers[i].length;a++) {
			if(computers[i][a]==1) {
				dfs(computers,a);
			}
		}
	}
}
