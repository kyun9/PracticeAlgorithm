package P_Study;

import java.util.PriorityQueue;

public class P_Heap_Hot {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		
		System.out.println(solution(scoville, k));
	}
	public static int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        
        for(int val : scoville)
        	qu.add(val);
        
        int first=0,second=0;
        int cnt =0;
        	
        
        while(first<=k) {
        	first= qu.poll();
        	second =qu.poll();
        	
        	qu.add(first+second*2);
        	first =qu.peek();
        	cnt++;
        }
        answer =cnt;
        
        return answer;
    }
}
