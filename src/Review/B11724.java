package Review;

import java.util.ArrayList;
import java.util.Scanner;

public class B11724 {
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int count;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int l = sc.nextInt();
		list= (ArrayList<Integer>[]) new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			list[i]= new ArrayList<Integer>();
		}
		check = new boolean[v+1];
		
		for(int i=0;i<l;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=1;i<=v;i++) {
			flag=false;
			dfs(i);
			if(flag) {
				count++;
			}
		}
		System.out.println(count);
	}
	static void dfs(int vertex) {
		if(check[vertex]) {
			return;
		}
		check[vertex]=true;
		flag=true;
		for(int i: list[vertex]) {
			if(check[i]==false) {
				dfs(i);
			}
		}
	}

}
