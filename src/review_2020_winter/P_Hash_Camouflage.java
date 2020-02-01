package review_2020_winter;

import java.util.HashMap;

public class P_Hash_Camouflage {

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}

	static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();
    	for(int i=0;i<clothes.length;i++) {
    		if(!map.containsKey(clothes[i][1])) {
    			map.put(clothes[i][1], 1);
    		}
    		else {
    			map.put(clothes[i][1], map.get(clothes[i][1])+1);
    		}
    	}
    	
    	answer =1;
    	for(int a : map.values()) {
    		answer *=(a+1);
    	}
		answer -= 1;
		return answer;
	}
}
