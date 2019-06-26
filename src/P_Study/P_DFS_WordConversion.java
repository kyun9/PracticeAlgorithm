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
        
        boolean[] check=new boolean[words.length];
       dfs(begin,target,words,0,check);
        
       answer=dcnt;
        return answer;
    }
	
	public static void dfs(String begin, String target, String[] words,int dept,boolean[] check){
		int cnt=0;
		char[] beginArr = begin.toCharArray();
		for(int i=0;i<words.length;i++) {
			if(check[i]) continue;
			char[] wordsArr=words[i].toCharArray();
			for(int j=0;j<wordsArr.length;j++) {
				if(beginArr[j]!=wordsArr[j]) {
					cnt++;
				}
			}
																									System.out.println("dept : "+dept+ " i : "+i+" cnt : " +cnt + " dcnt : "+dcnt);
			check[i]=true;
			if(words[i]==target) {
				dcnt=dept+1;
				return;
			}
			else if(cnt==1) {
				dept++;
				dfs(String.valueOf(wordsArr),target,words,dept,check);
			}
			cnt=0;
		}
	}
}
