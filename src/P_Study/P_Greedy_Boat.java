package P_Study;

public class P_Greedy_Boat {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{70, 50, 80, 50},100));
	}
	public static int solution(int[] people, int limit) {
	       Arrays.sort(people);
 
        int answer = 0;
        int index = people.length - 1;
        for(int i = 0; i <= index; i++, answer++) 
            while(index > i && people[i] + people[index--] > limit) 
                answer++;
 
        return answer;
	    }
}
