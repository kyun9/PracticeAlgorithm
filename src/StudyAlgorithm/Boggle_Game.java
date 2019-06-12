package StudyAlgorithm;


public class Boggle_Game {

	static int[] xarr= {-1,-1,-1,0,1,1,1,0};  //�߽����κ��� ���� ��� x��ǥ �ð���� 8���� 
	static int[] yarr= {-1,0,1,1,1,0,-1,-1};	//�߽����κ��� ���� ��� y��ǥ �ð���� 8���� 
	
	public static void main(String[] args) {
		char[][] arr = { { 'T', 'W', 'I', 'C', 'E' },
				{ 'I', 'S', 'C', 'U', 'B' },
				{ 'L', 'E', 'M', 'O', 'E' },
				{ 'U', 'F', 'M', 'O', 'A' },
				{ 'S', 'O', 'I', 'T', 'U' } };
		String target = "TWICE";
		System.out.println(firstSearch(arr,target));  //firstSearch ȣ��
	}
	
	//target ù���� ��� Ž��
	static boolean firstSearch(char[][] arr, String target) {
		char[] tmp = target.toCharArray();
		boolean b=false;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(tmp[0]==arr[i][j]) {
					b= allSearch(tmp,i,j,arr,1);   //allSearch ȣ��
				}
			}
		}
		return b;
	}
	
	//������ 8�� Ž��
	static boolean allSearch(char[] tmp, int x, int y,char[][] arr, int depth) {
		int a,b;
		if(depth==tmp.length) {			//��� Ż�� ����
			return true;
		}
		else {
			for(int i=0;i<xarr.length;i++) {   //��ǥ �ð�������� �ݺ�
				a=x+xarr[i];
				b=y+yarr[i];
				if((a>=0&&a<=4)&&(b>=0&&b<=4)) {
					if(tmp[depth]==arr[a][b]) {
						allSearch(tmp,a,b,arr,depth+1); //���ȣ��
					}
				}
			}
			return false;
		}
	}
}
