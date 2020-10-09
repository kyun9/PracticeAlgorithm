package B_theSecondHalfOfTheYear;

public class 프로그래머스_피보나치수 {

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	static int solution(int n) {
		int answer = 0;

		int[] arr = new int[100001];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i < arr.length; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
		}

		answer = arr[n];
		return answer;
	}
}
