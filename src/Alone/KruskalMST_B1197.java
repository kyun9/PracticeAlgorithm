package Alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class a implements Comparable<a> {
	int start;
	int end;
	int weight;

	a(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	/*
	 * 양수리턴 : this 오브젝트가 앞에 위치 음수리턴 : this 오브젝트가 뒤에 위치 0리턴 : 동일한 값으로 간주하고 입력 순서 유지
	 */
	public int compareTo(a o) {
		return o.weight >= this.weight ? -1 : 1;
	}

}

public class KruskalMST_B1197 {
	static int v;
	static int e;
	static PriorityQueue<a> pq;
	static int[] parent;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.valueOf(br.readLine());
		e = Integer.valueOf(br.readLine());

		parent = new int[v + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}

		pq = new PriorityQueue<a>();
		for (int i = 0; i < e; i++) {
			String[] temp = br.readLine().split(" ");
			pq.add(new a(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2])));
		}

		for (int i = 0; i < e; i++) {
			a value = pq.poll();
			if (!isSameParent(value.start, value.end)) {
				result += value.weight;
				union(value.start, value.end);
			}

		}
		System.out.println(result);
	}

	static int find(int n) {
		if (n == parent[n])
			return n;
		parent[n] = find(parent[n]);
		return parent[n];
	}

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x != y) {
			parent[x] = y;
		} else
			return;
	}

	static boolean isSameParent(int a, int b) {
		int x = find(a);
		int y = find(b);

		if (x == y) {
			return true;
		} else
			return false;
	}

}
