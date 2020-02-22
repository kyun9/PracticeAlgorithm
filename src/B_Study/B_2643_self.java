package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


//다시풀어보기
class Papper implements Comparable<Papper> {
	int w;
	int h;

	Papper(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public int compareTo(Papper o) {
		if (this.w > o.w) {
			return 1;
		} else if (this.w == o.w) {
			if (this.h > o.h) {
				return 1;
			} else if (this.h == o.h) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

}

public class B_2643_self {
	static int N;
	static ArrayList<Papper> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		list = new ArrayList<Papper>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a >= b) {
				list.add(new Papper(a, b));
			} else {
				list.add(new Papper(b, a));
			}
		}

//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i).w + " " + list.get(i).h);
//			System.out.println();
//		}
		Collections.sort(list);
//		System.out.println("sort");
//		System.out.println();
//
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i).w + " " + list.get(i).h);
//			System.out.println();
//		}
//
//		System.out.println();
//		while (true) {
//			boolean check = false;
//			for (int i = 0; i < list.size() - 1; i++) {
//				if (list.get(i).w < list.get(i + 1).w) {
//					list.remove(i + 1);
//					check = true;
//					break;
//				}
//			}
//			if (check) {
//				continue;
//			} else {
//				break;
//			}
//		}
//		System.out.println();

		int result = 1;
		boolean check = true;
		while (check) {
			result=1;
			check = false;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).w >= list.get(i - 1).w && list.get(i).h >= list.get(i - 1).h) {
					result++;
				} else {
					list.remove(i);
					check = true;
					break;
				}
			}
			if(check) {
				continue;
			}
			break;
		}
		System.out.println(result);
	}

}
