package B_Collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_11279 {

   
   static class Compare implements Comparator<Integer>{
      
      @Override
      public int compare(Integer o1, Integer o2) {
         return o2.compareTo(o1);
      }
      
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      PriorityQueue<Integer> pq = new PriorityQueue<>(new Compare());
      
      
      int size = sc.nextInt();
      int value =0;
      
      while(size -- >0) {
         value = sc.nextInt();
         
         if(value ==0) {
            if(pq.isEmpty()) System.out.println(0);
            else System.out.println(pq.poll());
         }
         else {
            pq.offer(value);
         }
      }
      sc.close();
   }

}