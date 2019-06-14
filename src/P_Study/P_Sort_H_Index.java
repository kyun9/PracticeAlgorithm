package P_Study;

import java.util.ArrayList;
import java.util.Collections;

public class P_Sort_H_Index {

	public static void main(String[] args) {
		//int[] arr = { 3, 0, 6, 1, 5 };
//		int[] arr = { 10, 8, 5, 4 , 3 };
//		int[] arr = {2, 0};
		int[] arr={0, 0};
		//int[] arr = { 25, 8, 5, 3, 3};
		System.out.println(solution(arr));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		int size=0;
		ArrayList<Integer> list= new ArrayList<>();
		for(int a: citations)
			list.add(a);
		
		Collections.sort(list);
		Collections.reverse(list);
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<=size) {
				answer=size;
				break;
			}
			size++;
		}
		
		return answer;
	}
}
