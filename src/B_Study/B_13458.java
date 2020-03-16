package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13458 {
	static int N,B,C,result;
	static int[] room;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		room = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			room[i]= Integer.parseInt(st.nextToken());
		}
		
		st= new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long result=0;
		int tmp=0;
		for(int i=0;i<N;i++) {
			tmp=0;
			if(room[i]-B<0) {
				result++;
			}else {
				result++;
				tmp = room[i]-B;
				result+=Math.ceil((float)tmp/C);
			}
		}
		System.out.println(result);
	}

}
