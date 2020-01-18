package review_2020_winter;

import java.util.Collections;
import java.util.PriorityQueue;

public class P_Heap_Rameo {

	public static void main(String[] args) {
		System.out.println(solution(4,new int[] {4,10,15}, new int[]{20,5,10,30},30));
		System.out.println(solution(4, new int[] {1, 2, 3, 4}, new int[] {10, 40, 30, 20}, 100));
	}

	static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		
		PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
		int cnt =0;
		for(int i=0;i<k;i++) {
			if(cnt < dates.length && i == dates[cnt]) {
				qu.add(supplies[cnt]);
				cnt++;
			}
				
			if(stock==0) {
				stock+=qu.poll();
				answer++;
			}
				
			stock--;
		}
		
		return answer;
	}
}
