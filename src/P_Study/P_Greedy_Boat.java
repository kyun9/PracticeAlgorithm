package P_Study;

public class P_Greedy_Boat {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{70, 50, 80, 50},100));
	}
	public static int solution(int[] people, int limit) {
	       int answer = 0;

			Boolean[] b = new Boolean[people.length];

			for (int i = 0; i < b.length; i++) {
				b[i] = false;
			}

			int number = 0;

			for (int i = 0; i < people.length; i++) {
				if (!b[i]) {
					for (int j = i + 1; j < people.length; j++) {
						if (people[i] + people[j] <= limit) {
							if (!b[i] && !b[j]) {
								b[i] = true;
								b[j] = true;
								number++;
							}
						}
					}
					if (!b[i]&&people[i] <= limit) {
						b[i] = true;
						number++;
					}
				}
			}

			answer = number;
			return answer;
	    }
}
