package B_theSecondHalfOfTheYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair5 {
	int x;
	int y;

	Pair5(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 백준_치킨배달_15686 {
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
	//치킨집 위치 리스트
	static ArrayList<Pair5> chickenList = new ArrayList<>();
	// 집 위치 리스트
	static ArrayList<Pair5> homeList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//치킨집 리스트에 담기
				if (map[i][j] == 2) {
					chickenList.add(new Pair5(i, j));
				} else if (map[i][j] == 1) {
					// 집 리스트에 담기
					homeList.add(new Pair5(i, j));
				}
			}
		}

		boolean[] visited = new boolean[chickenList.size()];
		//조합으로 치킨집 뽑기
		comb(0, chickenList.size(), M, visited);
		System.out.println(result);
	}

	static void comb(int depth, int n, int r, boolean[] visited) {
		if (r == 0) {
			//리스트에 뽑힌 치킨집 담기
			ArrayList<Pair5> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					list.add(new Pair5(chickenList.get(i).x, chickenList.get(i).y));
				}
			}
			//도시의 치킨 거리 최소값 담기 
			result = Math.min(result, checkDis(list));
			return;
		}
		if (depth == n) {
			return;
		}

		visited[depth] = true;
		comb(depth + 1, n, r - 1, visited);
		visited[depth] = false;
		comb(depth + 1, n, r, visited);
	}

	// 집마다의 가장 가까운 치킨집과의 치킨거리구한후
	// 모든 집의 치킨 거리의 합을 구하는 메소드
	static int checkDis(ArrayList<Pair5> list) {
		int sum=0;
		for (int i = 0; i < homeList.size(); i++) {
			int val=Integer.MAX_VALUE;
			for (int j = 0; j < list.size(); j++) {
				int distance = Math.abs(homeList.get(i).x - list.get(j).x)+ Math.abs(homeList.get(i).y- list.get(j).y);
				val = val > distance ? distance :val; 
			}
			sum += val;
		}
		
		return sum;

	}
}
