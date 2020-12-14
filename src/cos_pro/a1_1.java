package cos_pro;

public class a1_1 {
	public static long solution(long num) {
		long answer = 0;

		num += 1;
		int digit = 1;

		while ((num / digit) % 10 == 0) {
			num += digit;
			digit *= 10;
		}
		
		answer = num;
		return answer;
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		long num = 9949999;
		long ret = solution(num);

		System.out.println("Solution: return value of the method is " + ret + " .");
	}
}
