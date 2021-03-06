package Alone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class AdjVertex implements Comparable<AdjVertex> {
	int adjVertex;
	int weight;

	public AdjVertex(int adjVertex, int weight) {
		// TODO Auto-generated constructor stub
		this.adjVertex = adjVertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(AdjVertex o) {
		// TODO Auto-generated method stub
		if (this.weight > o.getWeight())
			return 1;
		else if (this.weight == o.getWeight())
			return 0;
		else
			return -1;
	}

	public int getAdjVertex() {
		return adjVertex;
	}

	public void setAdjVertex(int adjVertex) {
		this.adjVertex = adjVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}

public class PrimMST_B1197 {

	static ArrayList<AdjVertex>[] vertexList;
	static boolean visited[];
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		vertexList = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		// 인접리스트 초기화
		for (int i = 1; i < V + 1; i++) {
			vertexList[i] = new ArrayList<AdjVertex>();
		}
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			AdjVertex av = new AdjVertex(end, weight);
			AdjVertex av2 = new AdjVertex(start, weight);
			vertexList[start].add(av);
			vertexList[end].add(av2);
		}
		// 최소값을 빼주기 위한 우선순위 큐
		PriorityQueue<AdjVertex> pq = new PriorityQueue<AdjVertex>();
		visited[1] = true;
		Iterator<AdjVertex> it = vertexList[1].iterator();
		while (it.hasNext()) {
			pq.offer(it.next());
		}
		int count = 0;
		while (!pq.isEmpty()) {
			AdjVertex pollVertex = pq.poll();
			int v = pollVertex.getAdjVertex();
			if (visited[v] == true)
				continue;
			int w = pollVertex.getWeight();
			result += w;
			visited[v] = true;
			count++;
			if (count == V + 1)
				break;
			Iterator<AdjVertex> it2 = vertexList[v].iterator();
			while (it2.hasNext()) {
				pq.add(it2.next());
			}
		}
		System.out.println(result);
	}
}
