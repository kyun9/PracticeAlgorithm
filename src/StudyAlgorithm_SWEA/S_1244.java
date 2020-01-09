package StudyAlgorithm_SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class S_1244 {
	static int num, n;
	static ArrayList<Integer> list;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			num = sc.nextInt();
			n = sc.nextInt();

			list = new ArrayList<>();
			while (num != 0) {
				list.add(num % 10);
				num = num / 10;
			}
			Collections.reverse(list);
			result=0;
			dfs(0,0);

			System.out.println("#" + test + " " + result);
		}
		sc.close();
	}
	static void dfs(int depth, int cmp) {
		if(depth == n) {
			String s ="";
			for(int i: list) {
				s += i;
			}
			result=Math.max(result, Integer.parseInt(s));
			return;
		}
		for(int i=cmp;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i)<=list.get(j)) {
					swap(i,j);
					dfs(depth+1,i);
					swap(i, j);
				}
			}
		}
	}
	static void swap(int i, int j) {
		int tmp= list.get(i);
		int tmp2= list.get(j);
		list.set(j, tmp);
		list.set(i, tmp2);
	}
}
