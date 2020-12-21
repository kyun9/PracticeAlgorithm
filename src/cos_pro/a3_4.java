package cos_pro;

public class a3_4 {

	public static int solution(String s1, String s2) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;

		for (int i = 0; i < s1.length(); i++) {
			String temp = s1.substring(i, s1.length());

			if (temp.length() <= s2.length()) {
				if (s2.contains(temp)) {
					boolean flag = true;
					for (int j = 0; j < temp.length(); j++) {
						if (temp.charAt(j) == s2.charAt(j)) {
							continue;
						} else {
							flag = false;
							break;
						}
					}
					if (flag) {
						answer += s1.length() + (s2.length() - temp.length());
						break;
					} else {
						continue;
					}
				} else {
					continue;
				}
			} else {
				continue;
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			String temp = s2.substring(i, s2.length());

			if (temp.length() <= s1.length()) {
				if (s1.contains(temp)) {
					boolean flag = true;
					for (int j = 0; j < temp.length(); j++) {
						if (temp.charAt(j) == s1.charAt(j)) {
							continue;
						} else {
							flag = false;
							break;
						}
					}
					if (flag) {
						answer = Math.min(answer, s2.length() + (s1.length() - temp.length()));
						break;
					} else {
						continue;
					}
				} else {
					continue;
				}
			} else {
				continue;
			}
		}

		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String s1 = new String("ababc");
		String s2 = new String("abcdab");
		int ret = solution(s1, s2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");

		s1 = new String("abcdab");
		s2 = new String("ababc");
		ret = solution(s1, s2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");

	}
}
