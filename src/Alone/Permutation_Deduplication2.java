package Alone;

import java.util.ArrayList;
import java.util.Arrays;

class Permutation_2{
	int n;    //순열의 사이즈 널을 변수
	int[] res;	// 값을 뽑을 배열 // 이 배열을 출력해줄꺼야.
	ArrayList<Integer> list; // 배열 내용을  arrayList 추가와 뺴기를 쉽게 하기 위해서 list 생성
	
	Permutation_2(int[] arr){	//Permutation_1 생성자 생성
		this.n=arr.length;   
		this.res= new int[n];			// 사이즈만 정해준 배열을 만들어
		
		list = new ArrayList<>();
		for(int a : arr) {
			list.add(a);		// list에 받아온  배열 내용 추가 
		}
	}
	
	
	//재귀함수를 써서 순열을 뽑아 낼꺼야.
	
//	깊이를 증가시킬 depth를 없앴 수가 없어
	void perm(int depth) {					//depth는 res의 크기를 의미해 //재귀를 하면서 인덱스 증가
		if(depth==n) {								
			System.out.println(Arrays.toString(res)); 
			return;
		}
		
		for(int i=0;i<n-depth;i++) {	// n-depth를 하는이유가 list를 remove하니까 당연히 크기를 줄여주고
										// add해줄떄는 재귀를 통해 크기가 유지되니까
			res[depth]=list.remove(i);			//앞에 원소를 기준으로 뽑아내고 list에서 제거(중복제거)
			perm(depth+1);					// 재귀함수 여기서 depth를 올려주어 재귀
												// 두번째 원소 , 세번쨰 원소 ... 정하는거
			list.add(i,res[depth]);				//재귀를 return하면서 제거한 list의 값을 다시 넣어준다.
		}
		
	}
	
}

//순열의 r값을 받지 않고 전체를 뽑을 수 있는 class

public class Permutation_Deduplication2 {
	// 중복 없는 순열 만드는 법이야.
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3};

		Permutation_2 main = new Permutation_2(arr);  
														
		main.perm(0);

	}

}
