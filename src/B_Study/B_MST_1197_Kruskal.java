package B_Study;

import java.io.*;
import java.util.*;

class a implements Comparable<a> {
	int start;
	int end;
	int weight;

	a(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(a o) {
		return o.weight >= this.weight ? -1 : 1;
	}

}

public class B_MST_1197_Kruskal {

	static int v;
	static int e;
	static PriorityQueue<a> pq;
	static int[] parent;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.valueOf(br.readLine());
		e = Integer.valueOf(br.readLine());

		
		parent = new int[v+1];
			
		for(int i=1;i<parent.length;i++) {
			parent[i]=i;
		}
		
		for (int i = 0; i < e; i++) {
			String[] temp = br.readLine().split(" ");
			pq.add(new a(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2])));
		}
		
		
		for(int i=0;i<pq.size();i++) {
			a value = pq.poll();
			if(!isSameParent(value.start,value.end)) {
				result+=value.weight;
				union(value.start, value.end);
			}
		}
		
	}

	static int find(int n) {
		if(n==parent[n]) return n;
		parent[n]= find(parent[n]);
		return parent[n];
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x!=y) {
			parent[x]=y;
		}
		else {
			return;
		}
	}
	
	static boolean isSameParent(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x==y) {
			return true;
		}
		else return false;
		
	}
	
	
	
}
