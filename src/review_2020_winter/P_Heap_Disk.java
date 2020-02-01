package review_2020_winter;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class P_Heap_Disk {

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println(solution(jobs));
	}

	static int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<Disk> q = new PriorityQueue<>();
		for (int i = 0; i < jobs.length; i++) {
			q.add(new Disk(jobs[i][0], jobs[i][1]));
		}
		
		ArrayList<Disk> list = new ArrayList<>();
		for(int i=0;i<jobs.length;i++) {
			Disk d = q.poll();
			list.add(d);
		}
		
		int time=0;
		int sum=0;
		while(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				if(time>=list.get(i).start) {
					time+=list.get(i).time;
					sum+=time-list.get(i).start;
					list.remove(i);
					break;
				}
				if(i==list.size()-1) {
					time++;
				}
			}
		}
		
		answer = sum/jobs.length;
		return answer;
	}
}

class Disk implements Comparable<Disk> {
	int start;
	int time;

	Disk(int start, int time) {
		this.start = start;
		this.time = time;
	}

	@Override
	public int compareTo(Disk o) {
		if (this.time < o.time)
			return -1;
		else if (this.time == o.time) {
			if (this.start < o.start)
				return -1;
			else
				return 1;
		} else
			return 1;
	}
}