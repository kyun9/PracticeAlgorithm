package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1296 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int L = 0, O = 0, V = 0, E = 0;
		int tmpL = 0, tmpO = 0, tmpV = 0, tmpE = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'L':
				L++;
				break;
			case 'O':
				O++;
				break;
			case 'V':
				V++;
				break;
			case 'E':
				E++;
				break;
			}
		}
		
		int N = Integer.parseInt(br.readLine().trim());
		int result=0;
		String resultName = "";
		for (int i = 0; i < N; i++) {
			tmpL = L;
			tmpO = O;
			tmpV = V;
			tmpE = E;
			String tmp = br.readLine();
			for(int j=0;j<tmp.length();j++) {
				switch (tmp.charAt(j)) {
				case 'L':
					tmpL++;
					break;
				case 'O':
					tmpO++;
					break;
				case 'V':
					tmpV++;
					break;
				case 'E':
					tmpE++;
					break;
				}
			}
			int val = ((tmpL+tmpO)*(tmpL+tmpV)*(tmpL+tmpE)*(tmpO+tmpV)*(tmpO+tmpE)*(tmpV+tmpE))%100;
			if(result<val) {
				result = val;
				resultName = tmp;
			}else if(result==val) {
				if(resultName.equals("")) {
					resultName = tmp;
				}else {
					if(resultName.compareTo(tmp)>0) {
						resultName = tmp;
					}
				}
			}
		}
		
		System.out.println(resultName);
	}

}
