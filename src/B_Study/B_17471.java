package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17471 {
	static int N,sum,gap, result;
	static int[] peo;
	static int[][] link;
	static int[] group;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		peo = new int[N+1];
		link= new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			peo[i]= Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j=0;j<size;j++) {
				link[i][Integer.parseInt(st.nextToken())]=1;
			}
		}
		
		result= Integer.MAX_VALUE;
		for(int i=0;i<(N/2)+1;i++) {
			boolean[] check = new boolean[N+1];
			comb(1,i,check);
		}
		if(result==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
	static void comb(int start, int r, boolean[] check) {
		if(r==0) {
			gap=Integer.MAX_VALUE;
			confrim(check);
			result= Math.min(result, gap);
			return;
		}
		for(int i=start;i<N+1;i++) {
			check[i]=true;
			comb(i+1,r-1,check);
			check[i]=false;
		}
	}
	
	static void confrim(boolean[] check) {
		visited= new boolean[N+1];
		int people1=0;
		int people2=0;
		
		
		for(int i=1;i<N+1;i++) {
			if(!visited[i]&&check[i]) {
				sum=0;
				connectRel(i,check);
				people1 = sum;
				break;
			}
		}
		for(int i=1;i<N+1;i++) {
			if(!visited[i]&&!check[i]) {
				sum=0;
				connectRel(i,check);
				people2 = sum;
				break;
			}
		}
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				return;
			}
		}
		
		gap = Math.abs(people1-people2);
		
	}
	
	static void connectRel(int x,boolean[] check) {
		visited[x]=true;
		sum+=peo[x];
		for(int i=1;i<N+1;i++) {
			if(!visited[i]&&check[x]==check[i]&&link[x][i]==1) {
				connectRel(i,check);
			}
		}
	}
}
