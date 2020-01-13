package review_2020_winter;

public class P_DFSBFS_TargetNumber {
	static int[] nums;
	static int cnt;
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1,1, 1, 1, 1 }, 3));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		nums = new int[numbers.length];
		dfs(0, numbers, target);

		answer =cnt;
		return answer;
	}

	static void dfs(int depth, int[] numbers, int target) {
		if (depth == numbers.length) {
			int sum =0;
			for(int i : nums) {
				sum+=i;
			}
			if(sum==target) {
				cnt+=1;
			}
			return;
		}
		nums[depth] = numbers[depth];
		dfs(depth + 1, numbers, target);
		nums[depth] = -1*numbers[depth];
		dfs(depth + 1, numbers, target);
	}
}
