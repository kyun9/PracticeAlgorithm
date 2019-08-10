package Review;

import java.util.HashSet;

public class Hash_PhoneBook {
	public static void main(String[] args) {
		//String[] phone_book = { "119", "97674223", "1195524421" };
		String[] phone_book = { "123","456","789" };
		//String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution(phone_book));
	}
	public static boolean solution(String[] phone_book) {
		boolean answer =true;
		HashSet<String> hash = new HashSet<>();
		
		for(String s : phone_book)
			hash.add(s);
		
		for(String h : hash) {
			for(String s : phone_book) {
				if(h.startsWith(s)&&!s.equals(h)) {
					return false;
				}
			}
		}
		
		
		return answer;
	}
}
