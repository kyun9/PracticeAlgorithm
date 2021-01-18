package cos_pro;

public class a1_6 {

	public static int func(int record) {
		if (record == 0)
			return 1;
		else if (record == 1)
			return 2;
		return 0;
	}

	public static int solution(int[] recordA, int[] recordB) {
		int cnt = 0;
		for (int i = 0; i < recordA.length; i++) {
			if (recordA[i] == recordB[i])
				continue;
			else if (recordA[i] == func(recordB[i]))
				cnt = cnt + 3;
			else
				cnt = Math.max(0, cnt-1);
		}
		return cnt;
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		int[] recordA = { 2, 0, 0, 0, 0, 0, 1, 1, 0, 0 };
		int[] recordB = { 0, 0, 0, 0, 2, 2, 0, 2, 2, 2 };
		int ret = solution(recordA, recordB);

		System.out.println("Solution: return value of the method is " + ret + " .");
	}
}
