package B_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_1764 {

   public static void main(String[] args) {
      HashMap<String, Integer> hm = new HashMap<String, Integer>();
      Scanner sc = new Scanner(System.in);
      
      int n=sc.nextInt();
      int m=sc.nextInt();
      
      for(int i=0;i<n;i++) {
         String name = sc.next();
         hm.put(name, 1);
      }
      for(int i=0;i<m;i++) {
         String name =sc.next();
         Integer value = hm.get(name);
         if(value == null) {
            value =0;
         }
         else {
            value +=2;
            hm.put(name, value);
         }
      }
      
      ArrayList<String> al = new ArrayList<String>();
      for(Map.Entry<String, Integer> entry : hm.entrySet()) {
         if(entry.getValue() ==3) {
            al.add(entry.getKey());
         }
      }
      
      System.out.println(al.size());
      Collections.sort(al);
      for(String name: al) {
         System.out.println(name);
      }
      sc.close();
   }

}