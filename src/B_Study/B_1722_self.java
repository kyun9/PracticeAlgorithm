package B_Study;

import java.util.ArrayList;
import java.util.Scanner;

//메모리초과
public class B_1722_self {
	static boolean[] visited;
	static ArrayList<String> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();

		visited= new boolean[N];
		list = new ArrayList<>();
		dfs(0,N,"");
		if(k==1) {
			int num = sc.nextInt();
			System.out.println(list.get(num-1));
		}
		else {
			String s="";
			for(int i=0;i<N;i++) {
				s+=sc.nextInt()+" ";
			}
			System.out.println(list.indexOf(s)+1);
		}
		
		sc.close();
	}
	static void dfs(int depth,int N,String s) {
		if(depth==N) {
			list.add(s);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			dfs(depth+1,N,s+(i+1)+" ");
			visited[i]=false;
		}
	}
}
