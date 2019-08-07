package P_Study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Truck{
    int weight;
    int distance;

    public Truck(int weight, int distance){
        this.weight=weight;
        this.distance=distance;
    }
}

public class P_Queue_Truck {
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 }));
		System.out.println(solution(100, 100, new int[] { 10 }));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		 int weightLeft = weight;
	        int time=0;

	        Queue<Truck> outList = new LinkedList<Truck>();
	        List<Truck> inList = new ArrayList<Truck>();

	        for(int t : truck_weights){
	            outList.add(new Truck(t,bridge_length));
	        }

	        while(! (outList.isEmpty() && inList.isEmpty())){
	            time++;

	            if(!inList.isEmpty() && inList.get(0).distance==0){
	                weightLeft+=inList.get(0).weight;
	                inList.remove(0);

	            }

	            if(!outList.isEmpty() && outList.peek().weight<=weightLeft){
	                weightLeft-=outList.peek().weight;
	                inList.add(outList.poll());
	            }

	            for(int i=0; i<inList.size();i++){
	                inList.get(i).distance--;
	            }
	        }

	        return time;

	}
}
