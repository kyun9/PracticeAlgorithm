package B_theSecondHalfOfTheYear;

import java.util.Scanner;

public class 백준_수이어쓰기2_1790 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();

		long tmp = k;
		long finalNum = 0;
		long numlength = 1;
		long numCnt = 9;

		while (tmp > numlength * numCnt) {
			tmp -= (numlength * numCnt);
			finalNum += numCnt;
			
			numlength++;
			numCnt *=10;
		}
		
		
		finalNum = (finalNum+1)+ (tmp-1)/numlength;
		if(finalNum > N) {
			System.out.println(-1);
		}else {
			int index = (int) ((tmp-1)%numlength);
			System.out.println(String.valueOf(finalNum).charAt(index));
		}
	}

}
