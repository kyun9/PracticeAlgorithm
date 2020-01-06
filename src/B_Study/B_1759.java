package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_1759 {
	static int L,C;
	static String[] alphabet;
	static HashSet<String> set;
	static String[] vowel= {"a","e","i","o","u"};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new String[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			alphabet[i]= st.nextToken();
		}
		
		set = new HashSet<>();
		set.add("");
		
		for(int i=0;i<C;i++) {
			addHash(alphabet[i]);
		}
		
		ArrayList<String> list = new ArrayList<>();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String s = it.next();
			if(s.length()==4) {
				String[] arr = s.split("");
				Arrays.sort(arr);
				list.add(String.join("", arr));
			}
		}
		
		Collections.sort(list);
		
		boolean check=false;
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<vowel.length;j++) {
				if(list.get(i).contains(vowel[j])&&!check) {
					check=true;
					System.out.println(list.get(i));
				}
			}
			check= false;
		}
	}
	
	static void addHash(String s) {
		HashSet<String> tmp = new HashSet<>();
		tmp.addAll(set);
		Iterator<String> it = tmp.iterator();
		while(it.hasNext()) {
			set.add(it.next()+s);
		}
	}
	

}
