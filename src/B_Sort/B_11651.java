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

///-----------------------------------------------------------------------
//A.compareTo(B) 일 때 A<B 인 경우는 음수를 리턴하고, A=B일 때는 0을 리턴하고, A>B일 때 양수를 리턴한다.



//omparator는 일반적이지 않은 문자열의 길이 순으로 보고 싶다든지, Comparable로 구현한 것 말고 기준으로 정렬하고 싶다든지 할 때 사용한다.
//예를 들어서 위의 예시에서 Comparable로 이름순으로 해놨다고 치자. 그런데 나는 연봉순으로 보고싶다든지 부서명으로 보고싶다든지할 수가 있다.
//이럴때마다 compareTo를 수정할 수 없고 런타임중에는 심지어 불가능한 일이다.
//대신 이럴 때 Comparator를 사용하면 정렬이 필요할 때 특수한 기준을 줄 수 있다.

//------------------------------------------------------------------------

//'리턴되는 int값이 음수이면 현재 인스턴스가 비교대상인 인스턴스보다 작고, 양수이면 크고, 0 이면 같도록 하자'


