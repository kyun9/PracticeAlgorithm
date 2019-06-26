package P_Study;

import java.util.ArrayList;
import java.util.List;

public class P_DFS_WordConversion {

	public static void main(String[] args) {
		String begin= "hit";
		String target = "cog";
		String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin,target,words));
	}
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		 
        List<String> list = new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            list.add(words[i]);
        }
        
        answer = dfs(begin,target,list,0);
        return answer;
    }
	
	public static int dfs(String begin, String target, List<String> list,int dept){
		char[] beginArr = begin.toCharArray();
		char[] targetArr = target.toCharArray();
		for(int i=0;i<list.size();i++) {
			int cnt=0;
			int tcnt = 0;
			char[] wordArr=list.get(i).toCharArray();
			for(int j=0;j<wordArr.length;j++) {
				if(beginArr[j]!=wordArr[j]) {
					cnt++;
				}
				if(beginArr[j]!=targetArr[j]){
					tcnt++;
                }
			}
			if(tcnt==1){
				dept++;
                return dept;
            }
			if(cnt==1) {
				begin = list.get(i);
				dept++;
                list.remove(i);
				return dfs(begin,target,list,dept);
			}
		}
		return 0;
	}
}