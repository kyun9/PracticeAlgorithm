package cos_pro;

class Pair2 {
	public int firstNum;
	public int secondNum;
}

public class a1_10 {

	public static int func_a(int numA, int numB, char exp) {
		if (exp == '+')
			return numA + numB;
		else if (exp == '-')
			return numA - numB;
		else
			return numA * numB;
	}

	public static int func_b(String exp) {
		for (int i = 0; i < exp.length(); i++) {
			char e = exp.charAt(i);
			if (e == '+' || e == '-' || e == '*')
				return i;
		}
		return -1;
	}

	public static Pair2 func_c(String exp, int idx) {
		Pair2 ret = new Pair2();
		ret.firstNum = Integer.parseInt(exp.substring(0, idx));
		ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
		return ret;
	}

	public static int solution(String expression) {
		int expIndex = func_b(expression);
		Pair2 numbers = func_c(expression, expIndex);
		int result = func_a(numbers.firstNum, numbers.secondNum, expression.charAt(expIndex));
		return result;
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		String expression = "123+12";
		int ret = solution(expression);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret + " .");
	}
}
