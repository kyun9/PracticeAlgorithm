package P_Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution1 {

	int n;
	int[] arr;
	List<String> list = new ArrayList<>();
	String tmp;

	Solution1(int[] ary) {
		this.n = ary.length;
		this.arr = new int[ary.length];
	}

	void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	void perm(int[] ary, int depth) {
		if (depth == n) {
			tmp="";
			for(int i=0;i<arr.length;i++) {
				tmp +=arr[i];
			}
			list.add(tmp);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(ary, depth, i); 
			arr[depth] = ary[depth]; 
			perm(ary, depth + 1); 
			swap(ary, depth, i); 
		}
	}

	public String solution(int[] numbers) {
		String answer = "";
		perm(numbers, 0);
		
		Collections.sort(list);
		Collections.reverse(list);

		answer=list.get(0);
		
		return answer;
	}
}

public class P_Sort_TheGreatestNumber2 {
	public static void main(String[] args) {
		int[] arr = {3, 30, 34, 5, 9 };
		Solution1 main = new Solution1(arr);
		
		System.out.println(main.solution(arr));
	}

}
