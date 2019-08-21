package Review;

import java.util.Stack;

public class P_Greedy_HighNumber {
   public static void main(String[] args) {
//      System.out.println(solution("1924", 2));
      System.out.println(solution("1010", 2));
   }
   public static String solution(String number, int k) {
      String answer="";
      
      char[] c = number.toCharArray();
      Stack<Character> stack = new Stack<>();
      char[] result = new char[number.length()-k];
      
      for(int i=0;i<c.length;i++) {
         while(!stack.isEmpty()&&stack.peek()<c[i]&&k-->0) {
            stack.pop();
         }
         stack.push(c[i]);
      }
      
      for(int i=0;i<result.length;i++) {
         result[i]=stack.get(i);
         answer+=result[i];
      }
      
      
      
      return answer;
   }
}

//String answer = "";
//Stack<Character> stack = new Stack<>();
//char[] result = new char[number.length()-k];
//
//for(int i=0; i<number.length();i++) {
//   char c = number.charAt(i);
//   while(!stack.isEmpty()&&stack.peek()<c&&k-->0) {
//      stack.pop();         }
//   stack.push(c);
//}
//for(int i =0;i<result.length;i++) {
//   result[i]=stack.get(i);
//}
//
//answer = String.valueOf(result);
//return answer;