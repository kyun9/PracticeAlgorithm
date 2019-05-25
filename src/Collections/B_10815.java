package Collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_10815 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		HashSet<Integer> hash = new HashSet<Integer>();
		while(st.hasMoreTokens()) {
			hash.add(Integer.parseInt(st.nextToken()));
		}
		
		int m= Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		
		StringBuffer sb = new StringBuffer();
		while(st.hasMoreTokens()) {
			if(hash.contains(Integer.parseInt(st.nextToken()))) {
				sb.append("1 ");
			}
			else
				sb.append("0 ");
		}
		
		System.out.print(sb+" ");
	}

}
