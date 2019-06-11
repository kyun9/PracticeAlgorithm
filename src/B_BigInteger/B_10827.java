package B_BigInteger;

import java.math.BigDecimal;
import java.util.Scanner;

public class B_10827 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      //BigInteger은 정수 BigDecimal는 소수를 의미한다.
      BigDecimal a = sc.nextBigDecimal();
      int b = sc.nextInt();
      sc.close();
      BigDecimal c;
      
      c=a.pow(b);
      
      System.out.println(c.toPlainString());
   }
   
//   toString()
//   생성자로 전달받은 값 그대로 반환한다.
//   2564000
//   2.564E+6
//   
//   toPlainString()
//   생성자로 전달받은 값을 지수 표현없이 반환한다.
//   2564000
//   2564000
//   
//   toEngineeringString()
//   생성자로 전달받은 값 중 지수 표현이 있으면 지수로 반환한다.
//   2564000
//   2.564E+6
}