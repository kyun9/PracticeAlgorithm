package Review;

public class PTargetNumber {

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		System.out.println(solution(numbers, target));
	}
	static int count=0;
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		dfs(numbers,target,0);
		answer = count;
		return answer;
	}
	static void dfs(int[] numbers,int target, int depth) {
		if(depth == numbers.length) {
			int sum =0;
			for(int i=0;i<numbers.length;i++) {
				sum+= numbers[i];
			}
			if(sum==target) {
				count++;
			}
		}
		else {
			numbers[depth]*=1;
			dfs(numbers,target,depth+1);
			numbers[depth]*=-1;
			dfs(numbers,target,depth+1);
		}
		
	}
	
}
