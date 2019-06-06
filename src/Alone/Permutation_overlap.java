package Alone;

import java.util.ArrayList;
import java.util.Arrays;

class Permutation_3{
	int n;    
	int[] res;	
	ArrayList<Integer> list; 
	
	Permutation_3(int[] arr){	
		this.n=arr.length;   
		this.res= new int[n];			
		
		list = new ArrayList<>();
		for(int a : arr) {
			list.add(a);		 
		}
	}
	
	
	
	void perm(int depth) {
		if(depth==n) {								
			System.out.println(Arrays.toString(res)); 
			return;
		}
		
		for(int i=0;i<n;i++) {		//앞에 Deduplication2와 다르게 remove를 안해주니까 
									// 갯수를 줄일 필요가 없겠지?
			  res[depth] = list.get(i); // 선택만 해주면되.
		        perm(depth+1);    		// 똑같은거 나와도 for문의 i 증가를 통해서 다음값이 계속나와


		}
		
	}
	
}



public class Permutation_overlap {
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3};

		Permutation_3 main = new Permutation_3(arr);  
														
		main.perm(0);

	}

}
