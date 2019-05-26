package Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B_7785 {

	public static void main(String[] args) {
		HashSet<String> hash = new HashSet<String>();
		Scanner sc = new Scanner(System.in);
		String[]  s = null;
		int su = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<su;i++) {
			s=sc.nextLine().split(" ");
			if(s[1].equals("enter"))
				hash.add(s[0]);
			else if(s[1].equals("leave"))
				hash.remove(s[0]);
		}
		
		String[] data = hash.toArray(new String[hash.size()]);
		
		Arrays.sort(data);
		
		for(int i= data.length-1;i>=0;i--) {
			System.out.println(data[i]);
		}
		sc.close();
	}

}
