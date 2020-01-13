package review_2020_winter;

public class B_StackQueue_StockPrice {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 2, 3 }));
	}

	static int[] solution(int[] prices) {
		int[] answer = {};
		
		answer = new int[prices.length];
		int cnt;
		for(int i=0;i<prices.length;i++) {
			cnt=0;
			for(int j=i+1;j<prices.length;j++) {
				if(prices[i]<=prices[j]) {
					cnt++;
				}
				else {
					cnt++;
					break;
				}
			}
			answer[i]=cnt;
		}
		
		for(int i : answer) {
			System.out.println(i);
		}
		return answer;
	}
}
