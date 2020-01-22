package B_Study;

import java.util.HashMap;
import java.util.Scanner;

//메모리초과
public class B_1019_self {
	static String[] arr;
	static HashMap<String, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		map = new HashMap<>();
		arr = new String[N];
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = String.valueOf(i);
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() >= 2) {
				splitWord(arr[i]);
			} else {
				addMap(arr[i]);
			}
		}
		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}

	static void splitWord(String s) {
		for(int i=0;i<s.length();i++) {
			addMap(String.valueOf(s.charAt(i)));
		}
	}

	static void addMap(String s) {
		if (map.containsKey(s)) {
			int val = map.get(s);
			map.put(s, val + 1);
		} else {
			map.put(s, 1);
		}
	}
}
