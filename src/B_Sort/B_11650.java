package B_Sort;

import java.util.Arrays;
import java.util.Scanner;

//comparable과 comparator 사용 법 알아두자
//albe - class에 implements 하고 선언
//ator - Arrays.sort(~)를 사용할 때, 다른 정렬 기법을 사용할 때 Comparator를 쓴다고 보시면 됩니다.

class Coordinate implements Comparable<Coordinate> {
	int x;
	int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Coordinate o1) {
		if (this.x > o1.x) {
			return 1;
		} else if (this.x == o1.x) {
			if (this.y > o1.y) {
				return 1;
			} else if (this.y == o1.y) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	
	//실수한 코드
//	@Override
//	public int compare(Coordinate o1, Coordinate o2) {
//		if (o1.x > o2.x) {
//			return 1;
//		} else if (o1.x == o2.x) {
//			if (o1.y > o2.y) {
//				return 1;
//			} else if (o1.y == o2.y) {
//				return 0;
//			} else {
//				return -1;
//			}
//		} else {
//			return -1;
//		}
//
//	}

}

public class B_11650 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		Coordinate[] coor = new Coordinate[size];
		for (int i = 0; i < size; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			coor[i] = new Coordinate(x, y);
		}
		sc.close();
		Arrays.sort(coor);
		for (Coordinate a : coor)
			System.out.println(a.x + " " + a.y);
	}

}
