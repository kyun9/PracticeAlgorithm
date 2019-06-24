package P_Study;


public class P_DFS_Network {
   public static void main(String[] args) {
      int n=3;
      int[][] computer= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
   //   int[][] computer= {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
   //   int[][] computer= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
   //   int[][] computer= {{1, 1, 1,1}, {1, 1, 1,1}, {1, 1, 1,1},{1,1,1,1}};
   //   int[][] computer= {{1, 1, 0,0}, {1, 1, 0,0}, {0, 0, 1,1},{0, 0, 1,1}};
   //   int[][] computer= {{1, 1, 0,0}, {1, 1, 1,0}, {0, 1, 1,0},{0, 0, 0,1}};
      solution(n,computer);
   }
   
   public static int solution(int n, int[][] computers) {
	   int answer = 0;
		boolean[] check = new boolean[computers.length];
		for (int i = 0; i < computers.length; i++) {
			if (check[i])
				continue;
			dfs(computers, check, i);
			answer++;
		}
		System.out.println(answer);
		return answer;
    }
   public static void dfs(int[][] computers, boolean[] check, int i) {
		int n = computers.length - 1;
		check[i] = true;
		System.out.print(i + " ");
		for (int k = 1; k <= n; k++) {
			if (computers[i][k] == 1 && !check[k]) {
				dfs(computers, check, k);
			}
		}
	}
   
   

}