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
		int time=0;
		
		for(int i:truck_weights)
			list.add(i);
		
		while(!list.isEmpty()) {
			if(!passing.isEmpty()) {
				if((passing.get(0)+list.get(0)>weight)) {
					time++;
				}
				else {
					
				}
			}
			else {
				passing.add(list.remove(0));
				time++;
			}
		}
		
		
		return answer;
	}
}
