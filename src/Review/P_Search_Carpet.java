package Review;

import java.util.ArrayList;

public class P_Search_Carpet {

	public static void main(String[] args) {
		solution(10, 2);
		solution(8, 1);
		solution(24, 24);
	}

	public static int[] solution(int brown, int red) {
		int[] answer = {};

		ArrayList<Integer> list = new ArrayList<>();
		int tmp = (int)Math.sqrt(red);
		int n=1;
		while(n<=tmp) {
			if(red%n==0) {
				list.add(n);
			}
			n++;
		}
		
		
		int h=0, w=0;
		for(int i=0;i<list.size();i++) {
			h = list.get(i);
			w = red/list.get(i);
			
			if((h+2)*(w+2)-red==brown) {
				break;
			}
		}
		
		answer = new int[2];
		answer[0]=w+2;
		answer[1]=h+2;
		
		System.out.println(answer[0]+" "+ answer[1]);
		
		return answer;
	}

}
