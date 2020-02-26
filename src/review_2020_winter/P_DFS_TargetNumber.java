package review_2020_winter;

public class P_DFS_TargetNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,1,1,1,1},3));
	}

	static int result;
	static int solution(int[] numbers, int target) {
		int answer = 0;
		
		int[] output=new int[numbers.length];
		result =0;
		dfs(numbers,output, 0, target);
		answer = result;
		return answer;
	}
	static void dfs(int[] numbers, int[] output, int depth, int target) {
		if(depth==numbers.length) {
			int sum=0;
			for(int i : output) {
				sum +=i;
			}
			if(sum == target) {
				result++;
			}
			return ;
		}
		output[depth]= numbers[depth];
		dfs(numbers,output, depth+1,target);
		output[depth]=-1*numbers[depth];
		dfs(numbers,output, depth+1,target);
	}
}
