package P_Study;

import java.util.HashSet;

public class P_Hash_PhoneBookList {

	public static void main(String[] args) {
		//String[] phone_book = { "119", "97674223", "1195524421" };
		String[] phone_book = { "123","456","789" };
		//String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashSet<String> hash = new HashSet<>();

		for (String a : phone_book) {
			hash.add(a);
		}

		for (String hnum : hash) {
			for (String arr : phone_book) {
				if(hnum.startsWith(arr)&&!arr.equals(hnum)) {
					return false;
				}
			}
		}

		return answer;
	}
}
