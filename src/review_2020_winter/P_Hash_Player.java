package review_2020_winter;

import java.util.HashMap;
import java.util.Iterator;

public class P_Hash_Player {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"}));
	}
	static String solution(String[] participant, String[] completion) {
      	String answer = "";
      	
      	HashMap<String, Integer> map = new HashMap<>();
      	
      	for(int i=0;i<participant.length;i++) {
      		if(map.containsKey(participant[i])) {
      			map.put(participant[i],map.get(participant[i])+1);
      		}
      		else {
      			map.put(participant[i], 1);
      		}
      	}
      	
      	for(int i=0;i<completion.length;i++) {
      		if(map.containsKey(completion[i])) {
      			if(map.get(completion[i])==1) {
      				map.remove(completion[i]);
      			}
      			else {
      				map.put(completion[i],map.get(completion[i])-1);
      			}
      		}
      	}
      	
      	for(String s : map.keySet()) {
      		answer = s;
      	}
    	return answer;
    }
}
