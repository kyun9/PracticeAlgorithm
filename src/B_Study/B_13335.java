package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Truck {
	int weight;
	int distance;

	Truck(int weight, int distance) {
		this.weight = weight;
		this.distance = distance;
	}
}

public class B_13335 {
	static int n, w, l;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		ArrayList<Truck> inList = new ArrayList<>();
		ArrayList<Truck> outList = new ArrayList<>();

		int time = 0;
		while (true) {
			time++;
			if (!inList.isEmpty()) {
				for (int i = 0; i < inList.size(); i++) {
					inList.get(i).distance++;
				}
				if (inList.get(0).distance > w) {
					outList.add(inList.remove(0));
				}

				int sum = 0;
				for (int i = 0; i < inList.size(); i++) {
					sum += inList.get(i).weight;
				}
				if (!list.isEmpty()) {
					if (sum + list.get(0) <= l) {
						inList.add(new Truck(list.remove(0), 1));
					}
				}
			} else {
				if (!list.isEmpty()) {
					inList.add(new Truck(list.remove(0), 1));
				}
			}
			if (outList.size() == n) {
				break;
			}
		}
		System.out.println(time);
	}

}
