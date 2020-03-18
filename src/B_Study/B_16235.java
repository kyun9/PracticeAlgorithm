package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int age;

	Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}

	@Override
	public int compareTo(Tree o) {
		return this.age - o.age;
	}

}

public class B_16235 {
	static int N, M, K;
	static int[][] map;
	static int[][] A;
	static ArrayList<Tree> list;
	static ArrayList<Tree> liveList;
	static ArrayList<Tree> deadList;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		A = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}


		// 년
		while (K > 0) {
			liveList = new ArrayList<>();
			deadList = new ArrayList<>();
			// 봄
			spring();
			// 여름
			summer();
			// 가을
			autumn();
			// 겨울
			winter();

			K--;
//			System.out.println();
		}
		System.out.println(list.size());
	}

	static void spring() {
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			Tree tree = list.get(i);
			if (map[tree.x][tree.y] - tree.age < 0) {
				deadList.add(new Tree(tree.x,tree.y,tree.age));
			} else {
				map[tree.x][tree.y] -= tree.age;
				liveList.add(new Tree(tree.x,tree.y,tree.age+1));
			}
		}
		list.clear();
		list = new ArrayList<>(liveList);
//		System.out.println("spring");
//		for (Tree t : list) {
//			System.out.println(t.x + " " + t.y + " " + t.age);
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

	static void summer() {
		for (int i = 0; i < deadList.size(); i++) {
			Tree tree = deadList.get(i);
			map[tree.x][tree.y] += tree.age / 2;
		}

//		System.out.println("summer");
//		for (Tree t : list) {
//			System.out.println(t.x + " " + t.y + " " + t.age);
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

	static void autumn() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).age % 5 == 0) {
				Tree tree = list.get(i);

				for (int j = 0; j < 8; j++) {
					int x = tree.x + dx[j];
					int y = tree.y + dy[j];

					if (0 <= x && x < N && 0 <= y && y < N) {
						list.add(new Tree(x, y, 1));
					}
				}
			}
		}
//		System.out.println("autumn");
//		for (Tree t : list) {
//			System.out.println(t.x + " " + t.y + " " + t.age);
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += A[i][j];
			}
		}

//		System.out.println("winter");
//		for (Tree t : list) {
//			System.out.println(t.x + " " + t.y + " " + t.age);
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

}
