package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

//시간 초과
public class S_1486_self {
	static HashSet<Integer> set;
	static int height;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int a = 1; a < T + 1; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());

			int[] mem = new int[size];

			String[] line = br.readLine().split(" ");
			for (int i = 0; i < size; i++) {
				mem[i] = Integer.parseInt(line[i]);
			}

			set = new HashSet<>();
			for (int i = 1; i < mem.length + 1; i++) {
				int[] result = new int[i];
				perm(mem, i, 0, result);
			}

			Iterator<Integer> it = set.iterator();
			int value = Integer.MAX_VALUE;
			int tmp = 0;
			while (it.hasNext()) {
				tmp = it.next();
				if (value > tmp) {
					value = tmp;
				}
			}

			System.out.println("#" + a + " "+value);
		}

	}

	static void perm(int[] mem, int r, int depth, int[] result) {
		if (depth == r) {
			sumResult(result);
			return;
		}
		for (int i = depth; i < mem.length; i++) {
			swap(mem, i, depth);
			result[depth] = mem[depth];
			perm(mem, r, depth + 1, result);
			swap(mem, i, depth);
		}
	}

	static void swap(int[] mem, int i, int depth) {
		int temp = mem[i];
		mem[i] = mem[depth];
		mem[depth] = temp;
	}

	static void sumResult(int[] result) {
		int sum = 0;
		for (int i : result)
			sum += i;
		if (height <= sum) {
			set.add(sum);
		}
	}
}
