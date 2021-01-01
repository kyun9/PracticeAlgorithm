package cos_pro;

public class a5_6 {
	public static String solution(String s1, String s2, int p, int q) {
		// 여기에 코드를 작성해주세요.
		String answer = "";

		int val1 = 0;
		for (int i = s1.length() - 1; i >= 0; i--) {
			val1 += (s1.charAt(i) - '0') * (int) (Math.pow(p, s1.length() - 1 - i));
		}
		int val2 = 0;
		for (int i = s2.length() - 1; i >= 0; i--) {
			val2 += (s2.charAt(i) - '0') * (int) (Math.pow(p, s2.length() - 1 - i));
		}

		int sum = val1 + val2;
		int remain = 0;
		while (true) {
			remain = sum % q;
			sum = sum / q;
			if (sum == 0) {
				break;
			} else {
				answer += remain;
			}
		}

		answer += remain;
		answer = (new StringBuffer(answer).reverse()).toString();
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String s1 = new String("112001");
		String s2 = new String("12010");
		int p = 3;
		int q = 8;
		String ret = solution(s1, s2, p, q);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}
}
