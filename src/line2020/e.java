package line2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Doc implements Comparable<Doc>{
	int doc;
	int count;
	Doc(int doc, int count){
		this.doc = doc;
		this.count=count;
	}
	@Override
	public int compareTo(Doc d) {
		if(this.count<d.count) {
			return 1;
		}else if(this.count==d.count){
			if(this.doc<d.doc) {
				return -1;
			}
			else {
				return 1;
			}
		}else {
			return -1;
		}
	}
}
public class e {

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };

		String[] tags = { "t1", "t2", "t3" };
		System.out.println(solution(dataSource,tags));
	}

	static public String[] solution(String[][] dataSource, String[] tags) {
		String[] answer = {};
		
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<tags.length;i++) {
			set.add(tags[i]);
		}
		ArrayList<Doc> list = new ArrayList<>();
		int cnt=0;
		for(int i=0;i<dataSource.length;i++) {
			cnt=0;
			for(int j=1;j<dataSource[i].length;j++) {
				if(set.contains(dataSource[i][j])) {
					cnt++;
				}
			}
			if(cnt!=0) {
				list.add(new Doc(dataSource[i][0].charAt(3)-'0',cnt));
			}
		}
		
		Collections.sort(list);
		answer = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i] = "doc"+ list.get(i).doc;
		}
		return answer;
	}
}
