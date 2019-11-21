package StudyAlgorithm;

public class p2018winter_coding3 {
	static int cnt;

	public static void main(String[] args) {
//		System.out.println(solution(new int[] { 1, 2, 3, 4 }));
		System.out.println(solution(new int[] { 1, 2, 7,6, 4 }));
	}

	public static int solution(int[] nums) {
		int answer = -1;
		int[] result = new int[3];
		perm(nums, 3, 0, result);
		
		answer=cnt/6;
		return answer;
	}

	static void perm(int[] nums, int r, int depth, int[] result) {
		if (depth == r) {
			int sum = 0;
			for (int i : result) {
				sum += i;
			}
			int num = 2;
			while (true) {
				if (sum % num == 0) {
					if (sum == num) {
						cnt++;
					}
					break;
				} else {
					num++;
				}
			}
			return;
		}
		
		for (int i = depth; i < nums.length; i++) {
			swap(nums, i, depth);
			result[depth] = nums[depth];
			perm(nums, r, depth + 1, result);
			swap(nums, i, depth);
		}

	}

	static void swap(int[] nums, int i, int depth) {
		int temp = nums[i];
		nums[i] = nums[depth];
		nums[depth] = temp;
	}
}
