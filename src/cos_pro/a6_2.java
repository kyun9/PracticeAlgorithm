package cos_pro;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class a6_2 {
	public static int solution(int K, String[] words) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;

		int[] arr = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			arr[i] = words[i].length();
		}

		int hap = 0;
		int n = -1;
		while (n++ < arr.length - 1) {
			if (hap != 0) {
				hap += 1;
			}
			hap += arr[n];
			if (hap > K) {
				answer++;
				hap = 0;
				n -= 1;
			}
		}

		if (hap != 0) {
			answer++;
		}

		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int K = 10;
		String[] words = { new String("nice"), new String("happy"), new String("hello"), new String("world"),
				new String("hi") };
		int ret = solution(K, words);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
	}
}