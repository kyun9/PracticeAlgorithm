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
	static int find=0;
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		 
        List<String> list = new ArrayList<String>();
        
        for(String s: words)
            list.add(s);
        
        if(list.contains(target))
        	dfs(begin,target,list,0);
        
       answer=find; 
       
        return answer;
    }
	
	public static void dfs(String begin, String target, List<String> list,int depth){
		char[] beginArr = begin.toCharArray();
		char[] targetArr = target.toCharArray();
		
		
		for(int i=0;i<list.size();i++) {
			int cnt=0;
			int tcnt = 0;
			char[] wordArr=list.get(i).toCharArray();
			for(int j=0;j<wordArr.length;j++) {
				if(beginArr[j]!=targetArr[j]){
					tcnt++;
				}
				if(beginArr[j]!=wordArr[j]) {
					cnt++;
				}
			}
	
			if(tcnt==1){
				find = depth+1;
                return;
            }
			else if(cnt==1) {
				beginArr = wordArr;
				depth++;
                list.remove(i);
				dfs(String.valueOf(beginArr),target,list,depth);
				return;
			}
		}
	}
}