package P_Study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P_Hash_Camouflage {

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		System.out.println(solution(clothes));

	}

	public static int solution(String[][] clothes) {
		int answer = 0;
		int size = clothes.length;
		List<Integer> list = new ArrayList<>();
		HashMap<String, Integer> hash = new HashMap<>();
		for (int i = 0; i < size; i++) {
			if (!hash.containsKey(clothes[i][1]))
				hash.put(clothes[i][1], 1);
			else {
				hash.put(clothes[i][1], hash.get(clothes[i][1]) + 1);
			}
		}
		
		
		answer =1;
		for(int a:hash.values()) {
			answer*=(a+1);
		}
		answer -=1;

		return answer;
	}
}
