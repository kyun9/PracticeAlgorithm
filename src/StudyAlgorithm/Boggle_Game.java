package StudyAlgorithm;


public class Boggle_Game {

	static int[] xarr= {-1,-1,-1,0,1,1,1,0};  //중심으로부터 왼쪽 상단 x좌표 시계방향 8가지 
	static int[] yarr= {-1,0,1,1,1,0,-1,-1};	//중심으로부터 왼쪽 상단 y좌표 시계방향 8가지 
	
	public static void main(String[] args) {
		char[][] arr = { { 'T', 'W', 'I', 'C', 'E' },
				{ 'I', 'S', 'C', 'U', 'B' },
				{ 'L', 'E', 'M', 'O', 'E' },
				{ 'U', 'F', 'M', 'O', 'A' },
				{ 'S', 'O', 'I', 'T', 'U' } };
		String target = "TWICE";
		System.out.println(firstSearch(arr,target));  //firstSearch 호출
	}
	
	//target 첫번재 요소 탐색
	static boolean firstSearch(char[][] arr, String target) {
		char[] tmp = target.toCharArray();
		boolean b=false;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(tmp[0]==arr[i][j]) {
					b= allSearch(tmp,i,j,arr,1);   //allSearch 호출
				}
			}
		}
		return b;
	}
	
	//나머지 8개 탐색
	static boolean allSearch(char[] tmp, int x, int y,char[][] arr, int depth) {
		int a,b;
		if(depth==tmp.length) {			//재귀 탈출 조건
			return true;
		}
		else {
			for(int i=0;i<xarr.length;i++) {   //좌표 시계방향으로 반복
				a=x+xarr[i];
				b=y+yarr[i];
				if((a>=0&&a<=4)&&(b>=0&&b<=4)) {
					if(tmp[depth]==arr[a][b]) {
						allSearch(tmp,a,b,arr,depth+1); //재귀호출
					}
				}
			}
			return false;
		}
	}
}
