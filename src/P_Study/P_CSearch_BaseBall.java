package P_Study;

public class P_CSearch_BaseBall {

	public static void main(String[] args) {
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		System.out.println(solution(baseball));
	}

	static int[][] checkArr;
	static int result;
	static int solution(int[][] baseball) {
		int answer = 0;

		int[] arr = new int[9];
		for (int i = 1; i < 10; i++) {
			arr[i - 1] = i;
		}

		checkArr = baseball;

		boolean[] visited = new boolean[9];
		int[] output = new int[3];
		perm(arr, output, visited, 0, 9, 3);

		answer = result;
		return answer;
	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			String s = "";
			for (int i : output) {
				s += i;
			}
			if(checkNumber(s)) {
				result++;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	static boolean checkNumber(String s) {
		String[] st = s.split("");

		for (int i = 0; i < checkArr.length; i++) {
			String s1 = String.valueOf(checkArr[i][0]);
			String[] s1Splite = s1.split("");
			int strike =0;
			
			if (st[0].equals(s1Splite[0])) {
				strike++;
			}
			if (st[1].equals(s1Splite[1])) {
				strike++;
			}
			if (st[2].equals(s1Splite[2])) {
				strike++;
			}

			if(strike!=checkArr[i][1]) {
				return false;
			}

			int ball=0;
			for(int j=0;j<st.length;j++) {
				for(int k=0;k<s1Splite.length;k++) {
					if(j==k) {
						continue;
					}
					else if(st[j].equals(s1Splite[k])){
						ball++;
					}
					
				}
			}
			if(ball!=checkArr[i][2]) {
				return false;
			}
		}
		return true;
	}
}
