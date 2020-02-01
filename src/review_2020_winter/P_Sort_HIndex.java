package review_2020_winter;

import java.util.ArrayList;
import java.util.Collections;

public class P_Sort_HIndex {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}

	static int solution(int[] citations) {
		int answer = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i: citations) {
			list.add(i);
		}
		Collections.sort(list);
		Collections.reverse(list);
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<=i) {
				answer=i;
				return answer;
			}	
		}
		answer=	list.size();
		return answer;
	}
}
