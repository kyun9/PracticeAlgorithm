package P_Study;

import java.util.ArrayList;
import java.util.LinkedList;

public class P_BFS_Network {
	public static void main(String[] args) {
		int n=4;
	//	int[][] computer= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
	//	int[][] computer= {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
	//	int[][] computer= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int[][] computer= {{1, 1, 1,1}, {1, 1, 1,1}, {1, 1, 1,1}};
		solution(n,computer);
	}
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); 
        
        int size=0;
        for(int i=0;i<n;i++) {
        	for(int j=i+1;j<n;j++) {
        		if(computers[i][j]==1) {
        			list.add( new ArrayList<>() );
        			list.get(size).add(i);
        			list.get(size).add(j);
        			size++;
        		}
        	}
        }
        
        
        if(list.isEmpty()) {
        	answer=n;
        }
        else if(list.size()==1) {
        	answer=n-1;
        }
        else {
        	LinkedList<Integer> qu = new LinkedList<>();
        	int num=-1;
        	int first=-1;
        	int last=-1;
        	while(num++<list.size()) {
        		if(first==list.get(num).get(0)) {
        			continue;
        		}
        		else {
        			first=list.get(num).get(0);
        			last=list.get(num).get(1);
        			qu.add(first);
        			qu.add(last);
        			
//        			for(int i=0;i<list.size();i++) {
//        				if(last==list.get(i).get(0)) {
//        					last=list.get(i).get(1);
//        					qu.add(last);
//        				}
//        			}                                --->이부분 dfs로 들어가야겠다
        			System.out.println(qu);
        			if(qu.size()==n) {
            			answer=1;
            			break;
            		}
        			else {
        				answer++;
        				qu.clear();
        			}
        		}
        	}
        }
        
        
        
        
        for (int i = 0 ; i < list.size() ; i++) { 
            for (int j = 0 ; j < list.get(i).size() ; j++) { 
              System.out.print(list.get(i).get(j) + " "); 
           } 
           System.out.println(); 
        } 
        System.out.println("----------------");
        
        System.out.println(answer);
        return answer;
    }
	
	

}
