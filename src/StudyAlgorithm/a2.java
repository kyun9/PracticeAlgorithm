package StudyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class a2 {
	static int tmpNum;

	public static void main(String[] args) {
		System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
//		System.out.println(solution("{{20,111},{111}}"));
	}

	public static int[] solution(String s) {
		int[] answer = {};

		HashMap<Integer, Integer> map = new HashMap<>();
		String subS = s.substring(1, s.length() - 1);
		String[] splitS = subS.split("}");

		int size = splitS.length;
		int[] arr = new int[size];
		for (int i = 0; i < splitS.length; i++) {
			if (i == 0) {
				splitS[i] = splitS[i].substring(1, splitS[i].length());
			} else {
				splitS[i] = splitS[i].substring(2, splitS[i].length());
			}
			String[] splitResult = splitS[i].split(",");

			for (int j = 0; j < splitResult.length; j++) {
				if (map.containsKey(Integer.valueOf(splitResult[j]))) {
					map.put(Integer.valueOf(splitResult[j]), map.get(Integer.valueOf(splitResult[j])) + 1);
				} else {
					map.put(Integer.valueOf(splitResult[j]), 1);
				}
			}
		}
		
		answer= new int[size];
		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
		int i=0;
        for(int key : keySetList) {
            answer[i]= key;
            i++;
        }

		return answer;
	}
}
