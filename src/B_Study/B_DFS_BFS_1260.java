package B_Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_DFS_BFS_1260 {
	static ArrayList<Integer>[] list;
	static boolean check[];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		list = (ArrayList<Integer>[]) new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(list[i]);
		}
		check = new boolean[n + 1];
		dfs(v);
		System.out.println();
		check = new boolean[n+1];
        bfs(v);
        System.out.println();
	}

	static void dfs(int v) {
		if (check[v]) {
			return;
		}
		check[v] = true;
		System.out.print(v + " ");
		for (int y : list[v]) {
			if (check[y] == false)
				dfs(y);
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		check[v]=true;
		while(!q.isEmpty()) {
			int num = q.remove();
			System.out.print(num + " ");
			for(int y : list[num]) {
				if(check[y]==false) {
					check[y]=true;
					q.add(y);
				}
			}
		}
		
	}

}