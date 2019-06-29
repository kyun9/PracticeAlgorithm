package P_Study;

public class P_DP_IntegerTriangle {

	public static void main(String[] args) {
      int[][] triangle=	{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
      System.out.println(solution(triangle));
	}
	public static int solution(int[][] triangle) {
        int answer = 0;
        
        answer =dfs(triangle,0,0);
        
        return answer;
    }
	private static int dfs(int[][] triangle, int depth, int su) {
		if(depth==triangle.length) {
			return 0 ;
		}
		return triangle[depth][su]+Math.max(dfs(triangle,depth+1,su), dfs(triangle,depth+1,su+1));
	}
}
