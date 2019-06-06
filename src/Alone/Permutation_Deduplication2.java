package Alone;

import java.util.ArrayList;
import java.util.Arrays;

class Permutation_2{
	int n;    //������ ������ ���� ����
	int[] res;	// ���� ���� �迭 // �� �迭�� ������ٲ���.
	ArrayList<Integer> list; // �迭 ������  arrayList �߰��� ���⸦ ���� �ϱ� ���ؼ� list ����
	
	Permutation_2(int[] arr){	//Permutation_1 ������ ����
		this.n=arr.length;   
		this.res= new int[n];			// ����� ������ �迭�� �����
		
		list = new ArrayList<>();
		for(int a : arr) {
			list.add(a);		// list�� �޾ƿ�  �迭 ���� �߰� 
		}
	}
	
	
	//����Լ��� �Ἥ ������ �̾� ������.
	
//	���̸� ������ų depth�� ���� ���� ����
	void perm(int depth) {
		if(depth==n) {								//��͸� �������� �����̾�.
			System.out.println(Arrays.toString(res)); // ���������鼭 �������
			return;
		}
		
		for(int i=0;i<n-depth;i++) {			// n-depth�� �ξ �������� �̾Ƴ� ��ŭ�� ����
			res[depth]=list.remove(i);			//�տ� ���Ҹ� �������� �̾Ƴ��� list���� ����
			perm(depth+1);					// ����Լ� ���⼭ depth�� �÷��־� ���
												// �ι�° ���� , ������ ���� ... ���ϴ°�
			list.add(i,res[depth]);				//��͸� return�ϸ鼭 ������ list�� ���� �ٽ� �־��ش�.
		}
		
	}
	
}

//������ r���� ���� �ʰ� ��ü�� ���� �� �ִ� class

public class Permutation_Deduplication2 {
	// �ߺ� ���� ���� ����� ���̾�.
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 ,4};

		Permutation_2 main = new Permutation_2(arr);  
														
		main.perm(0);

	}

}
