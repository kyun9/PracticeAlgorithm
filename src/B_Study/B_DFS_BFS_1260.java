package B_Study;

import java.util.Scanner;
import java.util.Stack;

public class B_DFS_BFS_1260 {
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

		boolean[][] visited = new boolean[info[0]][info[0]];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 0;
				if (i == j)
					visited[i][j] = true;
				else
					visited[i][j] = false;
			}
		}

		boolean[] check = new boolean[info[0]];
		while (count < info[1]) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			arr[a][b] = 1;
			arr[b][a] = 1;
			count++;
		}

		visited[info[2] - 1][info[2] - 1] = true;

		LinkedList<Integer> list = new LinkedList<>();
		list.add(info[2] - 1);
		dfs(arr, visited, check, 0, list);

//	   for(int i=0;i<arr.length;i++) {
//		   	for(int j=i+1;j<arr[i].length;j++) {
//		   		if(arr[i][j]==1&&visited[i][j]==false) {
//		   			
//		   		}
//		   	}
//	   }
		System.out.println("결과");
		for (int i : list)
			System.out.print(i + " ");
		sc.close();
	}

	static void dfs(int[][] arr, boolean[][] visited, boolean[] check, int depth, LinkedList<Integer> list) {
		if (depth == arr.length - 1) {
			System.out.println(depth);
			return;
		}
		for (int i = depth; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (list.size() == 4)
					return;
				else if (arr[i][j] == 1 && visited[i][j] == false && check[j]==false) {
					visited[i][j] = true;
					visited[j][i] = true;
					check[i]=true;
					System.out.println("i = " + i + " j = " + j);
					list.add(j);
					dfs(arr, visited, check,j, list);
				}
			}
		}
		//for 두번돌아서 값이 생각이랑 다르게 나와 확인해보쟈
	}


}
