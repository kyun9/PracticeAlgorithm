package Review;


public class P_DFS_WordConversion {
	static boolean[] check;
	static int find;
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer=0;
		for(int i=0;i<words.length;i++) {
			if(target.equals(words[i])) {
				check=new boolean[words.length];
				dfs(begin,target,words);
			}
		}
		answer=find;
		return answer;
	}

	static void dfs(String begin, String target, String[] words) {
		for(int i=0;i<words.length;i++) {
			if(check[i]) continue;
			
			int tcnt=0;
			int cnt=0;
			for(int j=0;j<begin.length();j++) {
				if(begin.charAt(j)!=target.charAt(j)) {
					tcnt++;
				}
				if(begin.charAt(j)!=words[i].charAt(j)) {
					cnt++;
				}
			}
			if(tcnt==1) {
				find++;
				return;
			}
			if(cnt==1) {
				check[i]=true;
				find++;
				dfs(words[i],target,words);
				return;
			}
		}
	}
}