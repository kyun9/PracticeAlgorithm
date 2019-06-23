package P_Study;

public class P_DP_Tile {

	public static void main(String[] args) {
		System.out.println(solution1(5));
	}

	public static long solution(int N) {
		long answer = 0;
		
		answer=(fibo(N+1)+fibo(N))*2;
		
		return answer;
	}

	public static int fibo(int n) {
		if (n <= 1)
			return n;
		else
			return fibo(n - 2) + fibo(n - 1);
	}
/////////////////////////////////// 윗풀이 효율성 
	
	
	public static long solution1(int N) {
		long answer = 0;
		long x =1;
		long y=1;
		
		if(N==1) {
		}
		else{
			for(int i=1;i<N;i++) {
				if(i%2==0) {
					x=x+y;
				}
				else {
					y=y+x;
				}
			}
		}
		
		answer=(x+y)*2;
		return answer;
	}
	
}
