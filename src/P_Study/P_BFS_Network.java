package P_Study;

import java.util.ArrayList;

public class P_BFS_Network {
   public static void main(String[] args) {
      int n=3;
   //   int[][] computer= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
   //   int[][] computer= {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
   //   int[][] computer= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
   //   int[][] computer= {{1, 1, 1,1}, {1, 1, 1,1}, {1, 1, 1,1},{1,1,1,1}};
   //   int[][] computer= {{1, 1, 0,0}, {1, 1, 0,0}, {0, 0, 1,1},{0, 0, 1,1}};
      int[][] computer= {{1, 1, 0,0}, {1, 1, 1,0}, {0, 1, 1,0},{0, 0, 0,1}};
      solution(n,computer);
   }
   static ArrayList<ArrayList<Integer>> rel = new ArrayList<>(); 
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
        
        System.out.println("list :"+list);
        System.out.println("===============");
//list에 들지 않는 나머지를 계산해주면되겠찌/
        if(list.isEmpty()) {
           answer=n;
        }
        else if(list.size()==1) {
           answer=n-1;
        }
        else {
           ArrayList<Integer> qu = new ArrayList<>();
           int num=0;
           int first=-1;
           int last=-1;
           while(num<list.size()) {
              System.out.println("first : "+first +" size : " + list.size()+ " num : "+num + " list.get(num).get(0) : "+list.get(num).get(0));
              if(first==list.get(num).get(0)) {
                 System.out.println("continue");
                 continue;
              }
              else {
                 first=list.get(num).get(0);
                 last=list.get(num).get(1);
                 qu.add(first);
                 qu.add(last);
                 
                 for(int i=0;i<list.size();i++) {
                    if(last==list.get(i).get(0)) {
                       last=list.get(i).get(1);
                       qu.add(last);
                    }
                 }                                
                 System.out.println("qu : "+qu);
                 
                 rel.add(new ArrayList<>(qu));
                 System.out.println("rel : "+rel); 
                 
                 if(qu.size()==n) {
                     answer=1;
                     break;
                  }
                 qu.clear();
                 num++;
                 System.out.println("------------");
              }
           }
           answer=rel.size();
        }
        
        
        System.out.println("----------------");
        
        System.out.println(answer);
        return answer;
    }
   
   

}