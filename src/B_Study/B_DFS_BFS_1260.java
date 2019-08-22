package B_Study;

import java.util.Scanner;
import java.util.Stack;

public class B_DFS_BFS_1260 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int count = 0;
      int[] info = new int[3];
      while(count<3) {
          info[count]=sc.nextInt();
          count++;
      }
      count=0;
      int[][] arr = new int[info[0]][info[0]];
      boolean[][] visited = new boolean[info[0]][info[0]];
      
      for(int i=0;i<arr.length;i++) {
         for(int j=0;j<arr[i].length;j++) {
            arr[i][j]=0;
            visited[i][j]=false;
         }
      }
      
      
      int[][] line = new int[info[1]][2];
      while(count<info[1]) {
         int a =sc.nextInt()-1;
         int b=sc.nextInt()-1;
         arr[a][b]=1;
         arr[b][a]=1;
         count++;
      }
      
      
      Stack<Integer> stack = new Stack<>();
      
      sc.close();
   }


}