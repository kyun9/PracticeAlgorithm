package StudyAlgorithm;

public class GroupSequence {

	public static void main(String[] args) {
		solution(4);
	}
	
	
	public static long solution(long k) {
		long i=1;
		long j=0;
		long result=0, tmp =0;
		
		while(true) {
			i=i+j;
			if(i==k) {
				result = 1;
				break;
			}
			else if(i>k) {
				tmp= i-k;
				result = j+1-tmp;
				break;
			}
			j++;
			
		}
		System.out.println(result);
		return result;
	}
	
}
//-----------------------------------------------------------------------------------------------------
//문제 3(100점)
//-----------------------------------------------------------------------------------------------------
//문제 설명
//수열을 어떤 규칙에 의해 여러 가지 항으로 나누었을 때, 각각의 항으로 이루어진 수열을 군수열이라고 합니다.
//
//무한수열 S = (1), (1, 2), (1, 2, 3), (1, 2, 3, 4).... 입니다. 이 수열의 규칙은 다음과 같습니다.
//
//N 번째 군에는 1부터 N까지의 자연수가 크기 순서대로 있습니다.
//수열의 k 번째 항은, 군에 상관없이 맨 앞부터 세기 시작합니다. 즉, 수열 S의 4번째 항은 1이 됩니다.
//수 k가 주어질 때, 수열 S에서 k 번째 항의 수를 반환하는 solution 함수를 완성하세요.
//
//제한사항
//k는 50,000,000,000,000 이하의 자연수입니다.
