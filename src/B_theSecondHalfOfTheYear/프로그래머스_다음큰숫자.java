package B_theSecondHalfOfTheYear;

public class 프로그래머스_다음큰숫자 {
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
		System.out.println(solution(15));
	}

	//와 미친풀이....
	static int solution(int n) {
		//String nBi = Integer.toBinaryString(n); // n 이진수화 해주는 메소드
		int count = Integer.bitCount(n); // 이진으로 나타내고 1인 비트의 수를 리턴해주는 메소드
		for (int i = n + 1;; i++) { // 조건1.
			if (count == Integer.bitCount(i)) // 조건2.
				return i;
		}
	}

}
