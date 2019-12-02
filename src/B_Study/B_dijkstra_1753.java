package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge{
	int end;
	int value;
	
	Edge(int end, int value){
		this.end= end;
		this.value=value;
	}
}

public class B_dijkstra_1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int V = Integer.valueOf(line[0]);
		int E = Integer.valueOf(line[1]);
		int start = Integer.valueOf(br.readLine());
		int[] distance = new int[V+1];
		boolean[] check = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		ArrayList<Edge>[] list = new ArrayList[V+1];
		
		for(int i=0;i<list.length;i++) {
			list[i]= new ArrayList<>();
		}
		
		
		for(int i=0;i<E;i++) {
			line = br.readLine().split(" ");
			list[Integer.valueOf(line[0])].add(new Edge(Integer.valueOf(line[1]),Integer.valueOf(line[2])));
		}
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(start);
		distance[start]=0;
		
		while(!pq.isEmpty()) {
			int current = pq.poll();
			check[current]=true;
			
			for(int i=0;i<list[current].size();i++) {
				int next= list[current].get(i).end;
				int value = list[current].get(i).value;
				
				if(distance[next]>distance[current]+value) {
					distance[next]=distance[current]+value;
					pq.add(next);
				}
			}
		}
		
		for(int i=1;i<distance.length;i++) {
			if(check[i]) {
				System.out.println(distance[i]);
			}
			else {
				System.out.println("INF");
			}
		}
	}

}
