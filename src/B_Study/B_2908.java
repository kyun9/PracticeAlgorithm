package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2908 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A  = st.nextToken();
		String B = st.nextToken();
		
		A = new StringBuilder(A).reverse().toString();
		B = new StringBuilder(B).reverse().toString();
		
		String result = Integer.parseInt(A)>Integer.parseInt(B) ? A:B;
		System.out.println(result);
		
	}

}
