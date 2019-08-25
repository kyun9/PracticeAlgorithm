package B_Study;

import java.util.LinkedList;
import java.util.Scanner;

public class B_DFS_BFS_1260_m {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int[] info = new int[3];
		while (count < 3) {
			info[count] = sc.nextInt();
			count++;
		}
		count = 0;
		int[][] arr = new int[info[0]][info[0]];

		boolean[][] dfs_visited = new boolean[info[0]][info[0]];
		boolean[][] bfs_visited = new boolean[info[0]][info[0]];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 0;
				if (i == j) {
					dfs_visited[i][j] = true;
					bfs_visited[i][j] = true;
				}
			}
		}

		boolean[] dfs_check = new boolean[info[0]];
		while (count < info[1]) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			arr[a][b] = 1;
			arr[b][a] = 1;
			count++;
		}

		dfs_visited[info[2] - 1][info[2] - 1] = true;
		bfs_visited[info[2] - 1][info[2] - 1] = true;

		LinkedList<Integer> dlist = new LinkedList<>();
		dfs_check[info[2] - 1] = true;
		dlist.add(info[2] - 1);
		dfs(arr, dfs_visited, dfs_check, info[2] - 1, dlist);
//dfs
		for (int i : dlist)
			System.out.print(i + 1 + " ");
		System.out.println();

		LinkedList<Integer> blist = new LinkedList<>();
		LinkedList<Integer> rlist = new LinkedList<>();
		blist.add(info[2] - 1);
		bfs(arr, bfs_visited, info[2] - 1, blist, rlist);
//bfs		
		for (int i : rlist)
			System.out.print(i + 1 + " ");

		sc.close();
	}

	static void dfs(int[][] arr, boolean[][] dfs_visited, boolean[] dfs_check, int depth, LinkedList<Integer> list) {
		if (list.size() == arr.length)
			return;
		for (int j = 0; j < arr[depth].length; j++) {
			if (arr[depth][j] == 1 && dfs_visited[depth][j] == false && dfs_check[j] == false) {
				dfs_visited[depth][j] = true;
				dfs_visited[j][depth] = true;
				dfs_check[j] = true;
				list.add(j);
				dfs(arr, dfs_visited, dfs_check, j, list);
			}
		}
	}

	static void bfs(int[][] arr, boolean[][] bfs_visited, int depth, LinkedList<Integer> list,
			LinkedList<Integer> rlist) {
		if (rlist.size() == arr.length)
			return;
		rlist.add(list.remove());
		for (int j = 0; j < arr[depth].length; j++) {
			if (arr[depth][j] == 1 && bfs_visited[depth][j] == false) {
				bfs_visited[depth][j] = true;
				bfs_visited[j][depth] = true;
				list.add(j);
			}
		}
		if (list.isEmpty())
			return;
		bfs(arr, bfs_visited, list.peek(), list, rlist);
	}

}
