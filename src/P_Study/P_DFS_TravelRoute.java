package P_Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class P_DFS_TravelRoute {
	static boolean[][] check;
	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "COO" }, { "COO", "ICN" },{ "COO", "ICN" } }; 
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets = 	{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		System.out.println(solution(tickets));
	}

	public static String[] solution(String[][] tickets) {
		String[] answer = {};

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < tickets.length; i++) {
			set.add(tickets[i][0]);
		}
		ArrayList<String>[] list = (ArrayList<String>[]) new ArrayList[set.size()];
		int n = 0;
		for (String s : set) {
			list[n] = new ArrayList<String>();
			list[n].add(s);
			n++;
		}
		ArrayList<String> tlist = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < tickets.length; j++) {
				if(list[i].get(0).equals(tickets[j][0])) {
					tlist.add(tickets[j][1]);
				}
			}
			Collections.sort(tlist);
			list[i].addAll(tlist);
			tlist.clear();
		}
		
		check= new boolean[list.length][];
		int start = 0;
		for(int i=0;i<list.length;i++) {
			check[i]= new boolean[list[i].size()];
			if(list[i].get(0).equals("ICN")) {
				start=i;
			}
		}
		answer = new String[tickets.length + 1];
		answer[0]="ICN";
		dfs(list,answer,start,0);
		for(String s:answer) {
			System.out.print(s+" ");
		}
		return answer;
	}
	static void dfs(ArrayList<String>[] list, String[] answer,int c,int depth) {
		check[c][0]=true;
		for(int i=1;i<list[c].size();i++) {
			if(check[c][i]) continue;
			
			boolean flag = true;
			for(int j=0;j<list.length;j++) {
				if(list[c].get(i).equals(list[j].get(0))) {
					check[c][i]=true;
					answer[depth+1]= list[c].get(i);
					dfs(list,answer,j,depth+1);
					return;
				}
				flag=(check[j][0])?true:false;
			}
			if(flag) {
				answer[depth+1]=list[c].get(i);
			}
		}
	}
}


//ArrayList
//
//public class P_DFS_TravelRoute {
//	static boolean[][] check;
//	public static void main(String[] args) {
//		String[][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" },{ "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
////		String[][] tickets = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" } };
////		String[][] tickets = { { "ICN", "COO" }, { "COO", "ICN" },{ "COO", "ICN" } }; 
////		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
////		String[][] tickets = 	{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//		System.out.println(solution(tickets));
//	}
//
//	public static String[] solution(String[][] tickets) {
//		String[] answer = {};
//
//		HashSet<String> set = new HashSet<>();
//		for (int i = 0; i < tickets.length; i++) {
//			set.add(tickets[i][0]);
//		}
//		ArrayList<String>[] list = (ArrayList<String>[]) new ArrayList[set.size()];
//		int n = 0;
//		for (String s : set) {
//			list[n] = new ArrayList<String>();
//			list[n].add(s);
//			n++;
//		}
//		ArrayList<String> tlist = new ArrayList<>();
//		for (int i = 0; i < list.length; i++) {
//			for (int j = 0; j < tickets.length; j++) {
//				if(list[i].get(0).equals(tickets[j][0])) {
//					tlist.add(tickets[j][1]);
//				}
//			}
//			Collections.sort(tlist);
//			list[i].addAll(tlist);
//			tlist.clear();
//		}
//		
//		check= new boolean[list.length][];
//		int start = 0;
//		for(int i=0;i<list.length;i++) {
//			check[i]= new boolean[list[i].size()];
//			if(list[i].get(0).equals("ICN")) {
//				start=i;
//			}
//		}
//		ArrayList<String> result= new ArrayList<>();
//		result.add("ICN");
//		dfs(list,result,start,0);
//		answer = new String[result.size()];
//		n=0;
//		for(String s:result) {
//			answer[n]=s;
//			n++;
//		}
//		for(String s:answer) {
//			System.out.print(s+" ");
//		}
//		return answer;
//	}
//	static void dfs(ArrayList<String>[] list, ArrayList<String> result,int c,int depth) {
//		check[c][0]=true;
//		for(int i=1;i<list[c].size();i++) {
//			if(check[c][i]) continue;
//			
//			boolean flag = true;
//			for(int j=0;j<list.length;j++) {
//				if(list[c].get(i).equals(list[j].get(0))) {
//					check[c][i]=true;
//					result.add(list[c].get(i));
//					dfs(list,result,j,depth+1);
//					return;
//				}
//				flag=(check[j][0])?true:false;
//			}
//			if(flag) {
//				result.add(list[c].get(i));
//				return;
//			}
//		}
//	}
//}

