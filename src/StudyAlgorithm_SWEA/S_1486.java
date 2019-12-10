package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class S_1486 {
	static HashSet<Integer> set= new HashSet<>();
	static int height;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int a = 1; a < T + 1; a++) {
			set.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());

			int[] mem = new int[size];

			String[] line = br.readLine().split(" ");
			for (int i = 0; i < size; i++) {
				mem[i] = Integer.parseInt(line[i]);
			}
			
			set.add(0);
			for(int i : mem) {
				addCase(i);
			}
			
			ArrayList<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			
			
			int result=0;
			for(int i: list) {
				if(height<=i) {
					result = i;
					break;
				}
			}
			result -= height;
			System.out.println("#"+a+" "+result);
		}
	}
	static void addCase(int num) {
		HashSet<Integer> temp = new HashSet<>();
		temp.addAll(set);
		Iterator<Integer> it = temp.iterator();
		while(it.hasNext()) {
			set.add(it.next()+num);
		}
	}

}
