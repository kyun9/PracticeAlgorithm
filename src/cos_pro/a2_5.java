package cos_pro;

public class a2_5 {
	public static int solution(int[] arr) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;

		int n = 0;

		while (n < arr.length) {
			int val = arr[n];
			int result = 1;

			for (int i = n + 1; i < arr.length; i++) {
				if (val < arr[i]) {
					result += 1;
					val = arr[i];
				} else {
					break;
				}
			}

			answer = Math.max(result, answer);
			n++;
		}

		return answer;
	}

	public static int solution2(int[] arr) {
		int dp[] = new int[arr.length];
		for (int i = 0; i < dp.length; ++i) {
			dp[i] = 1;
		}
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] > arr[i - 1])
				dp[i] = dp[i - 1] + 1;
		}
		int answer = 0;

		for (int i = 0; i < arr.length; ++i) {
			answer = Math.max(answer, dp[i]);
			System.out.print(dp[i]+"\t");
		}
		System.out.println();
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4, 5, 1, 2, 2, 3, 4 };
		int ret = solution2(arr);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}
}
