package StudyAlgorithm_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_1215 {
	static char[][] map = new char[8][8];
	static int length, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			length = Integer.parseInt(br.readLine().trim());

			for (int i = 0; i < 8; i++) {
				map[i] = br.readLine().toCharArray();
			}

			result = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - length + 1; j++) {
					String tmp = "";
					for (int k = j; k < j + length; k++) {
						tmp += map[i][k];
					}
					if (confrimString(tmp)) {
						result++;
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - length + 1; j++) {
					String tmp = "";
					for (int k = j; k < j + length; k++) {
						tmp += map[k][i];
					}
					if (confrimString(tmp)) {
						result++;
					}
				}
			}

			System.out.println("#" + test + " " + result);
		}

	}

	static boolean confrimString(String s) {
		boolean check = false;
		for (int i = 0; i < s.length(); i++) {
			if (i > s.length() - 1 - i) {
				break;
			} else {
				if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
		}

		return check;
	}
}
