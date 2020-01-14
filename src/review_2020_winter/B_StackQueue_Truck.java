package review_2020_winter;

import java.util.ArrayList;

class Truck {
	int weight;
	int distance;

	Truck(int weight, int distance) {
		this.weight = weight;
		this.distance = distance;
	}
}

public class B_StackQueue_Truck {

	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 }));
		System.out.println(solution(100,100,new int[] {10}));
		System.out.println(solution(100,100,new int[] {10,10,10,10,10,10,10,10,10,10}));
	}

	static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int size = truck_weights.length;
		ArrayList<Truck> list = new ArrayList<>();
		ArrayList<Truck> inList = new ArrayList<>();
		ArrayList<Truck> outList = new ArrayList<>();

		for (int i : truck_weights) {
			list.add(new Truck(i, 0));
		}

		while (true) {
			time++;
			if (!inList.isEmpty()) {
				for (int i = 0; i < inList.size(); i++) {
					inList.get(i).distance++;
				}
				if (inList.get(0).distance > bridge_length) {
					outList.add(inList.remove(0));
				}
			}
			if (outList.size() == size) {
				break;
			}

			if (inList.isEmpty()) {
				Truck t = list.remove(0);
				t.distance++;
				inList.add(t);
			} else {
				int sumWeights = 0;
				for (Truck t : inList) {
					sumWeights += t.weight;
				}
				if (!list.isEmpty()&&list.get(0).weight + sumWeights <= weight) {
					Truck t = list.remove(0);
					t.distance++;
					inList.add(t);
				}
			}
		}

		return time;
	}
}
