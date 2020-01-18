package StudyAlgorithm_SWEA;

import java.util.PriorityQueue;
import java.util.Scanner;

class Island implements Comparable<Island> {
	int start;
	int end;
	double cost;

	Island(int start, int end, double cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Island o) {
		// TODO Auto-generated method stub
		return o.cost >= this.cost ? -1 : 1;
	}
}

public class S_1251 {
	static double result;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int size = sc.nextInt();
			int[] arrX = new int[size];
			int[] arrY = new int[size];

			parent = new int[size + 1];
			for (int i = 1; i < size + 1; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < size; i++) {
				arrX[i] = sc.nextInt();
			}
			for (int i = 0; i < size; i++) {
				arrY[i] = sc.nextInt();
			}
			double E = sc.nextDouble();

			PriorityQueue<Island> pq = new PriorityQueue<>();
			double cost = 0;
			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					double dx = Math.pow((arrX[i] - arrX[j]), 2);
					double dy = Math.pow((arrY[i] - arrY[j]), 2);
					cost = (dx + dy) * E;
					pq.add(new Island(i + 1, j + 1, cost));
				}
			}

			result=0;
			while (!pq.isEmpty()) {
				Island island = pq.poll();
				if (!isSameParent(island.start, island.end)) {
					result += island.cost;
					union(island.start, island.end);
				}
			}

			System.out.println("#"+test+" "+Math.round(result));
		}
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
		} else {
			return;
		}
	}

	static boolean isSameParent(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x == y) {
			return true;
		} else {
			return false;
		}
	}
}
