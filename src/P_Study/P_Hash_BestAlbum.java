package P_Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class P_Hash_BestAlbum {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"classic", "pop", "classic", "classic", "pop"},new int[] {500, 600, 150, 800, 2500}));
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=0;i<genres.length;i++) {
			if(!map.containsKey(genres[i])) 
				map.put(genres[i], plays[i]);
			else
				map.put(genres[i], map.get(genres[i])+plays[i]);
		}
		
		
		return answer;
	}
}
class aaa{
	String genre;
	int play;
	
	aaa(String genre,int play){
		this.genre=genre;
		this.play=play;
	}
}
