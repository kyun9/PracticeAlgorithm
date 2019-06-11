package B_BigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class B_10757 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      BigInteger a = sc.nextBigInteger();
      BigInteger b = sc.nextBigInteger();
      sc.close();
      BigInteger c;
      
      c=a.add(b);
      
      System.out.println(c);
   }
}