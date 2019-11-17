package B_Study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class AdjVertex implements Comparable<AdjVertex>{
	int adjVertex;
	int weight;
	
	AdjVertex(int adjVertex, int weight){
		this.adjVertex=adjVertex;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(AdjVertex o) {
		if(this.weight>o.getWeight())
			return 1;
		else if(this.weight==o.getWeight())
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



public class B_MST_1197 {
	static ArrayList<AdjVertex>[] vertexList;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		vertexList = new ArrayList[v+1];
		visited = new boolean[v+1];
		
		for(int i=1;i<v+1;i++) {
			vertexList[i]= new ArrayList<>();
		}
		
		for(int i=0;i<e;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			
			AdjVertex av= new AdjVertex(end,weight);
			AdjVertex av2 = new AdjVertex(start,weight);
			
			vertexList[start].add(av);
			vertexList[end].add(av2);
		}
		
		PriorityQueue<AdjVertex> pq = new PriorityQueue<>();
		visited[1]=true;
		Iterator<AdjVertex> it = vertexList[1].iterator();
		while(it.hasNext()) {
			pq.offer(it.next());
		}
		int count=0;
		while(!pq.isEmpty()) {
			AdjVertex pollVertex = pq.poll();
			int a = pollVertex.getAdjVertex();
			if(visited[a]==true)
				continue;
			int b = pollVertex.getWeight();
			result +=b;
			visited[a]=true;
			count++;
			if(count == v+1) break;
			Iterator<AdjVertex> it2= vertexList[a].iterator();
			while(it2.hasNext()) {
				pq.add(it2.next());
			}
		}
		System.out.println(result);
	}

}
