package Alone;

import java.util.ArrayList;
import java.util.Arrays;

class Permutation_1{
	int n;    //������ ������ ���� ����
	int r;	  //������ ���� ũ�� ���� ����
	int[] res;	// ���� ���� �迭 // �� �迭�� ������ٲ���.
	ArrayList<Integer> list; // �迭 ������  arrayList �߰��� ���⸦ ���� �ϱ� ���ؼ� list ����
	
	Permutation_1(int[] arr, int r){	//Permutation_1 ������ ����
		this.n=arr.length;   
		this.r= r;
		this.res= new int[r];			// ����� ������ �迭�� �����
		
		list = new ArrayList<>();
		for(int a : arr) {
			list.add(a);		// list�� �޾ƿ�  �迭 ���� �߰� 
		}
	}
	
	
	void perm() {					//ȣ���ϱ� ���� 
		perm(list,0);				// �̰ſ� ���� ������ ���� �߾� 
	}								// main���� list�� ���ڳ� �׷��� ��ü �ȿ� ���� list�� ����ϱ�����
									// ���İ��� method�� ����� ����
	
	
	
	//����Լ��� �Ἥ ������ �̾� ������.
	void perm(ArrayList<Integer> list,  int depth) {
		if(depth==r) {								//��͸� �������� �����̾�.
			System.out.println(Arrays.toString(res)); // ���������鼭 �������
			return;
		}
		
		for(int i=0;i<n-depth;i++) {			// n-depth�� �ξ �������� �̾Ƴ� ��ŭ�� ����
			res[depth]=list.remove(i);			//�տ� ���Ҹ� �������� �̾Ƴ��� list���� ����
			perm(list,depth+1);					// ����Լ� ���⼭ depth�� �÷��־� ���
												// �ι�° ���� , ������ ���� ... ���ϴ°�
			list.add(i,res[depth]);				//��͸� return�ϸ鼭 ������ list�� ���� �ٽ� �־��ش�.
		}
		
	}
	
}



public class Permutation_Deduplication {
	// �ߺ� ���� ���� ����� ���̾�.
	public static void main(String[] args) {
		int r = 3;
		int[] arr = { 1, 2, 3 };

		Permutation_1 main = new Permutation_1(arr, r);  // ������ r���� ���� �ʰ� ��ü�� ���� �� �ִ� 
														// class�� ���� ������.
		main.perm();

	}

}
