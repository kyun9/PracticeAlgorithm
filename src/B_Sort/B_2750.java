package B_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class B_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		int i=0;
		while(size >i) {
			
			arr[i]=sc.nextInt();
			
			i++;
		}
		sc.close();
		
		Arrays.sort(arr);
		for(int a : arr) 
			System.out.println(a);
	}
}
