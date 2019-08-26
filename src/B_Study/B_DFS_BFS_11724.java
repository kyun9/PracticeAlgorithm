package B_Study;

import java.util.ArrayList;
import java.util.Scanner;

public class B_DFS_BFS_11724 {
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int count;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int l = sc.nextInt();
		list = (ArrayList<Integer>[]) new ArrayList[v + 1];
		for(int i=1;i<=v;i++) {
			list[i]= new ArrayList<Integer>();
		}
		check = new boolean[v+1];
		for(int i=0;i<l;i++) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		check= new boolean[v+1];
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
		flag =true;
		for(int i : list[vertex]) {
			if(check[i]==false) {
				dfs(i);
			}
		}
	}
}



//static을 안쓰고 이래 풀 수도 있어 더 간단하네

//public class Main {
//    public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
//        if (c[x]) {
//            return;
//        }
//        c[x] = true;
//        for (int y : a[x]) {
//            if (c[y] == false) {
//                dfs(a, c, y);
//            }
//        }
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
//        for (int i=1; i<=n; i++) {
//            a[i] = new ArrayList<Integer>();
//        }
//        for (int i=0; i<m; i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            a[u].add(v);
//            a[v].add(u);
//        }
//        boolean[] check = new boolean[n+1];
//        int ans = 0;
//        for (int i=1; i<=n; i++) {
//            if (check[i] == false) {
//                dfs(a, check, i);
//                ans += 1;
//            }
//        }
//        System.out.println(ans);
//                
//
//    }
