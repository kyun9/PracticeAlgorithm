package B_Study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1697 {
	static int N, K;
	static int[] visited = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs();
		System.out.println(visited[K]-1);
	}

	static void bfs() {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(N);
		visited[N] = 1;

		while (!qu.isEmpty()) {
			N = qu.poll();

			if (N == K) {
				break;
			}
			if (N + 1 <= 100000 && visited[N + 1] == 0) {
				qu.add(N + 1);
				visited[N + 1] = visited[N] + 1;
			}
			if (N - 1 >= 0 && visited[N - 1] == 0) {
				qu.add(N - 1);
				visited[N - 1] = visited[N] + 1;
			}
			if (N * 2 <= 100000 && visited[N * 2] == 0) {
				qu.add(N * 2);
				visited[N * 2] = visited[N] + 1;
			}
		}
	}
}
