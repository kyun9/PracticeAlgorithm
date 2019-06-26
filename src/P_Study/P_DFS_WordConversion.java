package P_Study;

public class P_DFS_WordConversion {

	static int dcnt;
	public static void main(String[] args) {
		String begin= "hit";
		String target = "cog";
		String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin,target,words));
	}
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        
       dfs(begin,target,words,0,0);
        
       answer=dcnt;
        return answer;
    }
	
	public static void dfs(String begin, String target, String[] words,int start,int dept){
		char[] beginArr = begin.toCharArray();
		
		for(int i=start;i<words.length;i++) {
			int cnt=0;
			char[] wordArr=words[i].toCharArray();
			for(int j=0;j<wordArr.length;j++) {
				if(beginArr[j]!=wordArr[j]) {
					cnt++;
				}
			}
			System.out.println("dept : "+dept+ " i : "+i+" cnt : " +cnt + " dcnt : "+dcnt);
			if(begin.equals(target)) {
				dcnt=dept+1;
				return;
			}
			else if(cnt==1) {
				start++;
				dept++;
				dfs(String.valueOf(wordArr),target,words,start,dept);
			}
		}
	}
}