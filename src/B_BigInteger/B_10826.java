package B_BigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class B_10826 {
   public static void main(String[] args) {

      // BigInteger ��� //   �迭�� ����� �Ǻ���ġ�� ����Ѱ�?

      Scanner sc = new Scanner(System.in);
      int size = sc.nextInt();
      sc.close();
      BigInteger[] b = new BigInteger[Math.max(size+1, 2)];
      
      b[0]=BigInteger.valueOf(0);
      b[1]=BigInteger.valueOf(1);
      
      for(int i=2;i<=size;i++) {
         b[i]=b[i-1].add(b[i-2]);
      }
      
      System.out.println(b[size]);
      

      
      // �׳� ��͸� ����� �Ǻ���ġ//
      
//      Scanner sc = new Scanner(System.in);
//      int size =sc.nextInt();
//      sc.close();
//      
//      for(int i=0;i<size+1;i++) {
//         System.out.println(fibo(i));
//      }
   }
   
   static int fibo(int n) {
      if(n<=1) {
         return n;
      }
      else {
         return (fibo(n-2)+fibo(n-1));
      }
   }
   
}