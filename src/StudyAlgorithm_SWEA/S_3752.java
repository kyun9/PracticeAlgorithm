package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class S_3752 {
	static HashSet<Integer> hs = new HashSet<>();;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.valueOf(br.readLine());

		for (int a = 1; a < T + 1; a++) {
			hs.clear();
			int N = Integer.valueOf(br.readLine());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.valueOf(st.nextToken());
			}

			hs.add(0);	
			for (int i : arr) {
				setSelect(i);  
				//메소드를 만들어준 이유는 Set에서 Iterator로 바로 처리하면 멀티 쓰래드떄문에 
				//ConcurrentModificationException 예외를 뱉는다.
				//그래서 메소드로 보내어 임시 hashset에서 담았다가 다시 hs로 보내는 것으로 처리한다.
			}

			System.out.println("#" + a+" " + hs.size());
		}
	}

	static void setSelect(int num) {
		HashSet<Integer> tmp = new HashSet<>();
		tmp.addAll(hs);
		Iterator<Integer> it = tmp.iterator();
		while (it.hasNext()) {
			hs.add(it.next() + num);
		}
	}

}
