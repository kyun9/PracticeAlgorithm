package coding_2020;


public class b_line {
	static String s_answer;
	static String[] s_sheets;
	static int size,result;
	public static void main(String[] args) {
		String answer_sheet = "4132315142";
		String[] sheets = {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};
		String answer_sheet2 = "53241";
		String[] sheets2 = {"53241", "42133", "53241", "14354"};
		String answer_sheet3 = "24551";
		String[] sheets3 = {"24553", "24553", "24553", "24553"};
		System.out.println(solution(answer_sheet,sheets));
		System.out.println(solution(answer_sheet2,sheets2));
		System.out.println(solution(answer_sheet3,sheets3));
	}

	static public int solution(String answer_sheet, String[] sheets) {
		int answer = -1;
		
		size = answer_sheet.length();
		s_answer = answer_sheet;
		s_sheets = new String[sheets.length];
		for(int i=0;i<sheets.length;i++) {
			s_sheets[i]=sheets[i];
		}
		
		int[] arr = new int[sheets.length];
		boolean[] visited= new boolean[sheets.length];
		
		
		result=0;
		comb(arr,visited, 0,sheets.length,2);
		
		answer = result;
		return answer;
	}
	static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
	    if(r == 0) {
	    	int[] temp = new int[2];
	    	int a=0;
	    	for(int i=0;i<n;i++) {
	    		if(visited[i]) {
	    			temp[a]=i;
	    			a++;
	    		}
	    	}
	    	int val=check(temp);
	    	result = Math.max(result, val);
	        return;
	    }
	    if(depth == n) {
	        return;
	    } else {
	        visited[depth] = true;
	        comb(arr, visited, depth + 1, n, r - 1);
	 
	        visited[depth] = false;
	        comb(arr, visited, depth + 1, n, r);
	    }
	}
	static int check(int[] temp) {
		boolean[] confirm = new boolean[size];
		for(int i=0;i<size;i++) {
			if(s_sheets[temp[0]].charAt(i)==s_sheets[temp[1]].charAt(i)) {
				if(s_sheets[temp[0]].charAt(i)!=s_answer.charAt(i)) {
					confirm[i]=true;
				}
			}
		}
		
		int problem=0;
		int val =0;
		int length=0;
		for(boolean b : confirm) {
			if(b) {
				problem++;
				val++;
			}else {
				if(val!=0) {
					if(length==0) {
						length=val;
					}
					else {
						length = Math.max(length, val);
					}
					val=0;
				}
			}
		}
		if(val!=0) {
			length = Math.max(length, val);
		}
		int value = problem + (int)Math.pow(length, 2);
		return value;
	}
}
