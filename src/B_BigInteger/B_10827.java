package B_BigInteger;

import java.math.BigDecimal;
import java.util.Scanner;

public class B_10827 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      //BigInteger�� ���� BigDecimal�� �Ҽ��� �ǹ��Ѵ�.
      BigDecimal a = sc.nextBigDecimal();
      int b = sc.nextInt();
      sc.close();
      BigDecimal c;
      
      c=a.pow(b);
      
      System.out.println(c.toPlainString());
   }
   
//   toString()
//   �����ڷ� ���޹��� �� �״�� ��ȯ�Ѵ�.
//   2564000
//   2.564E+6
//   
//   toPlainString()
//   �����ڷ� ���޹��� ���� ���� ǥ������ ��ȯ�Ѵ�.
//   2564000
//   2564000
//   
//   toEngineeringString()
//   �����ڷ� ���޹��� �� �� ���� ǥ���� ������ ������ ��ȯ�Ѵ�.
//   2564000
//   2.564E+6
}