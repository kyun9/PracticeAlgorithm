package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(arr);
		long max = arr[K - 1];
		long min = 1;
		long mid = 0;
		int sum = 0;
		while (max >= min) {
			mid = (max + min) / 2;
			sum = 0;
			System.out.println("max : "+ max +" min : "+ min + "  mid : "+ mid);
			for (int i = 0; i < K; i++) {
				sum += arr[i] / mid;
			}
			if (sum >= N) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(max);
	}

}
