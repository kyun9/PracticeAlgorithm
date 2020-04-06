package line2020;

import java.util.ArrayList;

public class c {
	static int result;
	public static void main(String[] args) {
		System.out.println(solution("111011110011111011111100011111", 3));
		System.out.println(solution("001100", 5));
	}

	static public int solution(String road, int n) {
		int answer = -1;

		int size = 0;
		for (int i = 0; i < road.length(); i++) {
			if (road.charAt(i) == '0') {
				size++;
			}
		}
		
		if(size<=n) {
			return road.length();
		}
		int a = 0;
		int[] arr = new int[size];
		boolean[] visited = new boolean[size];
		for (int i = 0; i < road.length(); i++) {
			if (road.charAt(i) == '0') {
				arr[a] = i;
				a++;
			}
		}
		String copy = road;
		result=0;
		comb(arr, visited, 0, size, n, copy);
		
		answer =result;
		return answer;

	}

	static void comb(int[] arr, boolean[] visited, int depth, int n, int r, String copy) {
		if (r == 0) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (visited[i] == true) {
					list.add(arr[i]);
				}
			}
			int M = check(list,copy);
			result=Math.max(result, M);
			
			return;
		}
		if (depth == n) {
			return;
		} else {
			visited[depth] = true;
			comb(arr, visited, depth + 1, n, r - 1, copy);

			visited[depth] = false;
			comb(arr, visited, depth + 1, n, r, copy);
		}
	}
	static int check(ArrayList<Integer> list, String copy) {
		char[] ch = copy.toCharArray();
		while(!list.isEmpty()) {
			int n = list.remove(0);
			ch[n]= '1';
		}
		int re=0;
		int val=0;
		for(int i=0;i<ch.length;i++) {
			if(ch[i]=='1') {
				val++;
			}else {
				if(re==0) {
					re=val;
				}else {
					re=Math.max(re, val);
				}
				val=0;
			}
		}
		if(val!=0) {
			re = Math.max(re, val);
		}
		return re;
	}
}
