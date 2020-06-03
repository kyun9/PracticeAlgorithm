package coding_2020;

import java.util.ArrayList;

public class s_summercoding2 {

	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(solution(11));
	}

	static public long solution(long n) {
		long answer = 0;

		ArrayList<Long> list = new ArrayList<>();
		
		int cnt=0, cnt1=0;
		for(int i=1;i<=n;i++) {
			if(Math.log(i)/Math.log(2)==cnt) {
				list.add((long) Math.pow(3, cnt));
				cnt++;
				cnt1=0;
			}
			else {
				list.add((long) Math.pow(3, cnt-1)+list.get(cnt1));
				cnt1++;
			}
		}
		
		answer = list.get(list.size()-1);
		return answer;
	}
}
