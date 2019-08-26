package Review;

//훨씬 간단하게 해결
///B_Study/B_DFS_BFS_11724 참고
public class P_DFS_Network {

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.print(solution(3, computers));
	}

	static boolean[] check;

	public static int solution(int n, int[][] computers) {
		int answer = 0;

		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (check[i] == false) {
				dfs(computers, n, i);
				answer++;
			}
		}

		return answer;
	}

	static void dfs(int[][] computers, int n, int depth) {
		if (check[depth]) {
			return;
		}
		check[depth] = true;
		for (int i =0;i< n;i++) {
			if (computers[depth][i]==1&&check[i] == false) {
				dfs(computers, n, i);
			}
		}
	}

}