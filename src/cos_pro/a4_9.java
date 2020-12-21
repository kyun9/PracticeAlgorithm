package cos_pro;

public class a4_9 {
	public static String solution(int hour, int minute) {
		// 여기에 코드를 작성해주세요.
		String answer = "";

		double val = Math.abs((minute / 5) - hour) * 30;
		double val2 = 30 * (double)minute / 60;
		double val3 = 30 * (double)minute % 5;
		
		
		System.out.println(val);
		System.out.println(val2);
		System.out.println(val3);
		System.out.println(val - val2 + val3);
		
		answer = String.format("%.1f", val-val2+val3);
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int hour = 3;
		int minute = 30;
		String ret = solution(hour, minute);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}

}
