package B_theSecondHalfOfTheYear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 프로그래머스_최댓값과최솟값 {

	public static void main(String[] args) {
//		String s = "1 2 3 4";
		String s = "-1 -2 -3 -4";
//		String s = "-1 -1";
		System.out.println(solution(s));
	}

	static String solution(String s) {
		String answer = "";
		
		StringTokenizer st = new StringTokenizer(s);
		ArrayList<Integer> list = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		answer += list.get(0)+" ";
		answer += list.get(list.size()-1);
		
		return answer;
	}
}
