package review_2020_winter;

import java.util.ArrayList;

public class P_StackQueue_Print {

	public static void main(String[] args) {
		int[] priorities = new int[] { 2, 1, 3, 2 };
	      int location = 2;
//		int[] priorities = new int[] { 1, 1, 9, 1, 1, 1 };
//		int location = 0;
		System.out.println(solution(priorities, location));
	}

	static int solution(int[] priorities, int location) {
		int answer = 0;
		
		ArrayList<Print> list= new ArrayList<>();
		for(int i=0;i<priorities.length;i++) {
			list.add(new Print(i,priorities[i]));
		}
		
		int cnt=0;
		boolean check=false;
		while(!list.isEmpty()) {
			check=false;
			for(int i=0;i<list.size();i++) {
				if(list.get(0).prior<list.get(i).prior) {
					check=true;
				}
			}
			if(check) {
				Print print = list.remove(0);
				list.add(print);
			}
			else {
				Print print=list.remove(0);
				if(print.idx==location) {
					cnt++;
					break;
				}
				else {
					cnt++;
				}
			}
			
		}
		answer= cnt;
		return answer;
	}
}
class Print{
	int idx;
	int prior;
	
	Print(int idx, int prior){
		this.idx= idx;
		this.prior= prior;
	}
}