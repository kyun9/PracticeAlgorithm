package cos_pro;

public class a1_3 {

	public static int solution(String pos) {
		int answer = 0;

		int x = 8 - (pos.charAt(1) - '0');
		int y = pos.charAt(0) - 'A';

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((Math.abs(i - x) + Math.abs(j - y)) == 3) {
					if (x == i || y == j) {
						break;
					} else {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		String pos = "A7";
		int ret = solution(pos);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret + " .");
	}
}
