package B_theSecondHalfOfTheYear;

import java.util.HashSet;

public class 프로그래머스_폰켓몬 {

	public static void main(String[] args) {
//		int[] nums = { 3, 1, 2, 3 };
		int[] nums = { 3, 3, 3, 2, 2, 4 };
		System.out.println(solution(nums));
	}

	static int solution(int[] nums) {
		int answer = 0;

		HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}

		if (set.size() <= nums.length / 2) {
			answer = set.size();
		} else {
			answer = nums.length / 2;
		}

		return answer;
	}

}
