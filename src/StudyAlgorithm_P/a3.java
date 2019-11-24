package StudyAlgorithm_P;

import java.util.ArrayList;
import java.util.Arrays;

public class a3 {
	static int flag=0;
	static ArrayList<String>[] list;
	public static void main(String[] args) {
//		System.out.println(solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
//				new String[] { "fr*d*", "abc1**" }));
		System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
				new String[] { "*rodo", "*rodo", "******"}));
//		System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
//				new String[] { "fr*d*", "*rodo", "******", "******"}));


	}

	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;

		list = (ArrayList<String>[]) new ArrayList[banned_id.length];
		for (int i = 0; i < banned_id.length; i++) {
			list[i] = new ArrayList<String>();
		}


		for (int i = 0; i < banned_id.length; i++) {
			char[] bannedArr = banned_id[i].toCharArray();
			int banSize=0;
			for(char c :bannedArr) {
				if(c!='*') {
					banSize++;
				}
			}
			for (int j = 0; j < user_id.length; j++) {
				int cnt = 0;
				char[] userArr = user_id[j].toCharArray();
				
				if (bannedArr.length == userArr.length) {
					for (int k = 0; k < bannedArr.length; k++) {
						if (bannedArr[k] == userArr[k]) {
							cnt++;
						}
					}
					if (cnt == banSize) {
						list[i].add(String.valueOf(userArr));
					} 
					else {
						int su = 0;
						for (int a = 0; a < bannedArr.length; a++) {
							if (bannedArr[a] == '*') {
								su++;
							}
						}
						if (su == bannedArr.length) {
							list[i].add(String.valueOf(userArr));
						}
					}
				}
			}
		}
		
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}
		
		ArrayList<String> rList = new ArrayList<>();
		for(int i=0;i<list.length;i++) {
			dfs(rList,i);
		}
		answer=flag;
		return answer;
	}
	
	static void dfs(ArrayList<String> rList, int depth) {
		if(depth==list.length) {
			flag++;
			return;
		}
		for(int i=0;i<depth;i++) {
			if(!rList.contains(list[depth].get(i))) {
				rList.add(list[depth].get(i));
				dfs(rList,i);
			}
		}
	}

}
