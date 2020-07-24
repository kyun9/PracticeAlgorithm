package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_스타트와링크_14889 {
	static int N, gab = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited= new boolean[N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		//팀 나누기
		divideTeam(0,N,N/2);
		System.out.println(gab);
	}
	
	//팀 나누기 Combination(조합)이용
	static void divideTeam(int depth, int n, int r) {
		if(r==0) {
			// true/false로 팀  나누기 oneTeam, anotherTeam  
			ArrayList<Integer> oneTeam = new ArrayList<>();
			ArrayList<Integer> anotherTeam = new ArrayList<>();
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					oneTeam.add(i);
				}else {
					anotherTeam.add(i);
				}
			}
			
			checkGab(oneTeam, anotherTeam); 
			return;
		}
		if(depth==n) {
			return;
		}else {
			visited[depth]=true;
			divideTeam(depth+1, n,r-1);
			visited[depth]=false;
			divideTeam(depth+1,n,r);
		}
		
	}
	
	//두팀의 차이 체크하기
	static void checkGab(ArrayList<Integer> oneTeam, ArrayList<Integer> anotherTeam) {
		int one=0;
		int another=0;
		
		//한팀에 3명일 때   EX) {1,2,3}{4,5,6}
		// 이중for문을 통해 구하기 {1,2}+{2,1}+{1,3}+{3,1}+{2,3}+{3,2} 
		for(int i=0;i<N/2;i++) {
			for(int j=i+1;j<N/2;j++) {
				one += (map[oneTeam.get(i)][oneTeam.get(j)] + map[oneTeam.get(j)][oneTeam.get(i)]);
				another += (map[anotherTeam.get(i)][anotherTeam.get(j)] + map[anotherTeam.get(j)][anotherTeam.get(i)]);
			}
		}
		
		//전역변수인 gab 최소인값을 초기화해주기
		gab = Math.min(gab, Math.abs(one-another));
	}
}
