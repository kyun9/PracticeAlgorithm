package P_Study;

import java.util.ArrayList;
import java.util.Queue;

public class P_Stack_Truck {
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 }));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		 int answer = 0;
	      ArrayList<Integer> passing = new ArrayList<>();
	      ArrayList<Integer> passed = new ArrayList<>();
	      ArrayList<Integer> list = new ArrayList<>();
	      int time = 0;
	      ArrayList<Integer> bl = new ArrayList<>();

	      for (int i : truck_weights)
	         list.add(i);

	      int sum = 0;
	      while (!list.isEmpty()) {
	    	  if (!passing.isEmpty()) {
	            if ((sum + list.get(0) > weight)) {
	            } else {
	               sum += list.get(0);
	               passing.add(list.remove(0));
	               bl.add(0);
	            }
	         } else {
	            sum += list.get(0);
	            passing.add(list.remove(0));
	            bl.add(0);
	         }
	         time++;
	         for(int i=0;i<bl.size();i++) {
	        	bl.add(bl.get(i)+1);
	         }
	         if(bl.get(0)>bridge_length) {
	        	 sum-=passing.get(0);
	        	 passed.add(passing.remove(0));
	        	 bl.remove(0);
	         }
	      }
	      
	      return answer;

	}
}
