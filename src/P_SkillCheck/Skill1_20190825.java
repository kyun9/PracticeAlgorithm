package P_SkillCheck;

public class Skill1_20190825 {

	public static void main(String[] args) {
//		System.out.println(solution1("Pyy"));
		System.out.println(solution2(5,24));
	}

	static boolean solution1(String s) {
		boolean answer = true;
		char[] c = s.toCharArray();
		int p = 0;
		int y = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'p' || c[i] == 'P') {
				p += 1;
			} else if (c[i] == 'y' || c[i] == 'Y') {
				y += 1;
			}
		}
		if (p != y) {
			answer = false;
		}
		return answer;
	}

	static String solution2(int a, int b) {
	      String answer = "";
	      String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	      int[] month= {31,29,31,30,31,30,31,31,30,31,30,31};
	      int day=0;
	      if(a==1) day=b;
	      else {
	    	  for(int i=0;i<a-1;i++) {
	    		  day+=month[i];
	    	  }
	    	  day+=b;
	      }
	      answer = week[(day+4)%7];
	      return answer;
	  }
}
//solution1
//대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
//다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 
//개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

//solution2
//대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 
//다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 
//	단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.