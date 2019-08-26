package Review;

public class P_DFS_TargetNumber {
	static int count;
	public static void main(String[] args) {
		int[] numbers= {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers,target));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		dfs(numbers,target,0);
		
		answer=count;
		return answer;
	}
	
	static void dfs(int[] numbers, int target, int depth) {
		if(depth==numbers.length) {
			int sum=0;
			for(int i:numbers) {
				sum+=i;
			}
			if(sum==target) count++;
			return;
		}
		numbers[depth]*=1;
		dfs(numbers,target,depth+1);
		numbers[depth]*=-1;
		dfs(numbers,target,depth+1);
	}
}
