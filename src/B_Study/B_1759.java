package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

class Su {
	int v;
	int con;

	Su(int v, int con) {
		this.v = v;
		this.con = con;
	}
}

public class B_1759 {
	static int L, C;
	static String[] alphabet;
	static HashSet<String> set;
	static String vowel ="aeiou";
	static ArrayList<Su> su;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alphabet = new String[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken();
		}

		set = new HashSet<>();
		set.add("");

		for (int i = 0; i < C; i++) {
			addHash(alphabet[i]);
		}

		ArrayList<String> list = new ArrayList<>();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s.length() == L) {
				String[] arr = s.split("");
				Arrays.sort(arr);
				list.add(String.join("", arr));
			}
		}

		Collections.sort(list);

		su = new ArrayList<>();
		int v = 0;
		int con = 0;
		for (int i = 0; i < list.size(); i++) {
			v = 0;
			con = 0;
			for (int j = 0; j < list.get(i).length(); j++) {
				if (vowel.contains(String.valueOf(list.get(i).charAt(j)))) {
					v += 1;
				} else {
					con += 1;
				}
			}
			su.add(new Su(v, con));
		}

		for (int i = 0; i < su.size(); i++) {
			if (su.get(i).v >= 1 && su.get(i).con >= 2) {
				System.out.println(list.get(i));
			}
		}
	}

	static void addHash(String s) {
		HashSet<String> tmp = new HashSet<>();
		tmp.addAll(set);
		Iterator<String> it = tmp.iterator();
		while (it.hasNext()) {
			set.add(it.next() + s);
		}
	}

}
