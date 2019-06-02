package P_Study;

import java.util.ArrayList;
import java.util.LinkedList;

class Print {
	int num;
	int prior;

	Print(int num, int prior) {
		this.num = num;
		this.prior = prior;
	}
}

public class P_Queue_Printer_1 {
	public static void main(String[] args) {
//		int[] priorities = new int[] { 2, 1, 3, 2 };
//	      int location = 2;
		int[] priorities = new int[] { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;

		LinkedList<Print> ll = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			ll.add(new Print(i, priorities[i]));
		}

		Print first = null;
		boolean b = false;
		ArrayList<Integer> idx = new ArrayList<>();

		while (!ll.isEmpty()) {
			b = false;
			first = ll.peek();
			
			for (int i = 1; i < ll.size(); i++) {
				if (first.prior < ll.get(i).prior) {
					b = true;
				}
			}

			if (b) {
				ll.removeFirst();
				ll.add(first);

			} else {
				idx.add(first.num + 1);
				ll.removeFirst();
			}

		}

		for (int i = 0; i < idx.size(); i++) {
			if (idx.get(i) == location + 1) {
				answer = i + 1;
			}
		}
		return answer;
	}
}
