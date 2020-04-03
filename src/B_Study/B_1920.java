package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920 {
	static int N, M;

	// HashSet을 사용해서 처리하는 방법 -> 물론 빠름 해결됨

//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		HashSet<Integer> set = new HashSet<>();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			set.add(Integer.parseInt(st.nextToken()));
//		}
//
//		M = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < M; i++) {
//			if (set.contains(Integer.parseInt(st.nextToken()))) {
//				System.out.println(1);
//			} else {
//				System.out.println(0);
//			}
//		}
//	}
	
	
	
	//이분 탐색을 해서 처리하는 방법
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());

		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(A, n));
		}
	}

	
	//이분 탐색 메서드
	private static int binarySearch(int[] A, int n) {
		int first = 0;
		int last = A.length - 1;
		int mid = 0;

		while (first <= last) {
			mid = (first + last) / 2;

			if (n == A[mid])
				return 1;
			else {
				if (n < A[mid])
					last = mid - 1;
				else
					first = mid + 1;
			}
		}
		return 0;
	}
}
