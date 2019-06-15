package P_Study;

import java.util.ArrayList;
import java.util.Collections;

public class P_Sort_H_Index {

	public static void main(String[] args) {
//		int[] arr = { 3, 0, 6, 1, 5 };  //6,5,3,1,0
//		int[] arr = { 10, 8, 5, 4 , 5};
//		int[] arr = {2, 0};
		int[] arr = {10, 50, 100}; //100,50,10
//		int[] arr={0, 0};
//		int[] arr={0};
//		int[] arr = { 25, 8, 5, 3, 3};
		System.out.println(solution(arr));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		ArrayList<Integer> list= new ArrayList<>();
		for(int a: citations)
			list.add(a);
		
		Collections.sort(list);
		Collections.reverse(list);
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<=i) {
				answer=i;
				return answer;
			}	
		}
		answer=list.size();	//list안에서 못찾을때 사이즈 반환
		
		return answer;
	}
}
