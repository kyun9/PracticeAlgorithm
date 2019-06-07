package B_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;



/*Coordinate 클래스는 11650의 클래스에서 가져옴

able - class에 implements 하고 선언
ator - Arrays.sort(~)를 사용할 때, 
	다른 정렬 기법을 사용할 때 Comparator를 쓴다고 보시면 됩니다.
	
클래스 내의 Comparable이 아닌 Comparator을  사용하여 정렬 기법을 바꿈.*/







/*Comparable은 compareTo를 구현하는데 , natural순서를 정의한다.
예를 들면, 문자열의 natural순서는 사전 순.

Comparator는 다른 순서로 정렬하고 싶을 때 사용한다.
예를 들면, 문자열을 길이 순으로 정렬하고 싶을때.*/



public class B_11651 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Coordinate[] cd = new Coordinate[size];
		int x, y;
		for (int i = 0; i < size; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			cd[i]= new Coordinate(x,y);
		}
		Arrays.sort(cd, new Comparator<Coordinate>(){

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				if(o1.y>o2.y) {
					return 1;
				}
				else if(o1.y==o2.y) {
					if(o1.x>o2.x) {
						return 1;
					}
					else if(o1.x==o2.x) {
						return 0;
					}
					else
						return -1;
				}
				else
					return -1;
					
			}
			
		});
		
		for (Coordinate a : cd)
			System.out.println(a.x + " " + a.y);
		sc.close();
	}

}
