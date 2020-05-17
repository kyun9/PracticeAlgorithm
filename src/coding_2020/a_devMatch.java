package coding_2020;

public class a_devMatch {

	public static void main(String[] args) {
		String p = "00000000000000000000";
		String s = "91919191919191919191";
		
		System.out.println(solution(p,s));
		
	}
	static public int solution(String p, String s) {
		int answer = 13;
		answer =0;
		
		char[] parr = p.toCharArray();
		char[] sarr = s.toCharArray();
		
		for(int i=0;i<parr.length;i++) {
			if(parr[i]==sarr[i]) {
				answer +=0;
			}
			else {
				int up = parr[i]-'0';
				int low = parr[i]-'0';
				int ucnt =0;
				int lcnt=0;
				while(up!=sarr[i]-'0') {
					up++;
					if(up==10) {
						up=0;
					}
					ucnt++;
				}
				while(low!=sarr[i]-'0') {
					low--;
					if(low==-1) {
						low=9;
					}
					lcnt++;
				}
				answer += Math.min(ucnt, lcnt);
			}
		}
		return answer;
	}
}
