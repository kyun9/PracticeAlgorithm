package B_Study;

import java.util.ArrayList;
import java.util.Scanner;

public class B_RepeatedSequence_2331 {
	static ArrayList<Integer> list;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int increase = sc.nextInt();
		
		list= new ArrayList<>();
		dfs(start, increase);
		System.out.println(result);
	}
	static void dfs(int start, int increase) {
		if(list.contains(start)) {
			result =list.indexOf(start);
			return;
		}
		list.add(start);
		String s = String.valueOf(start);
		int[] value = new int[s.length()];
		for(int i=0;i<s.length();i++) {
			value[i] = s.charAt(i)-'0';
		}
		int sum=0;
		for(int i:value) {
			sum+= Math.pow(i, increase);
		}
		dfs(sum,increase);
	}
}
