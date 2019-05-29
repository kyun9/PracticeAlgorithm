package P_Study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class P_Hash_Marathon {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));
	}


	public static String solution(String[] participant, String[] completion) {
	      String answer = "";
	      HashMap<Integer, String> hm = new HashMap<>();

	      for (int i = 0; i < participant.length; i++) {
	         hm.put(i, participant[i]);
	      }

	      
	      Set<Integer> keyset = hm.keySet();
	      for (int i = 0; i < completion.length; i++) {
	         for ( int key :keyset ) {
	            if (hm.get(key) == completion[i]) {
	               hm.remove(key);
	               break;
	            }
	         }
	      }
	      for(int key : keyset) {
	         answer = hm.get(key);
	      }
	         

	      return answer;
	   }

	public static String solution1(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}

	public static String solution2(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		int i;
		for (i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[i];
	}
	public static String solution3(String[] participant, String[] completion) {
		String answer = "";
		String player;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i<participant.length;i++) {
			player = participant[i];
			if(!map.containsKey(player))
				map.put(player, 1);
			else 
				map.put(player, map.get(player)+1);
		}
		
		for(int i =0; i<completion.length;i++) {
			player = completion[i];
			if(map.get(player)==1)
				map.remove(player);
			else
				map.put(player, map.get(player)-1);	
		}
		Iterator<String> it = map.keySet().iterator();
		answer = it.next();
		return answer;
	}
}