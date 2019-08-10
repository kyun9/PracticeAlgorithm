package Review;

import java.util.HashMap;

public class Hash_camouflage {

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}
	public static int solution(String[][] clothes) {
		int answer = 0;
		int size = clothes.length;
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=0;i<size;i++) {
			if(!map.containsKey(clothes[i][1]))
				map.put(clothes[i][1], 1);
			else
				map.put(clothes[i][1], map.get(clothes[i][1])+1);
		}
		
		answer=1;
		for(int v : map.values()) {
			answer*=(v+1);
		}
		answer-=1;
		return answer;
	}
}
