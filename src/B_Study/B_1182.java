package B_Study;

import java.util.Scanner;

public class B_1182 {
	static int val,N,S,sum;
	static int[] arr;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		result = new int[N];
		
		
		for(int i=0;i<N;i++) {
			arr[i]= sc.nextInt();
		}

		if(N==1) {
			if(arr[0]==S) {
				System.out.println(1);
				return;
			}
		}
		
		for(int i=1;i<N+1;i++) {
			perm(i, 0,0);
		}
		System.out.println(val);
	}
	
	static void perm(int dep, int depth, int start) {
		if(depth==dep) {
			sum=0;
			for(int i: result) {
				sum+=i;
			}
			if(sum==S) {
				val++;
			}
			return;
		}
		for(int i= start;i<N;i++) {
			result[depth]= arr[i];
			perm(dep, depth+1, i+1);
		}
	}

}
