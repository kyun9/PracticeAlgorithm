package P_Study;

import java.util.ArrayList;

public class P_CSearch_Carpet {

	public static void main(String[] args) {
		solution(10,2);
		solution(8,1);
		solution(24,24);
	}
	public static int[] solution(int brown, int red) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        int tmp = (int)(Math.sqrt(red));
        int n=1;
        while(n <= tmp) {
        	if(red%n==0) {
        		list.add(red/n);
        	}
        	n++;
        }
        
        int width=0, height=0;
        answer=new int[2];
        for(int i=0;i<list.size();i++) {
        	width = list.get(i);
        	height = red/width;
        	
        	if(brown==(((width+2)*(height+2))-red)) {
        		break;
        	}
        }
        
        answer[0]=width+2;
        answer[1]=height+2;
        
        return answer;
    }
}
