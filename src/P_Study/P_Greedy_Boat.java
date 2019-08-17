package P_Study;

import java.util.Arrays;

public class P_Greedy_Boat {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{70, 50, 80, 50},100));
	}
	public static int solution(int[] people, int limit) {
	       Arrays.sort(people);    //정렬
	       
	        int answer = 0;
	        int index = people.length - 1;
	        for(int i = 0; i <= index; i++, answer++) 
	            while(index > i && people[i] + people[index--] > limit)   // 양 옆으로 증가,감소
	                answer++;											//크면 양쪽으로 따로 옮겨야하니까 두번 증가
	 
	        return answer;
	    }
}
