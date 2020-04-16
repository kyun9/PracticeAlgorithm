package Review;

import java.util.ArrayList;

public class P_origami {

	public static void main(String[] args) {
		System.out.println(solution(3));
	}
	public static int[] solution(int n) {
		int[] answer = {};
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		
		for(int i=2;i<=n;i++) {
			list.add(0);
			int size = list.size();
			for(int j=size-2;j>=0;j--) {
				if(list.get(j)==1) {
					list.add(0);
				}else {
					list.add(1);
				}
			}
		}

		int size = list.size();
		answer = new int[size];
		for(int i=0;i<size;i++) {
			answer[i]= list.get(i);
		}
		
		
		return answer;
	}
}
