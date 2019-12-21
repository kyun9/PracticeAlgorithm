package StudyAlgorithm_SWEA;

import java.util.Scanner;

public class S_1494 {
	static int[][] location;
	static boolean[] visited;
	static long result;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test=1;test<T+1;test++) {
			
			N = sc.nextInt();
			location= new int[N][2];
			visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				location[i][0]= sc.nextInt();
				location[i][1]= sc.nextInt();
			}
			
			
			//result 초기값을 가장 큰 값으로 임의 초기화 시킴
			result = Long.MAX_VALUE;
			
			solve(0,0);
			
			System.out.println("#"+test+" "+result);
		}
	}
	
	static void solve(int now, int cnt) {
		//지렁이 쌍으로 이루니까 반쪽만 검사 해주면 됨 N/2
		if(cnt == N/2) {
			long x=0;
			long y=0;
			// 즉 , 일일이 지렁이들 짝을 구해 줄 필요 없이 더하기와 뺴기를 통하여 x좌표와 y좌표의 최소값을 구하고 result를 갱신하면 된다.
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					x+=location[i][0];
					y+=location[i][1];
				}
				else {
					x-=location[i][0];
					y-=location[i][1];
				}
			}
			//전체 다 더하고 가장 작은걸로 result를 갱신해줌
			result = Math.min(result, x*x+y*y);
			return;
		}
		
		//visited 배열을 통해 방문한 지렁이들 만 더해주고 뺴준다.
		// 즉 , 일일이 지렁이들 짝을 구해 줄 필요 없음
		for(int i= now;i<N;i++) {
			if(visited[i]) continue;
			
			visited[i]=true;
			solve(i+1,cnt+1);
			
			//재 방문을 위하여 꼭  재귀가 끝난후 방문을 false로 다시 풀어준다.
			visited[i]= false;
		}
	}
}
