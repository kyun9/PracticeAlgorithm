package StudyAlgorithm_P;

public class p2018kakao_비밀지도 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		System.out.println(solution(n, arr1, arr2));
	}

	static public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = {};

		answer = new String[n];
		int[][] map1 = new int[n][n];
		int[][] map2 = new int[n][n];
		
		for (int i = 0; i < arr1.length; i++) {
			int cnt = n - 1;
			while (cnt != -1) {
				map1[i][cnt] = arr1[i] % 2;
				arr1[i] = arr1[i] / 2;
				cnt--;
			}

			cnt = n - 1;
			while (cnt != -1) {
				map2[i][cnt] = arr2[i] % 2;
				arr2[i] = arr2[i] / 2;
				cnt--;
			}
		}

		
		for (int i = 0; i < n; i++) {
			String s ="";
			for (int j = 0; j < n; j++) {
				if(map1[i][j]==1 ||map2[i][j]==1) {
					s+="#";
				}
				else {
					s+=" ";
				}
			}
			answer[i]= s;
		}

		return answer;
	}
}
