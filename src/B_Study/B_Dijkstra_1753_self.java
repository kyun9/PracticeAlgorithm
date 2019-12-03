package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge2{
	int end;
	int weight;
	
	Edge2(int end, int weight){
		this.end = end;
		this.weight=weight;
	}
}

class Graph {
	int n;
	ArrayList<Edge2>[] list;

	Graph(int n) {
		this.n = n;
		list = new ArrayList[n+1];
		for(int i=0;i<list.length;i++) {
			list[i]= new ArrayList<>();
		}
	}

	void input(int i, int j, int w) {
		list[i].add(new Edge2(j,w));
	}

	void dijkstra(int v) {
		int[] distance = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[v] = 0;
		visited[v] = true;
		for (int i = 0; i < list[v].size(); i++) {
			if (!visited[list[v].get(i).end]) {
				distance[list[v].get(i).end] = list[v].get(i).weight;
			}
		}

		
		for (int a = 0; a < n - 1; a++) {
			int min = Integer.MAX_VALUE;
			int min_index = -1;

			for (int i = 1; i < n + 1; i++) {
				if (!visited[i] && distance[i] != Integer.MAX_VALUE) {
					if (distance[i] < min) {
						min = distance[i];
						min_index = i;
					}
				}
			}

			if (min_index != -1) {
				{
					visited[min_index] = true;
					for (int i = 0; i < list[min_index].size(); i++) {
						if (!visited[list[min_index].get(i).end]) {
							if (distance[list[min_index].get(i).end] > distance[min_index] + list[min_index].get(i).weight) {
								distance[list[min_index].get(i).end] = distance[min_index] + list[min_index].get(i).weight;
							}
						}
					}
				}
			}
		}
		for (int i = 1; i < n + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);

			}
		}
	}
}

public class B_Dijkstra_1753_self {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(br.readLine());

		Graph g = new Graph(V);
		for (int i = 0; i < E; i++) {
			String[] line = br.readLine().split(" ");
			g.input(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
		}
		g.dijkstra(5);
	}

}
