package coding_2020;

import java.util.ArrayList;

public class s_summercoding3 {

	public static void main(String[] args) {
		System.out.println(solution(121, new int[][] { { 1, 2 }, { 1, 3 }, { 3, 6 }, { 3, 4 }, { 3, 5 } }));
	}

	static ArrayList<Integer>[] list;
	static int tmp;
	static public int[] solution(int total_sp, int[][] skills) {
		int[] answer = {};

		list = new ArrayList[skills.length +2];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < skills.length; i++) {
			list[skills[i][0]].add(skills[i][1]);
		}

		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}

		answer = new int[skills.length+1];
		solve(answer, 1,1);
		
		for(int i : answer) {
			System.out.print(i+" ");
		}
		return answer;
	}

	static void solve(int[] answer, int idx, int depth) {
		if(list[idx].isEmpty()) {
			answer[idx-1]=depth;
			return;
		}
		tmp =0;
		for (int i = 0; i < list[idx].size(); i++) {
			solve(answer, list[idx].get(i), depth+1);
			
		}

	}
}
