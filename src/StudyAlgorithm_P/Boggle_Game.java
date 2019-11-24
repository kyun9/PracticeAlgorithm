package StudyAlgorithm_P;

import java.util.LinkedList;

public class Boggle_Game {

   static int[] xarr= {-1,-1,-1,0,1,1,1,0,0};  //�߽����κ��� ���� ��� x��ǥ �ð���� 8���� 
   static int[] yarr= {-1,0,1,1,1,0,-1,-1,0};   //�߽����κ��� ���� ��� y��ǥ �ð���� 8���� 
   static LinkedList<Character> qu = new LinkedList<>();
   static boolean flag=false;
   
   public static void main(String[] args) {
      char[][] arr = { { 'T', 'W', 'I', 'C', 'E' },
            { 'I', 'S', 'C', 'U', 'B' },
            { 'L', 'E', 'M', 'O', 'E' },
            { 'U', 'F', 'M', 'O', 'A' },
            { 'S', 'O', 'I', 'T', 'U' } };
      String target = "TWICE";
      firstWord(arr,target);  //firstSearch ȣ��
      System.out.println(flag);
   }
   
   //target ù���� ��� Ž��
   static void firstWord(char[][] arr, String target) {
      char[] targetArr = target.toCharArray();
      b:for(int i=0;i<arr.length;i++) {
         for(int j=0;j<arr[0].length;j++) {
            if(targetArr[0]==arr[i][j]) {
               qu.add(arr[i][j]);
               depthSearch(targetArr,i,j,arr,1);   //allSearch ȣ�� //���� �������� �Լ�ȣ��ǰ� false�ϼ� �վ�
               if(flag) {
            	   break b;
               }
            }
         }
      }
   }
   
   //������ 8�� Ž��
   static void depthSearch(char[] targetArr, int x, int y,char[][] arr, int depth) {
      int a,b;
      if(flag) return;                     //flag true �϶� ����
      else if((qu.size()==targetArr.length)) {         //��� Ż�� ����
         System.out.println(qu);
         flag=true;                        //flag�� true����
         return;
      }
      else {
         for(int i=0;i<xarr.length;i++) {   //��ǥ �ð�������� �ݺ�
            a=x+xarr[i];
            b=y+yarr[i];
            if((a>=0&&a<=4)&&(b>=0&&b<=4)) {
               if(targetArr[depth]==arr[a][b]) {
                  qu.add(arr[a][b]);
                  System.out.println(a+" "+b);
                  depthSearch(targetArr,a,b,arr,depth+1); //���ȣ��
               }
            }
            if(flag) return;                  //���� flag true��� ���̻� ��� ���� �ʴ´�.
         }
         qu.removeLast();                     //������ ���ڰ� ���ٸ� qu ��������� ����
         return; //�� �κ� �̻���  -- ��͵Ǽ� �� �̾ƹ����ϱ� �������� false�� ������ ��
      }
   }
}