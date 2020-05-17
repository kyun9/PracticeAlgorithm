package coding_2020;

import java.util.ArrayList;

public class kakao_Internship2 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		String expression1 = "50*6-3*2";
		System.out.println(solution(expression));
		System.out.println(solution(expression1));
	}

	static ArrayList<Integer> nums;
	static ArrayList<Character> oper;
	static long result;
	static public long solution(String expression) {
		long answer = 0;

		int[] arr = new int[3];
		int[] output = new int[3];
		boolean[] visited = new boolean[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = i;
		}

		char[] carr = expression.toCharArray();
		nums = new ArrayList<>();
		oper = new ArrayList<>();

		String tmp = "";
		for (char c : carr) {
			if (c == '+' || c == '*' || c == '-') {
				oper.add(c);
				nums.add(Integer.parseInt(tmp));
				tmp = "";
			} else {
				tmp += c;
			}
		}
		if (!tmp.equals("")) {
			nums.add(Integer.parseInt(tmp));
		}

		result = 0;
		perm(arr, output, visited, 0, 3, 3);

		answer =result;
		return answer;
	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < output.length; i++) {
				if (visited[i]) {
					list.add(output[i]);
				}
			}
			long value = Math.abs(calNum(list));
			
			result= Math.max(result, value);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
				;
			}
		}
	}

	static long calNum(ArrayList<Integer> list) {
		ArrayList<Long> tmpNums = new ArrayList<>();
		ArrayList<Character> tmpOper= new ArrayList<>();
		for(long i : nums) {
			tmpNums.add(i);
		}
		for(char c : oper) {
			tmpOper.add(c);
		}
		while (!list.isEmpty()) {
			int n = list.remove(0);
			char op=' ';
			if (n == 0) {
				op ='+';
			} else if (n == 1) {
				op ='-';
			} else if (n == 2) {
				op ='*';
			}
			
			while(tmpOper.contains(op)) {
				int a = tmpOper.indexOf(op);
				long val =cal(tmpNums.get(a),tmpNums.get(a+1),n);
				tmpOper.remove(a);
				tmpNums.set(a, val);
				tmpNums.remove(a+1);
			}
		}
		
		return tmpNums.get(0);
	}
	static long cal(long x, long y, int n) {
		long result=0;
		if (n == 0) {
			result=x+y;
		} else if (n == 1) {
			result=x-y;
		} else if (n == 2) {
			result=x*y;
		}
		return result;
	}
}
