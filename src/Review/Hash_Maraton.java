package Review;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Hash_Maraton {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String,Integer> map = new HashMap<>();
		
		for(String s : participant) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}
			else
				map.put(s, 1);
		}
		
		for(String s : completion) {
			if(map.get(s)==1) {
				map.remove(s);
			}
			else {
				map.put(s, map.get(s)-1);	
			}
		}
		Iterator<String> it = map.keySet().iterator();
		answer = it.next();
		return answer;
	}
}
