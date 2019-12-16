package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//그냥 전체의 방을 구현하려고 하지말고
//복도만의 배열을 생성하여
//지나 갔을 때 배열의 크기를 1씩 증가 시킨다.
//그리고 나중에 복도의 배열에서 가장 큰 값만 출력시켜주면 초를 구할 수 있다.
public class S_4408 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test = 1; test < T + 1; test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] road = new int[201];

			for (int a = 0; a < N; a++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (start % 2 == 1)
					start++;
				if (end % 2 == 1)
					end++;
				if (start > end) {
					int temp = start;
					start = end;
					end = temp;
				}
				for (int i = start / 2; i <= end / 2; i++) {
					road[i]++;
				}
			}

			int result = 0;
			for (int i = 0; i < road.length; i++) {
				result = Math.max(road[i], result);
			}

			System.out.println("#" + test + " " + result);
		}
	}

}
