package review_2020_winter;

public class P_SkillTree {

	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}

	public static int solution(String skill, String[] skill_trees) {
			int answer = 0;

			
			char[] tmp;
			for(int i=0;i<skill_trees.length;i++) {
				tmp = skill_trees[i].toCharArray();
				int cnt=0;
				boolean flag = true;
				for(int j=0;j<tmp.length;j++) {
					if(cnt<skill.indexOf(tmp[j])) {
						flag= false;
						break;
					}
					else if(cnt==skill.indexOf(tmp[j])) {
						cnt++;
					}
				}
				
				if(flag) {
					answer++;
				}
			}
			
			
			
			return answer;
		}
}
