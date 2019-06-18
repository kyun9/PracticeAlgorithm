package P_Study;

import java.util.LinkedList;

public class P_BFS_Network {

	public static void main(String[] args) {
		int n=3;
	//	int[][] computer= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] computer= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		solution(n,computer);
	}
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        LinkedList<Integer> comp= new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Boolean[] b = new Boolean[n];
        for(int i=0;i<b.length;i++) {
        	b[i]=false;
        }
        int count=0;
        int a=0;
        for(int i=a;i<n;i++) {
        	b[i]=true;
        	System.out.println("i"+i);
        	for(int j=0;j<n;j++) {
        		if(computers[i][j]==1) {
        			if(i!=j) {
        				if(!comp.isEmpty()) {
        					if(!comp.contains(new Integer(j))) {
        						list.add(j);
        						
        					}
        				}else {
        					list.add(j);
        				}
        			}
	        				
        		}
        	}
        	System.out.println("list"+list);
        	if(!list.isEmpty()) {
        		comp.add(i);
        		a=list.removeFirst();
        	}
        	else {
        		count++;
        		comp.clear();
        		for(int k=0;k<b.length;k++) {
        			if(b[k]==false) {
        				a=k;
        				break;
        			}
        		}
        	}
        	System.out.println("comp"+comp);
        	System.out.println("list"+list);
        	System.out.println(count);
        	System.out.println("0000000000");
        }
        
        answer=count;
        return answer;
    }

}
