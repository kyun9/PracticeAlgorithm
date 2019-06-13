package StudyAlgorithm;

import java.util.LinkedList;

public class Boggle_Game {

   static int[] xarr= {-1,-1,-1,0,1,1,1,0,0};  //중심으로부터 왼쪽 상단 x좌표 시계방향 8가지 
   static int[] yarr= {-1,0,1,1,1,0,-1,-1,0};   //중심으로부터 왼쪽 상단 y좌표 시계방향 8가지 
   static LinkedList<Character> qu = new LinkedList<>();
   static boolean flag=false;
   
   public static void main(String[] args) {
      char[][] arr = { { 'T', 'W', 'I', 'C', 'E' },
            { 'I', 'S', 'C', 'U', 'B' },
            { 'L', 'E', 'M', 'O', 'E' },
            { 'U', 'F', 'M', 'O', 'A' },
            { 'S', 'O', 'I', 'T', 'U' } };
      String target = "OMO";
      firstWord(arr,target);  //firstSearch 호출
      System.out.println(flag);
   }
   
   //target 첫번재 요소 탐색
   static void firstWord(char[][] arr, String target) {
      char[] targetArr = target.toCharArray();
      for(int i=0;i<arr.length;i++) {
         for(int j=0;j<arr[0].length;j++) {
            if(targetArr[0]==arr[i][j]) {
               qu.add(arr[i][j]);
               depthSearch(targetArr,i,j,arr,1);   //allSearch 호출 //여기 여러개의 함수호출되고 false일수 잇어
            }
         }
      }
   }
   
   //나머지 8개 탐색
   static void depthSearch(char[] targetArr, int x, int y,char[][] arr, int depth) {
      int a,b;
      if(flag) return;                     //flag true 일때 종료
      else if((qu.size()==targetArr.length)) {         //재귀 탈출 조건
         System.out.println(qu);
         flag=true;                        //flag를 true설정
         return;
      }
      else {
         for(int i=0;i<xarr.length;i++) {   //좌표 시계방향으로 반복
            a=x+xarr[i];
            b=y+yarr[i];
            if((a>=0&&a<=4)&&(b>=0&&b<=4)) {
               if(targetArr[depth]==arr[a][b]) {
                  qu.add(arr[a][b]);
                  System.out.println(a+" "+b);
                  depthSearch(targetArr,a,b,arr,depth+1); //재귀호출
               }
            }
            if(flag) return;                  //만일 flag true라면 더이상 재귀 하지 않는다.
         }
         qu.removeLast();                     //다음에 글자가 없다면 qu 마지막요소 제거
         return; //이 부분 이상해  -- 재귀되서 다 뽑아버리니까 마지막에 false로 끝나는 거
      }
   }
}