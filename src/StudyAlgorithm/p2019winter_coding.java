package StudyAlgorithm;

import java.util.ArrayList;

public class p2019winter_coding {
	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	public static int[] solution(int n) {
		int[] answer = {};

		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i = 2; i <= n; i++) {
			list.add(0);
			int a =list.size();
			for(int j=a -2;j>=0;j--) {
				if(list.get(j)==1) {
					list.add(0);
				}
				else if(list.get(j)==0){
					list.add(1);
				}
			}
			
		}
		System.out.println(list);
		
		int size = list.size();
		answer= new int[size];
		for(int i =0 ; i<size;i++) {
			answer[i]=list.get(i);
		}
		
		
		return answer;
	}
}
