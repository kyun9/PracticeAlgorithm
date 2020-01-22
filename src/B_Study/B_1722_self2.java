package B_Study;

import java.util.Scanner;

//메모리 초과
public class B_1722_self2 {
	static boolean[] visited;
	static int num, cnt,k;
	static boolean flag;
	static String st;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		k = sc.nextInt();

		visited= new boolean[N];
		
		cnt=0; flag= false; st="";
		if(k==1) {
			num = sc.nextInt();
			dfs(0,N,"");
			System.out.println(st);
		}
		else {
			for(int i=0;i<N;i++) {
				st+=sc.nextInt()+" ";
			}
			dfs(0,N,"");
			System.out.println(cnt);
		}
		
		sc.close();
	}
	static void dfs(int depth,int N,String s) {
		if(depth==N) {
			cnt++;
			if(k==1) {
				if(cnt==num) {
					flag=true;
					st=s;
				}
			}
			else {
				if(st.equals(s)) {
					flag=true;
				}
			}
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			dfs(depth+1,N,s+(i+1)+" ");
			visited[i]=false;
			if(flag) {
				return;
			}
		}
	}
}
