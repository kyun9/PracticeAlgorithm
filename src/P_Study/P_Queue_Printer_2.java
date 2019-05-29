package P_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class P_Queue_Printer_2 {
   public static class Pair {
      int idx;
      int data;
      Pair(int idx, int data) {
         this.idx = idx;
         this.data = data;
      }
   }
   public static void Solution(int[] priorities, int location) {
      Queue<Pair> q = new LinkedList<Pair>();
      Iterator<Pair> iter = null;
      int n = priorities.length;
      int[] ans = new int[n];
      int cnt = 0;
      for(int i=0; i<n; i++) {
         q.add(new Pair(i, priorities[i]));
      }
      while(!q.isEmpty()) {
         Pair p = q.remove();
         iter = q.iterator();
         boolean biggest = true;
         while(iter.hasNext()) {
            if(p.data < iter.next().data) {
               biggest = false;
            }
         }
         if(biggest) {
            ans[cnt++] = p.idx;
         } else {
            q.add(p);
         }
      }
      for(int i=0; i<ans.length; i++) {
         if(ans[i] == location) {
            System.out.println(i+1);
         }
      }
      System.out.println();
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split(" ");
      int n = s.length;
      int[] priorities = new int[n];
      for(int i=0; i<n; i++) {
         priorities[i] = Integer.parseInt(s[i]);
      }
      int location = Integer.parseInt(br.readLine());
      Solution(priorities, location);
   }
   
}