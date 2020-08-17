package B_theSecondHalfOfTheYear;

public class 프로그래머스_문자열압축 {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}

	static int solution(String s) {
		int answer = Integer.MAX_VALUE;

		for (int len = 1; len < s.length(); len++) {
			String compressed = "";			//압축한 문자열 저장하는 문자열변수
			String target = "";				// 단위 크기로 문자열변수
			String current = "";			// 단위로 나눈 크기만큼 비교하는 임시문자열변수
			int cnt = 1;

			for (int i = 0; i < len; i++) {		// 단위 크기로 저장
				target += s.charAt(i);
			}

			for (int i = len; i < s.length(); i += len) {		// 단위 크기만큼 반복목  i+=len
				current = "";
				for (int j = i; j < i + len; j++) {				// 단위로 나눈 문자열 current 저장
					if (j >= s.length())
						break;
					current += s.charAt(j);
				}

				if (target.equals(current)) {					//비교
					cnt++;
				} else {
					if (cnt > 1) {
						compressed += cnt + target;				//압축 저장
					} else {
						compressed += target;
					}
					cnt = 1;
					target = current;
				}
			}

			if (cnt > 1) {
				compressed += cnt + target;
			} else {
				compressed += target;
			}

			int length = compressed.length(); 				//압축저장후 길이 추출
			answer = Math.min(answer, length); 				// 압축 길이 가장 작은것으로 초기화
		}
		
		if(answer == Integer.MAX_VALUE ) answer =1;

		return answer;
	}
}
