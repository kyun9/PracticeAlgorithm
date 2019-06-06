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
		
		for(int i=0;i<n;i++) {		//�տ� Deduplication2�� �ٸ��� remove�� �����ִϱ� 
									// ������ ���� �ʿ䰡 ������?
			  res[depth] = list.get(i); // ���ø� ���ָ��.
		        perm(depth+1);    		// �Ȱ����� ���͵� for���� i ������ ���ؼ� �������� ��ӳ���


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
