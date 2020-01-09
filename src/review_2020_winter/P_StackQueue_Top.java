package review_2020_winter;

public class P_StackQueue_Top {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {6,9,5,7,4}));
	}

	static int[] solution(int[] heights) {
		int[] answer = {};
		int size = heights.length;
		answer = new int[size];
		
		for(int i=size-1;i>=0;i--) {
			for(int j=i-1;j>=0;j--) {
				if(heights[i]<heights[j]) {
					answer[i]=j+1;
					break;
				}
			}
		}
		
		return answer;
	}

}
