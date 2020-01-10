package B_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_6603 {
	static int[] arr;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int size;
		while (true) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			if (size == 0) {
				break;
			}
			arr = new int[size];
			visited = new boolean[size];
			nums = new int[6];
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 6);
			System.out.println();
		}
	}

	static void dfs(int depth, int n) {
		if (depth == n) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			nums[depth] = arr[i];
			if (depth == 0) {
				dfs(depth + 1, n);
			}
			if (depth > 0 && nums[depth] > nums[depth - 1]) {
				dfs(depth + 1, n);
			}
			visited[i] = false;
		}

	}
}
