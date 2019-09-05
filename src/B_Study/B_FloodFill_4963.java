package B_Study;

import java.util.Scanner;

public class B_FloodFill_4963 {
   static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
   static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
   static boolean[][] visited;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      while (true) {
         int n = sc.nextInt();
         int m = sc.nextInt();

         if(n==0 && m==0) {
            break;
         }
         int[][] arr = new int[m][n];

         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               arr[i][j] = sc.nextInt();
            }
         }

         visited = new boolean[m][n];
         int cnt = 0;
         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if (arr[i][j] == 1 && visited[i][j] == false) {
                  dfs(arr, i, j, m, n);
                  cnt++;
               }
            }
         }
         System.out.println(cnt);

      }
   }

   static void dfs(int[][] arr, int x, int y, int n, int m) {
      visited[x][y] = true;
      for (int i = 0; i < dx.length; i++) {
         int vx = x + dx[i];
         int vy = y + dy[i];

         if (vx >= 0 && vx < n && vy >= 0 && vy < m) {
            if (arr[vx][vy] == 1 && visited[vx][vy] == false) {
               dfs(arr, vx, vy, n, m);
            }
         }
      }
   }

}
//for(int i=0;i<arr.length;i++) {
//   for(int j=0;j<arr[i].length;j++) {
//      System.out.print(arr[i][j]+ " ");
//   }
//   System.out.println();
//}