package B_theSecondHalfOfTheYear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 백준_연산자끼워넣기_14888 {
	static int N;
	static int[] A;
	static int[] op = new int[4];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}
		
		solve(1, A[0]);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}

	static void solve(int depth, int sum) {
		if(depth==N) {
			list.add(sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(op[i]==0) {
				continue;
			}
			op[i]-=1;
			switch(i){
				case 0:
					solve(depth+1,sum+A[depth]);
					break;
				case 1:
					solve(depth+1,sum-A[depth]);
					break;
				case 2:
					solve(depth+1,sum*A[depth]);
					break;
				case 3:
					solve(depth+1,sum/A[depth]);
					break;
			}
			op[i]+=1;
		}
	}
}
