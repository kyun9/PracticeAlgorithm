package B_Study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_5014 {
	static int F, S, G, U, D, result;
	static int[] upDown;
	static boolean[] visited = new boolean[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();

		int[] arr = new int[F + 1];
		System.out.println(bfs(F, S, G, U, D, arr));

	}

	 public static String bfs(int Floor, int start, int end, int up, int down, int[] arr) {
	        Queue<Integer> q = new LinkedList<Integer>();
	        q.add(start);
	        arr[start] = 1;
	 
	        while (!q.isEmpty()) {
//	        	for(int i : arr) {
//	        		System.out.print(i+" ");
//	        	}
//	        	System.out.println();
//	        	for(int i: q) {
//	        		System.out.print(i+" ");
//	        	}
//	        	System.out.println();
	        	
	            int current = q.poll();
	            if (current == end) {
	                return String.valueOf(arr[current] - 1);
	            }
	            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
	            if (current + up <= Floor) {
	                if (arr[current + up] == 0) {
	                    arr[current + up] = arr[current] + 1;
	                    q.add(current + up);
	                }
	 
	            }
	            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
	            if (current - down > 0) {
	                if (arr[current - down] == 0) {
	                    arr[current - down] = arr[current] + 1;
	                    q.add(current - down);
	                }
	            }
	 
	        }
	        return "use the stairs";
	    }
}
