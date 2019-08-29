package B_Study;

import java.util.ArrayList;
import java.util.Scanner;

public class B_BipartiteGraph_1707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cycle = sc.nextInt();
		while (cycle-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[n + 1];
			
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < m; i++) {
				int node1 = sc.nextInt();
				int node2 = sc.nextInt();
				list[node1].add(node2);
				list[node2].add(node1);
			}
			
			int[] color = new int[n + 1];     //이분그래프 확인해주기 위한 int형 배열    , node별로 1,2로 색 구별
			boolean confirm = true;
			
			for (int i = 1; i <= n; i++) {
				if (color[i] == 0) {
					dfs(list, color, i, 1);   //처음 depth 1로 정해줌
				}
			}
			
			// 연결리스트에서 서로 인접해 있는지 확인하는 for 문
			for(int i=1;i<=n;i++) {
				for(int j: list[i]) {
					if(color[i]==color[j]) {
						confirm =false;
					}
				}
			}
			
			if(confirm) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}

		}
	}

	static void dfs(ArrayList<Integer>[] list, int[] color, int c, int depth) {
		color[c]= depth;
		for(int i : list[c]) {
			if(color[i]==0) {
				dfs(list,color,i,3-depth);    //3-depth 을 통해서 1,2로 구분
			}
		}
	}

}
