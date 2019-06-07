package P_Study;

import java.util.Arrays;
import java.util.Comparator;

public class P_Sort_TheGreatestNumber {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {6, 10, 2}));
	}
	 public static String solution(int[] numbers) {
	        String answer = "";
	        int size = numbers.length;
	        String[] tmp = new String[size];
	        
	        for(int i=0;i<size;i++) {
	        	tmp[i]=String.valueOf(numbers[i]);
	        }
	        
	        Arrays.sort(tmp, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return (o2+o1).compareTo(o1+o2);
				}
	        	
	        });
	        
	        if(tmp[0].equals("0"))
	        	answer = "0";
	        else {
	        	for(String a : tmp)
	        		answer += a;	        
	        }
	        
	        
	        return answer;
	    }
}
