package B_theSecondHalfOfTheYear;

import java.util.ArrayList;
import java.util.Collections;

class AA implements Comparable<AA> {
	int idx;
	int size;

	AA(int idx, int size) {
		this.idx = idx;
		this.size = size;
	}

	@Override
	public int compareTo(AA o) {
		return this.size > o.size ? 1 : -1;
	}
}

public class 프로그래머스_튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s1 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String s2 ="{{20,111},{111}}";
		String s3 ="{{123}}";
		String s4 ="{{4,2,3},{3},{2,3,4,1},{2,3}}";
//		System.out.println(solution(s));
//		System.out.println(solution(s1));
//		System.out.println(solution(s2));
//		System.out.println(solution(s3));
		System.out.println(solution(s4));

	}

	static int[] solution(String s) {
		int[] answer = {};
		char[] cArr = s.toCharArray();

		int size = 0;
		for (int i = 1; i < cArr.length; i++) {
			if (cArr[i] == ',' && cArr[i - 1] == '}') {
				size++;
			}
		}
		ArrayList<Integer>[] list = new ArrayList[size + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		int n = 0;
		for (int i = 0; i < cArr.length - 1; i++) {
			String temp="";
			if (cArr[i] != '{' && cArr[i] != ',' && cArr[i] != '}') {
				for(int j=i;j<cArr.length;j++) {
					if(cArr[j]==',' || cArr[j]=='}') {
						i=j;
						break;
					}else {
						temp +=cArr[j];
					}
				}
				list[n].add(Integer.parseInt(temp));
				if(cArr[i]=='}') {
					n++;
				}
			}
		}

//		for (int i = 0; i < list.length; i++) {
//			for(int j=0;j<list[i].size();j++) {
//				System.out.print(list[i].get(j)+" ");
//			}
//			System.out.println();
//		}
		
		ArrayList<AA> tList = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			tList.add(new AA(i, list[i].size()));
		}
		Collections.sort(tList);
		ArrayList<Integer> resultList = new ArrayList<>();
		
		for (int i = 0; i < tList.size(); i++) {
			int idx = tList.get(i).idx;
//			System.out.println("{ idx : "+ idx);
			for(int j=0;j<list[idx].size();j++) {
				int val = list[tList.get(i).idx].get(j);
//				System.out.println("val : "+ val);
				if(!resultList.isEmpty()) {
					boolean flag= false;
					for(int k=0;k<resultList.size();k++) {
						if(val == resultList.get(k)) {
							flag =true;
						}
					}
					if(!flag) {
						resultList.add(val);
					}
				}else {
					resultList.add(val);
				}
			}
//			System.out.println("}");
		}
		
		answer = new int[size+1];
		for(int i=0;i<resultList.size();i++) {
//			System.out.println(resultList.get(i));
			answer[i]= resultList.get(i);
		}
		return answer;
	}
}
