package Alone;

import java.util.ArrayList;
import java.util.Arrays;

class Permutation_1{
	int n;    //순열의 사이즈 널을 변수
	int r;	  //순열의 뽑을 크기 넣을 변수
	int[] res;	// 값을 뽑을 배열 // 이 배열을 출력해줄꺼야.
	ArrayList<Integer> list; // 배열 내용을  arrayList 추가와 뺴기를 쉽게 하기 위해서 list 생성
	
	Permutation_1(int[] arr, int r){	//Permutation_1 생성자 생성
		this.n=arr.length;   
		this.r= r;
		this.res= new int[r];			// 사이즈만 정해준 배열을 만들어
		
		list = new ArrayList<>();
		for(int a : arr) {
			list.add(a);		// list에 받아온  배열 내용 추가 
		}
	}
	
	
	void perm() {					//호출하기 위한 
		perm(list,0);				// 이거에 대해 생각을 많이 했어 
	}								// main에는 list가 없자나 그래서 객체 안에 만든 list를 사용하기위해
									// 거쳐가는 method를 만든거 같에
	
	
	
	//재귀함수를 써서 순열을 뽑아 낼꺼야.
	void perm(ArrayList<Integer> list,  int depth) {
		if(depth==r) {								//재귀를 빠져나갈 조건이야.
			System.out.println(Arrays.toString(res)); // 빠져나가면서 출력해죠
			return;
		}
		
		for(int i=0;i<n-depth;i++) {			// n-depth를 두어서 순열에서 뽑아낼 만큼만 정의
			res[depth]=list.remove(i);			//앞에 원소를 기준으로 뽑아내고 list에서 제거
			perm(list,depth+1);					// 재귀함수 여기서 depth를 올려주어 재귀
												// 두번째 원소 , 세번쨰 원소 ... 정하는거
			list.add(i,res[depth]);				//재귀를 return하면서 제거한 list의 값을 다시 넣어준다.
		}
		
	}
	
}



public class Permutation_Deduplication {
	// 중복 없는 순열 만드는 법이야.
	public static void main(String[] args) {
		int r = 3;
		int[] arr = { 1, 2, 3 };

		Permutation_1 main = new Permutation_1(arr, r);  // 순열의 r값을 받지 않고 전체를 뽑을 수 있는 
														// class를 내가 만들어보자.
		main.perm();

	}

}
