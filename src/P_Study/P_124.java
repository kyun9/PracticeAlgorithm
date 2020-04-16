package P_Study;

public class P_124 {

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

	static public String solution(int n) {
		String answer = "";
		
		int result=0;
		while(n>0) {
			result= n%3;
			n /=3;
			if(result==0) {
				result =4;
				n-=1;
			}
			answer=result+answer;
		}
		return answer;
	}
}
