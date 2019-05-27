package B_Collections;

import java.util.*;

public class B_2750 {

	public static void main(String[] args) {
		/// first
		/*
		 * Scanner sc = new Scanner(System.in); int su = sc.nextInt();
		 * 
		 * int arr[]= new int[su];
		 * 
		 * for(int i=0;i<arr.length;i++) { arr[i] = sc.nextInt(); }
		 * 
		 * Arrays.sort(arr);
		 * 
		 * for(int i =0; i<arr.length;i++) System.out.println(arr[i]);
		 */
		
		
		
		
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			
			for(int i =0;i<n;i++) {
				arr.add(sc.nextInt());
			}
			
			Collections.sort(arr);
			
			for(int i : arr)
				System.out.println(i);
		
			sc.close();
			
		
	}
	

}
