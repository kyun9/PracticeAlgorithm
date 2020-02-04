package review_2020_winter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class P_Hash_BestAlbum {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"classic", "pop", "classic", "classic", "pop"},new int[] {800, 600, 150, 800, 2500}));
	}

	static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<genres.length;i++) {
			if(map.containsKey(genres[i])) {
				map.put(genres[i], map.get(genres[i])+plays[i]);
			}
			else {
				map.put(genres[i],plays[i]);
			}
			
		}
		ArrayList<Music> list = new ArrayList<>();
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String s = it.next();
			list.add(new Music(s,map.get(s)));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Music2>[] pq = new PriorityQueue[list.size()];
		for(int i=0;i<pq.length;i++) {
			pq[i]= new PriorityQueue<>();
		}
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<genres.length;j++) {
				if(list.get(i).genre.equals(genres[j])) {
					pq[i].add(new Music2(j,plays[j]));
				}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<pq.length;i++) {
			int cnt=0;
			System.out.println(i);
			while(!pq[i].isEmpty()) {
				if(cnt==2) {
					break;
				}
				Music2 m = pq[i].poll();
				System.out.println(m.idx+" "+m.play);
				result.add(m.idx);
				cnt++;
			}
		}
		
		answer = new int[result.size()];
		for(int i=0;i<result.size();i++) {
			answer[i]=result.get(i);
		}
		return answer;
	}
}
class Music implements Comparable<Music>{
	String genre;
	int play;
	Music(String genre, int play){
		this.genre=genre;
		this.play=play;
	}
	@Override
	public int compareTo(Music o) {
		if(o.play>this.play) {
			return 1;
		}else {
			return -1;
		}
	}
}
class Music2 implements Comparable<Music2>{
	int idx;
	int play;
	Music2(int idx, int play){
		this.idx=idx;
		this.play=play;
	}
	@Override
	public int compareTo(Music2 o) {
		if(o.play>this.play) {
			return 1;
		}
		else {
			if(o.play==this.play) {
				if(o.idx<this.idx) {
					return 1;
				}
			}
			return -1;
		}
	}
}