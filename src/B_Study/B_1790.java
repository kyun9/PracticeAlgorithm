package B_Study;

import java.util.Scanner;

public class B_1790 {

	 public static void main(String argv[]) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        int k = sc.nextInt();
	        /*
 - 1의 자리 : 9개          글자수 :1개
 - 10의 자리 : 90개         글자수 : 2개
 - 100의 자리 : 900개       글자수 : 3개 ............... 
	         */
	        long finalNum = 0;
	        long tmp = k;
	        long cntLength = 1;  // cntLength * cntNum에서 int 범위에서 벗어나지 못한 숫자 존재
	        long cntNum = 9;
//	        System.out.println("while Before");
	        while (tmp > cntLength * cntNum) { // 0으로 하니까 이전 finalNum을 찾기 힘든 구조였음. 나올 수 있는 구조를 이렇게 바꾸는 발상 참고 필요!
//	            System.out.println("tmp : "+ tmp + " cntLength : "+ cntLength+" cntNum : "+ cntNum+" " + " finalNum : "+ finalNum);
	        	tmp -= (cntLength * cntNum); //
	            finalNum += cntNum;
	            cntLength++; // 1, 2, 3
	            cntNum *= 10; // 9, 90, 900
	        }
	        
//	        System.out.println("while After");
//	        System.out.println("tmp : "+ tmp + " cntLength : "+ cntLength+" cntNum : "+ cntNum+" " + " finalNum : "+ finalNum);
	        finalNum = (finalNum + 1) + (tmp - 1) / cntLength;
//	        System.out.println("finalNum : "+ finalNum);
	        if (finalNum > N) {
	            System.out.println(-1);
	        } else {
//	        	System.out.println("if 안");
	        	int temp = (int) ((tmp-1)%cntLength);
//	        	System.out.println("temp : "+ temp);
	            System.out.println(String.valueOf(finalNum).charAt(temp));
	        }
	    }

}
