package StudyAlgorithm_P;

public class p2018winter_coding1 {

	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		char[] temp;
		for (int i = 0; i < skill_trees.length; i++) {
			boolean flag = true;
			temp = skill_trees[i].toCharArray();
			int cnt = 0;
			for (int j = 0; j < temp.length; j++) {
				if (cnt < skill.indexOf(temp[j])) {
					flag = false;
					break;
				} else if (cnt == skill.indexOf(temp[j])) {
					cnt++;
				}
			}
			if (flag) {
				answer++;
			}
		}

		return answer;
	}
}
