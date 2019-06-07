package B_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;



/*Coordinate Ŭ������ 11650�� Ŭ�������� ������

able - class�� implements �ϰ� ����
ator - Arrays.sort(~)�� ����� ��, 
	�ٸ� ���� ����� ����� �� Comparator�� ���ٰ� ���ø� �˴ϴ�.
	
Ŭ���� ���� Comparable�� �ƴ� Comparator��  ����Ͽ� ���� ����� �ٲ�.*/







/*Comparable�� compareTo�� �����ϴµ� , natural������ �����Ѵ�.
���� ���, ���ڿ��� natural������ ���� ��.

Comparator�� �ٸ� ������ �����ϰ� ���� �� ����Ѵ�.
���� ���, ���ڿ��� ���� ������ �����ϰ� ������.*/









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
//A.compareTo(B) �� �� A<B �� ���� ������ �����ϰ�, A=B�� ���� 0�� �����ϰ�, A>B�� �� ����� �����Ѵ�.



//omparator�� �Ϲ������� ���� ���ڿ��� ���� ������ ���� �ʹٵ���, Comparable�� ������ �� ���� �������� �����ϰ� �ʹٵ��� �� �� ����Ѵ�.
//���� �� ���� ���ÿ��� Comparable�� �̸������� �س��ٰ� ġ��. �׷��� ���� ���������� ����ʹٵ��� �μ������� ����ʹٵ����� ���� �ִ�.
//�̷������� compareTo�� ������ �� ���� ��Ÿ���߿��� ������ �Ұ����� ���̴�.
//��� �̷� �� Comparator�� ����ϸ� ������ �ʿ��� �� Ư���� ������ �� �� �ִ�.

//------------------------------------------------------------------------

//'���ϵǴ� int���� �����̸� ���� �ν��Ͻ��� �񱳴���� �ν��Ͻ����� �۰�, ����̸� ũ��, 0 �̸� ������ ����'


