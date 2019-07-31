package P_Study;

import java.util.ArrayList;

public class P_Stack_Truck {
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 }));
//		System.out.println(solution(100, 100, new int[] {10}));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
	      ArrayList<Integer> passing = new ArrayList<>();
	      ArrayList<Integer> passed = new ArrayList<>();
	      ArrayList<Integer> list = new ArrayList<>();
	      ArrayList<Integer> bl = new ArrayList<>();
	      
	      for(int i : truck_weights )
	         list.add(i);
	      
	      int time = 1;
	      passing.add(list.remove(0));
	      bl.add(1);
	      int sum=passing.get(0);
	      while(!passing.isEmpty()) {
	         if(bl.get(0)==bridge_length) {
	            sum-=passing.get(0);
	            bl.remove(0);
	            passing.remove(0);
	         }
	         if(!list.isEmpty()) {
	            if(passing.isEmpty()) {
	               sum+=list.get(0);
	               passing.add(list.remove(0));
	               bl.add(0);
	            }
	            else if(sum+list.get(0)<weight) {
	               sum+=list.get(0);
	               passing.add(list.remove(0));
	               bl.add(0);
	            }
	         }
	         else break;
	         for(int i=0;i<bl.size();i++) {
	            bl.set(i,bl.get(i)+1);
	         }
	         time++;
	      }
	      for(int i : bl)
	         System.out.println(i);
	      System.out.println();
	      int num = bl.get(bl.size()-1);
	      System.out.println(time);
	      System.out.println(num);
	      time+=1;
	      while(num++<bridge_length) {
	         time++;
	      }
	      System.out.println(time);
	      System.out.println(num);
	      answer=time;
	      return answer;

	}
}
