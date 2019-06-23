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
   public static void dfs(int[][] a, boolean[] c, int v) {
		int n = a.length - 1;
		c[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i <= n; i++) {
			if (a[v][i] == 1 && !c[i]) {
				dfs(a, c, i);
			}
		}
	}
   
   

}