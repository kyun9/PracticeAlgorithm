package StudyAlgorithm_P;


public class p2019winter_coding1 {
	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}

	public static long solution(int w,int h) {
		long answer = 1;
		
		long result =0;
		double a = (double)w/h;
		for(long i=1;i<h;i++) {
			result += Math.floor(a*i);
		}
		
		answer =result*2;
		return answer;
	}
}
