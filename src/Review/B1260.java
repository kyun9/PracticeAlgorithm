package Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {
	static ArrayList<Integer>[] list;
	static boolean check[];
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m = sc.nextInt();
		int v= sc.nextInt();
		list= (ArrayList<Integer>[])new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			list[i]= new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b= sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		check= new boolean[n+1];
		dfs(v);
	}
	static void dfs(int v) {
		if(check[v]=true) {
			return;
		}
		check[v]=true;
		for(int y:list[v]) {
			if(check[y]==false) {
				dfs(y);
			}
		}
	}
	static void bfs(int v) {
		Queue<Integer> q =new LinkedList<Integer>();
		q.add(v);
		check[v]=true;
		while(!q.isEmpty()) {
			int num= q.remove();
			for(int y:list[num]) {
				if(check[y]==false) {
					check[y]=true;
					q.add(y);
				}
			}
		}
	}

}
