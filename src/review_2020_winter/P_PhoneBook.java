package review_2020_winter;

import java.util.HashSet;

public class P_PhoneBook {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
		System.out.println(solution(new String[] {"123","456","789"}));
	}

	static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashSet<String> hs = new HashSet<>();
		
		for(String s : phone_book) {
			hs.add(s);
		}
		
		for(String s : phone_book) {
			for(String st : phone_book) {
				if(s.length()<st.length()&&st.substring(0, s.length()).equals(s)) {
					answer =false;
					return answer;
				}
			}
		}
		
		return answer;
	}
}
